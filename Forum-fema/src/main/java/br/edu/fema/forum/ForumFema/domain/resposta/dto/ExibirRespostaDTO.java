package br.edu.fema.forum.ForumFema.domain.resposta.dto;

import br.edu.fema.forum.ForumFema.domain.resposta.model.Resposta;

import java.time.format.DateTimeFormatter;

public class ExibirRespostaDTO {
    private String mensagem;
    private String topico;
    private String dataCriacao;
    private String autor;
    private Boolean solucao;
    private Integer likes;

    public ExibirRespostaDTO() {
    }

    public ExibirRespostaDTO(String mensagem, String topico, String dataCriacao, String autor, Boolean solucao, Integer likes) {
        this.mensagem = mensagem;
        this.topico = topico;
        this.dataCriacao = dataCriacao;
        this.autor = autor;
        this.solucao = solucao;
        this.likes = likes;
    }

    public static ExibirRespostaDTO copiarDaEntidadeProDTO(Resposta entidade){
        ExibirRespostaDTO resposta = new ExibirRespostaDTO();
        resposta.mensagem = entidade.getMensagem();
        resposta.topico = entidade.getTopico().getTitulo();
        resposta.dataCriacao = entidade.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        resposta.autor = entidade.getAutor().getNome();
        resposta.solucao = entidade.getSolucao();
        resposta.likes = entidade.getLikes();

        return resposta;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTopico() {
        return topico;
    }

    public void setTopico(String topico) {
        this.topico = topico;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
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
}
