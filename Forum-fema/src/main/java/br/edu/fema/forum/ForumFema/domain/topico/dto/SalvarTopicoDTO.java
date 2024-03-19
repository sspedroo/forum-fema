package br.edu.fema.forum.ForumFema.domain.topico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SalvarTopicoDTO {
    @NotBlank(message = "Obrigatório titulo")
    @Size(min = 8)
    private String titulo;
    @NotBlank(message = "Obrigatório descrição")
    private String descricao;
    @NotNull(message = "Obrigatório ID do autor")
    private Long usuarioId;
    @NotNull(message = "Obrigatório ID do curso")
    private Long cursoId;

    public SalvarTopicoDTO() {
    }

    public SalvarTopicoDTO(String titulo, String descricao, Long usuarioId, Long cursoId) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.usuarioId = usuarioId;
        this.cursoId = cursoId;
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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}
