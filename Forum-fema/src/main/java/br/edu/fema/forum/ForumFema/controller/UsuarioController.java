package br.edu.fema.forum.ForumFema.controller;

import br.edu.fema.forum.ForumFema.domain.usuario.dto.ExibirUsuarioDTO;
import br.edu.fema.forum.ForumFema.domain.usuario.dto.SalvarUsuarioDTO;
import br.edu.fema.forum.ForumFema.domain.usuario.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuario Controller")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<ExibirUsuarioDTO> salvarUsuario(@RequestBody @Valid SalvarUsuarioDTO dto){
        ExibirUsuarioDTO usuario = usuarioService.salvarUsuario(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }
}
