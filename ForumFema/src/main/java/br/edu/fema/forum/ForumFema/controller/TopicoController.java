package br.edu.fema.forum.ForumFema.controller;

import br.edu.fema.forum.ForumFema.controller.dto.TopicoDto;
import br.edu.fema.forum.ForumFema.model.Curso;
import br.edu.fema.forum.ForumFema.model.Topico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicoController {
    @RequestMapping("/topicos")
    public List<TopicoDto> lista(){
        Topico topico1 = new Topico("Duvida + jakarta", "Dúvida com Spring",
                new Curso("Spring", "Programação"));
        Topico topico2 = new Topico("Duvida + jakarta", "Dúvida com API Rest",
                new Curso("Spring", "Programação"));

        return TopicoDto.converter(Arrays.asList(topico1,topico1,topico1,topico2));
    }

}
