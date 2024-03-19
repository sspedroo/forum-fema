package br.edu.fema.forum.ForumFema.domain.usuario.service;

import br.edu.fema.forum.ForumFema.domain.usuario.dto.SalvarUsuarioDTO;
import br.edu.fema.forum.ForumFema.domain.usuario.dto.ExibirUsuarioDTO;
import br.edu.fema.forum.ForumFema.domain.usuario.model.Usuario;
import br.edu.fema.forum.ForumFema.domain.usuario.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public ExibirUsuarioDTO salvarUsuario(SalvarUsuarioDTO dto){
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        usuarioRepository.save(usuario);
        return ExibirUsuarioDTO.copiarDaEntidadeProDto(usuario);
    }

    @Transactional(readOnly = true)
    public ExibirUsuarioDTO encontrarUsuarioPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario com o ID: " + id + " não encontrado."));
        return ExibirUsuarioDTO.copiarDaEntidadeProDto(usuario);
    }
}
