package br.edu.fema.forum.ForumFema.domain.topico.service;

import br.edu.fema.forum.ForumFema.domain.curso.repository.CursoRepository;
import br.edu.fema.forum.ForumFema.domain.topico.dto.ExibirTopicoDTO;
import br.edu.fema.forum.ForumFema.domain.topico.dto.SalvarTopicoDTO;
import br.edu.fema.forum.ForumFema.domain.topico.model.StatusTopico;
import br.edu.fema.forum.ForumFema.domain.topico.model.Topico;
import br.edu.fema.forum.ForumFema.domain.topico.repository.TopicoRepository;
import br.edu.fema.forum.ForumFema.domain.usuario.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicoService {
    private final TopicoRepository topicoRepository;
    private final CursoRepository cursoRepository;
    private final UsuarioRepository usuarioRepository;

    public TopicoService(TopicoRepository topicoRepository, CursoRepository cursoRepository, UsuarioRepository usuarioRepository) {
        this.topicoRepository = topicoRepository;
        this.cursoRepository = cursoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public ExibirTopicoDTO salvarTopico(SalvarTopicoDTO dto){
        Topico topico = new Topico();
        topico.setTitulo(dto.getTitulo());
        topico.setMensagem(dto.getDescricao());
        topico.setCurso(cursoRepository.findById(dto.getCursoId())
                .orElseThrow(() -> new EntityNotFoundException("Curso com o ID: " + dto.getCursoId() + " não encontrado.")));
        topico.setCriadoPor(usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new EntityNotFoundException("Usuario com o ID: " + dto.getUsuarioId() + " não encontrado.")));

        topicoRepository.save(topico);
        return ExibirTopicoDTO.copiarDaEntidadeProDto(topico);
    }

    @Transactional(readOnly = true)
    public List<ExibirTopicoDTO> findByCursoNome(String nomeDoCurso){
        List<Topico> byCursoNome = topicoRepository.findByCursoNome(nomeDoCurso);
        return byCursoNome.stream().map(ExibirTopicoDTO::copiarDaEntidadeProDto).toList();
    }

    public List<ExibirTopicoDTO> findByStatus(StatusTopico status){
        List<Topico> byStatus = topicoRepository.findByStatus(status);
        return byStatus.stream().map(ExibirTopicoDTO::copiarDaEntidadeProDto).toList();
    }

    @Transactional
    public void arquivarTopico(Long id){
        try {
            Topico topico = topicoRepository.getReferenceById(id);
            topico.setArquivado(true);
            topico.setStatus(StatusTopico.FECHADO);

            topicoRepository.save(topico);

        } catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Topico não encontrado.");
        }
    }

    @Transactional(readOnly = true)
    public ExibirTopicoDTO encontrarTopicoPorId(Long id){
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Topico com o ID: " + id + " não encontrado."));
        return ExibirTopicoDTO.copiarDaEntidadeProDto(topico);
    }
}
