package br.edu.fema.forum.ForumFema.controller;

import br.edu.fema.forum.ForumFema.domain.topico.dto.ExibirTopicoDTO;
import br.edu.fema.forum.ForumFema.domain.topico.dto.SalvarTopicoDTO;
import br.edu.fema.forum.ForumFema.domain.topico.model.StatusTopico;
import br.edu.fema.forum.ForumFema.domain.topico.service.TopicoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topico")
@Tag(name = "Topico Controller")
public class TopicoController {
    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity<ExibirTopicoDTO> salvarTopico(@RequestBody @Valid SalvarTopicoDTO dto){
        ExibirTopicoDTO topico = topicoService.salvarTopico(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(topico);
    }


    @GetMapping("/curso")
    public ResponseEntity<List<ExibirTopicoDTO>> findCursoByNome(String nomeDoCurso){
        List<ExibirTopicoDTO> byCursoNome = topicoService.findByCursoNome(nomeDoCurso);
        return ResponseEntity.ok(byCursoNome);
    }

    @GetMapping("/status")
    public ResponseEntity<List<ExibirTopicoDTO>> findByStatus(StatusTopico status){
        List<ExibirTopicoDTO> byStatus = topicoService.findByStatus(status);
        return ResponseEntity.ok(byStatus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExibirTopicoDTO> encontrarTopicoPorId(@PathVariable("id") Long id){
        ExibirTopicoDTO topico = topicoService.encontrarTopicoPorId(id);
        return ResponseEntity.ok(topico);
    }
}
