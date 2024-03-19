package br.edu.fema.forum.ForumFema.controller;

import br.edu.fema.forum.ForumFema.domain.resposta.dto.ExibirRespostaDTO;
import br.edu.fema.forum.ForumFema.domain.resposta.dto.NovaRespostaDTO;
import br.edu.fema.forum.ForumFema.domain.resposta.service.RespostaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/resposta")
@Tag(name = "Resposta Controller")
public class RespostaController {
    private final RespostaService respostaService;

    public RespostaController(RespostaService respostaService) {
        this.respostaService = respostaService;
    }

    @PostMapping
    public ResponseEntity<ExibirRespostaDTO> novaResposta(@RequestBody @Valid NovaRespostaDTO dto){
        ExibirRespostaDTO resposta = respostaService.novaResposta(dto);
        return ResponseEntity.ok(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRespostaPorId(@PathVariable("id") Long id){
        respostaService.deletarMensagemPorId(id);
        return ResponseEntity.noContent().build();
    }
}
