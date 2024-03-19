package br.edu.fema.forum.ForumFema.domain.resposta.dto;

public class NovaRespostaDTO {
    private String mensagem;
    private Long topicoId;
    private Long usuarioId;

    public NovaRespostaDTO() {
    }

    public NovaRespostaDTO(String mensagem, Long topicoId, Long usuarioId) {
        this.mensagem = mensagem;
        this.topicoId = topicoId;
        this.usuarioId = usuarioId;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Long getTopicoId() {
        return topicoId;
    }

    public void setTopicoId(Long topicoId) {
        this.topicoId = topicoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
