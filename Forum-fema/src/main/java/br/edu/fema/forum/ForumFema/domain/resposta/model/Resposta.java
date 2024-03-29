package br.edu.fema.forum.ForumFema.domain.resposta.model;

import br.edu.fema.forum.ForumFema.domain.topico.model.Topico;
import br.edu.fema.forum.ForumFema.domain.usuario.model.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@Entity
@Table(name = "tb_resposta")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String mensagem;
    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;
    @Column(updatable = false, columnDefinition = "DATETIME")
    private LocalDateTime dataCriacao;
    @ManyToOne
    private Usuario autor;
    private Boolean solucao;
    private Integer likes;


    public Resposta (){

    }

    public Resposta (String mensagem, Topico topico, Usuario usuario){
        this.mensagem = mensagem;
        this.topico = topico;
        this.dataCriacao = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        this.autor = usuario;
        this.solucao = false;
    }

    @PrePersist
    private void executarAntesDeSalvar(){
        dataCriacao = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        likes = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Boolean getSolucao() {
        return solucao;
    }

    public void setSolucao(Boolean solucao) {
        this.solucao = solucao;
    }

    public Integer getLikes() {
        return likes;
    }
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resposta resposta = (Resposta) o;
        return Objects.equals(id, resposta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
