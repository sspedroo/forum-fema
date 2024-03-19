package br.edu.fema.forum.ForumFema.domain.topico.repository;

import br.edu.fema.forum.ForumFema.domain.topico.model.StatusTopico;
import br.edu.fema.forum.ForumFema.domain.topico.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findByCursoNome(String nomeCurso);

    List<Topico> findByStatus(StatusTopico status);

}
