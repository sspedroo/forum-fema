package br.edu.fema.forum.ForumFema.domain.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SalvarUsuarioDTO {
    @NotBlank(message = "Nome obrigatório.")
    private String nome;
    @NotBlank(message = "Email obrigatório.")
    @Email
    private String email;
    @NotBlank
    @Size(min = 6, message = "Senha deve conter no minímo 6 caracteres")
    private String senha;

    public SalvarUsuarioDTO() {
    }

    public SalvarUsuarioDTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
