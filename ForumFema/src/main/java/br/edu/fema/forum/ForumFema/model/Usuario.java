package br.edu.fema.forum.ForumFema.model;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
