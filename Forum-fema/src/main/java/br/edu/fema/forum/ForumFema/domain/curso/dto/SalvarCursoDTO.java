package br.edu.fema.forum.ForumFema.domain.curso.dto;

import jakarta.validation.constraints.NotBlank;

public class SalvarCursoDTO {
    @NotBlank(message = "Nome do curso não pode ser vazio.")
    private String nome;
    @NotBlank(message = "Nome da categoria não pode ser vazia.")
    private String categoria;

    public SalvarCursoDTO() {
    }

    public SalvarCursoDTO(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
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
}
