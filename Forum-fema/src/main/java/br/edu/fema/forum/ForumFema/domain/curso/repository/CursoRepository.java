package br.edu.fema.forum.ForumFema.domain.curso.repository;

import br.edu.fema.forum.ForumFema.domain.curso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
