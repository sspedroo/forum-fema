package br.edu.fema.forum.ForumFema.domain.curso.dto;

import br.edu.fema.forum.ForumFema.domain.curso.model.Curso;

import java.time.format.DateTimeFormatter;

public class ExibirCursoDTO {
    private Long id;
    private String nome;
    private String categoria;
    private String criadoEm;
    private String atualizadoEm;

    public ExibirCursoDTO() {
    }

    public ExibirCursoDTO(Long id, String nome, String categoria, String criadoEm, String atualizadoEm) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public static ExibirCursoDTO copiarDaEntidadeProDto (Curso entidade){
        ExibirCursoDTO dto = new ExibirCursoDTO();
        dto.id = entidade.getId();
        dto.nome = entidade.getNome();
        dto.categoria = entidade.getCategoria();
        dto.criadoEm = entidade.getCriadoEm().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        dto.atualizadoEm = (entidade.getAtualizadoEm() == null) ? null : entidade.getAtualizadoEm().format(DateTimeFormatter.ofPattern("dd/MM" +
                "/yyyy HH:mm:ss"));

        return dto;
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

    public String getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(String criadoEm) {
        this.criadoEm = criadoEm;
    }

    public String getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(String atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
}
