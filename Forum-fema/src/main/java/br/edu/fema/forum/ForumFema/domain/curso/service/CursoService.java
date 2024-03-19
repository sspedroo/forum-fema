package br.edu.fema.forum.ForumFema.domain.curso.service;

import br.edu.fema.forum.ForumFema.domain.curso.dto.ExibirCursoDTO;
import br.edu.fema.forum.ForumFema.domain.curso.dto.SalvarCursoDTO;
import br.edu.fema.forum.ForumFema.domain.curso.model.Curso;
import br.edu.fema.forum.ForumFema.domain.curso.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    public ExibirCursoDTO salvarCurso(SalvarCursoDTO cursoDTO){
        Curso novoCurso = new Curso();
        novoCurso.setNome(cursoDTO.getNome());
        novoCurso.setCategoria(cursoDTO.getCategoria());

        cursoRepository.save(novoCurso);
        return ExibirCursoDTO.copiarDaEntidadeProDto(novoCurso);
    }

    @Transactional(readOnly = true)
    public ExibirCursoDTO encontrarCursoPorId(Long id){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso com o ID: " + id + " não encontrado."));
        return ExibirCursoDTO.copiarDaEntidadeProDto(curso);
    }

    @Transactional(readOnly = true)
    public Page<ExibirCursoDTO> encontrarTodosOsCursos(PageRequest pageRequest){
        Page<Curso> cursos = cursoRepository.findAll(pageRequest);
        return cursos.map(ExibirCursoDTO::copiarDaEntidadeProDto);
    }

    @Transactional
    public ExibirCursoDTO editarCurso(Long id, SalvarCursoDTO dto){
        try {
            Curso cursoRecuperado = cursoRepository.getReferenceById(id);
            cursoRecuperado.setNome(dto.getNome());
            cursoRecuperado.setCategoria(dto.getCategoria());
            cursoRecuperado.setAtualizadoEm(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));

            cursoRepository.save(cursoRecuperado);
            return ExibirCursoDTO.copiarDaEntidadeProDto(cursoRecuperado);
        } catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Curso com o ID: " + id + " não encontrado.");
        }
    }

    @Transactional
    public void deletarCursoPorId(Long id){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso com o ID: " + id + " não encontrado."));
        cursoRepository.delete(curso);
    }
}
