package com.pradocode.pontos.validations.ponto;

import com.pradocode.pontos.dto.MarcarPontoDTO;
import com.pradocode.pontos.exception.ponto.CpfInvalidoException;
import com.pradocode.pontos.model.Usuario;
import com.pradocode.pontos.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VerificaCpfUsuario implements VerificacaoMarcarPonto {

    private final UsuarioRepository usuarioRepository;

    public VerificaCpfUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void verificacao(MarcarPontoDTO marcarPontoDTO) {
        Optional<Usuario> usuario = usuarioRepository.findById(marcarPontoDTO.idUsuario());

        String inicioCpfRecebido = marcarPontoDTO.inicioCpf();
        String inicioCpfUsuario = usuario.get().getCpf().substring(0,4);

        if (!inicioCpfRecebido.matches(inicioCpfUsuario)) {
            throw new CpfInvalidoException(marcarPontoDTO.idUsuario());
        }
    }
}
