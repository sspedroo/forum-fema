package br.edu.fema.forum.ForumFema.domain.resposta.repository;

import br.edu.fema.forum.ForumFema.domain.resposta.model.Resposta;
import br.edu.fema.forum.ForumFema.domain.topico.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {

    List<Resposta> findByTopico(Topico topico);
}
