package br.edu.fema.forum.ForumFema.domain.usuario.repository;

import br.edu.fema.forum.ForumFema.domain.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
