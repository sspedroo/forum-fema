package br.edu.fema.forum.ForumFema.domain.resposta.service;

import br.edu.fema.forum.ForumFema.domain.resposta.dto.ExibirRespostaDTO;
import br.edu.fema.forum.ForumFema.domain.resposta.dto.NovaRespostaDTO;
import br.edu.fema.forum.ForumFema.domain.resposta.model.Resposta;
import br.edu.fema.forum.ForumFema.domain.resposta.repository.RespostaRepository;
import br.edu.fema.forum.ForumFema.domain.topico.model.StatusTopico;
import br.edu.fema.forum.ForumFema.domain.topico.model.Topico;
import br.edu.fema.forum.ForumFema.domain.topico.repository.TopicoRepository;
import br.edu.fema.forum.ForumFema.domain.usuario.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RespostaService {
    private final RespostaRepository respostaRepository;
    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;

    public RespostaService(RespostaRepository respostaRepository, TopicoRepository topicoRepository, UsuarioRepository usuarioRepository) {
        this.respostaRepository = respostaRepository;
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public ExibirRespostaDTO novaResposta(NovaRespostaDTO dto){
        Resposta resposta = new Resposta();
        Topico topico = topicoRepository.findById(dto.getTopicoId())
                .orElseThrow(() -> new EntityNotFoundException("Topico com o ID: " + dto.getTopicoId() + " não encontrado."));

        resposta.setMensagem(dto.getMensagem());
        resposta.setTopico(topico);
        resposta.setAutor(usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new EntityNotFoundException("Usuario com o ID: " + dto.getUsuarioId() + " não encontrado.")));

//        topico.getRespostas().add(resposta);
        topico.setStatus(StatusTopico.NAO_SOLUCIONADO);
        topicoRepository.save(topico);

        respostaRepository.save(resposta);
        return ExibirRespostaDTO.copiarDaEntidadeProDTO(resposta);
    }

    public ExibirRespostaDTO editarResposta(Long id, String mensagem){
        try{
            Resposta resposta = respostaRepository.getReferenceById(id);
            resposta.setMensagem(mensagem);
            resposta.setLikes(0);

            respostaRepository.save(resposta);
            return ExibirRespostaDTO.copiarDaEntidadeProDTO(resposta);
        } catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Resposta não encontrada");
        }
    }

    @Transactional
    public void deletarMensagemPorId(Long id){
        Resposta resposta = respostaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mensagem não encontrada."));
        respostaRepository.delete(resposta);
    }
}
