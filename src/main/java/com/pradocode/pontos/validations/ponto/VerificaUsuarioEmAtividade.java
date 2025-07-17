package com.pradocode.pontos.validations.ponto;

import com.pradocode.pontos.dto.MarcarPontoDTO;
import com.pradocode.pontos.exception.usuario.UsuarioNaoAtivoException;
import com.pradocode.pontos.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

@Component
public class VerificaUsuarioEmAtividade implements VerificacaoMarcarPonto {

    private final UsuarioRepository usuarioRepository;

    public VerificaUsuarioEmAtividade(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void verificacao(MarcarPontoDTO marcarPontoDTO) {
        usuarioRepository.findByIdAndEmAtividadeTrue(marcarPontoDTO.idUsuario())
                .orElseThrow(() -> new UsuarioNaoAtivoException(marcarPontoDTO.idUsuario()));
    }
}
