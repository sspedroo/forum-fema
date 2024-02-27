package br.edu.fema.forum.ForumFema.domain.curso.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@Entity(name = "tb_curso")
@Table(name = "tb_curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nome;
    private String categoria;
    @Column(updatable = false, columnDefinition = "DATETIME")
    private LocalDateTime criadoEm;

    public Curso (){

    }

    public Curso(String nome, String categoria){
        this.nome = nome;
        this.categoria = categoria;
    }

    @PrePersist
    public void executarAntesDeSalvar(){
        criadoEm = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id) && Objects.equals(nome, curso.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
