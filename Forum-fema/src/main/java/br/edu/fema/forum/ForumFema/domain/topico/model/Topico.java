package br.edu.fema.forum.ForumFema.domain.topico.model;

import br.edu.fema.forum.ForumFema.domain.usuario.model.Usuario;
import br.edu.fema.forum.ForumFema.domain.curso.model.Curso;
import br.edu.fema.forum.ForumFema.domain.resposta.model.Resposta;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "tb_topico")
@Table(name = "tb_topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String titulo;
    private String mensagem;
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime dataCriacao;
    @Enumerated(EnumType.STRING)
    private StatusTopico status;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario criadoPor;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private Boolean arquivado;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Resposta> respostas;

    public Topico(){

    }

    public Topico(String titulo, String mensagem, Curso curso, Usuario usuario){
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        this.status = StatusTopico.NAO_RESPONDIDO;
        this.curso = curso;
        this.criadoPor = usuario;
        this.respostas = new LinkedList<>();
    }
    @PrePersist
    private void executarAntesDeSalvar(){
        dataCriacao = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        status = StatusTopico.NAO_RESPONDIDO;
        respostas = new LinkedList<>();
        arquivado = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public void setStatus(StatusTopico status) {
        this.status = status;
    }

    public Usuario getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(Usuario criadoPor) {
        this.criadoPor = criadoPor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public Boolean getArquivado() {
        return arquivado;
    }

    public void setArquivado(Boolean arquivado) {
        this.arquivado = arquivado;
    }
}
