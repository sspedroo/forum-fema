package br.edu.fema.forum.ForumFema.controller;

import br.edu.fema.forum.ForumFema.domain.curso.dto.ExibirCursoDTO;
import br.edu.fema.forum.ForumFema.domain.curso.dto.SalvarCursoDTO;
import br.edu.fema.forum.ForumFema.domain.curso.service.CursoService;
import br.edu.fema.forum.ForumFema.utils.CollectionsResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/curso")
@Tag(name = "Curso Controller")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<CollectionsResponse> encontrarTodosCursos(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(value = "linesPerPage", defaultValue = "40") Integer linesPerPage,
                                                                    @RequestParam(value = "direction", defaultValue = "DESC") String direction,
                                                                    @RequestParam(value = "orderBy", defaultValue = "id") String orderBy){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        Page<ExibirCursoDTO> cursos = cursoService.encontrarTodosOsCursos(pageRequest);
        return ResponseEntity.ok(CollectionsResponse.builder(cursos.getContent(), cursos.hasNext()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExibirCursoDTO> encontrarCursoPorId(@PathVariable("id") Long id){
        ExibirCursoDTO curso = cursoService.encontrarCursoPorId(id);
        return ResponseEntity.ok(curso);
    }

    @PostMapping
    public ResponseEntity<ExibirCursoDTO> salvarNovoCurso(@RequestBody @Valid SalvarCursoDTO dto){
        ExibirCursoDTO curso = cursoService.salvarCurso(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(curso);
    }

    @PutMapping("{id}")
    public ResponseEntity<ExibirCursoDTO> editarCurso(@PathVariable("id") Long id,
                                                      @RequestBody @Valid SalvarCursoDTO dto){
        ExibirCursoDTO curso = cursoService.editarCurso(id, dto);
        return ResponseEntity.ok(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCursoPorId(@PathVariable("id") Long id){
        cursoService.deletarCursoPorId(id);
        return ResponseEntity.noContent().build();
    }
}
