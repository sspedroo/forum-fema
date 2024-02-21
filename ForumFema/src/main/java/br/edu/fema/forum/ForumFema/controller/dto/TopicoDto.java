package br.edu.fema.forum.ForumFema.controller.dto;

import br.edu.fema.forum.ForumFema.model.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoDto {
    private Long id;
    private String titlo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    public TopicoDto(Topico topico){
        super();
        this.id = topico.getId();
        this.titlo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }

    public static List<TopicoDto> converter(List<Topico> topicos){
        return  topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
    }

}
