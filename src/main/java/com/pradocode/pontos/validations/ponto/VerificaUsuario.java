package com.pradocode.pontos.validations.ponto;

import com.pradocode.pontos.dto.MarcarPontoDTO;
import com.pradocode.pontos.exception.usuario.UsuarioNaoEncontradoException;
import com.pradocode.pontos.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

@Component
public class VerificaUsuario implements VerificacaoMarcarPonto {

    private final UsuarioRepository usuarioRepository;

    public VerificaUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void verificacao(MarcarPontoDTO marcarPontoDTO) {
        usuarioRepository.findById(marcarPontoDTO.idUsuario())
                .orElseThrow(() -> new UsuarioNaoEncontradoException(marcarPontoDTO.idUsuario()));
    }
}
