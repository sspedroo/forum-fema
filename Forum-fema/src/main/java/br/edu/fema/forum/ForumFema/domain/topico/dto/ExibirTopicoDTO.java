package br.edu.fema.forum.ForumFema.domain.topico.dto;

import br.edu.fema.forum.ForumFema.domain.resposta.dto.ExibirRespostaDTO;
import br.edu.fema.forum.ForumFema.domain.topico.model.StatusTopico;
import br.edu.fema.forum.ForumFema.domain.topico.model.Topico;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExibirTopicoDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private String dataCriacao;
    private StatusTopico status;
    private String criadoPor;
    private String curso;
    private List<ExibirRespostaDTO> respostas;

    public ExibirTopicoDTO() {
    }

    public static ExibirTopicoDTO copiarDaEntidadeProDto(Topico entidade){
        ExibirTopicoDTO topico = new ExibirTopicoDTO();
        topico.setId(entidade.getId());
        topico.setTitulo(entidade.getTitulo());
        topico.setDescricao(entidade.getMensagem());
        topico.setDataCriacao(entidade.getDataCriacao()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        topico.setStatus(entidade.getStatus());
        topico.setCriadoPor(entidade.getCriadoPor().getNome());
        topico.setCurso(entidade.getCurso().getNome());

        topico.setRespostas((entidade.getRespostas() == null) ? null : entidade.getRespostas()
                .stream()
                .map(ExibirRespostaDTO::copiarDaEntidadeProDTO)
                .toList());

        return topico;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public void setStatus(StatusTopico status) {
        this.status = status;
    }

    public String getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(String criadoPor) {
        this.criadoPor = criadoPor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<ExibirRespostaDTO> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<ExibirRespostaDTO> respostas) {
        this.respostas = respostas;
    }
}
