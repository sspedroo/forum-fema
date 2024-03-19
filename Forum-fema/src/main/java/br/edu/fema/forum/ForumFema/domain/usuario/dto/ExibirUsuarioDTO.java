package br.edu.fema.forum.ForumFema.domain.usuario.dto;

import br.edu.fema.forum.ForumFema.domain.topico.model.Topico;
import br.edu.fema.forum.ForumFema.domain.usuario.model.Usuario;

import java.util.List;

public class ExibirUsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private List<Topico> topicosInscritos;

    public ExibirUsuarioDTO() {
    }

    public ExibirUsuarioDTO(Long id, String nome, String email, String senha, List<Topico> topicosInscritos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.topicosInscritos = topicosInscritos;
    }

    public static ExibirUsuarioDTO copiarDaEntidadeProDto(Usuario entidade){
        ExibirUsuarioDTO usuarioDTO = new ExibirUsuarioDTO();
        usuarioDTO.id = entidade.getId();
        usuarioDTO.nome = entidade.getNome();
        usuarioDTO.email = entidade.getEmail();
        usuarioDTO.senha = entidade.getSenha();
        usuarioDTO.topicosInscritos = entidade.getTopicosInscritos();
        return usuarioDTO;
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

    public List<Topico> getTopicosInscritos() {
        return topicosInscritos;
    }

    public void setTopicosInscritos(List<Topico> topicosInscritos) {
        this.topicosInscritos = topicosInscritos;
    }
}
