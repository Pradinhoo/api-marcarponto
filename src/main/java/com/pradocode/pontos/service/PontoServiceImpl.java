package com.pradocode.pontos.service;

import com.pradocode.pontos.dto.MarcarPontoDTO;

import com.pradocode.pontos.model.Ponto;
import com.pradocode.pontos.model.Usuario;
import com.pradocode.pontos.repository.PontoRepository;
import com.pradocode.pontos.repository.UsuarioRepository;
import com.pradocode.pontos.validations.ponto.VerificacaoMarcarPonto;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PontoServiceImpl implements PontoService {

    private final UsuarioRepository usuarioRepository;
    private final PontoRepository pontoRepository;
    private final List<VerificacaoMarcarPonto> listaDeVerificacoes;

    public PontoServiceImpl(UsuarioRepository usuarioRepository, PontoRepository pontoRepository, List<VerificacaoMarcarPonto> listaDeVerificacoes) {
        this.usuarioRepository = usuarioRepository;
        this.pontoRepository = pontoRepository;
        this.listaDeVerificacoes = listaDeVerificacoes;
    }

    public void marcarPonto(MarcarPontoDTO marcarPontoDTO) {
        listaDeVerificacoes.forEach(v -> v.verificacao(marcarPontoDTO));

        Optional<Usuario> usuario = usuarioRepository.findById(marcarPontoDTO.idUsuario());

        pontoRepository.save(new Ponto(LocalDateTime.now(), usuario.get()));
    }
}
