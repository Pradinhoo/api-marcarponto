package com.pradocode.pontos.validations.ponto;

import com.pradocode.pontos.dto.MarcarPontoDTO;
import com.pradocode.pontos.exception.ponto.ApenasFuncionariosException;
import com.pradocode.pontos.model.Funcao;
import com.pradocode.pontos.model.Usuario;
import com.pradocode.pontos.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VerificaFuncaoUsuario implements VerificacaoMarcarPonto {

    private final UsuarioRepository usuarioRepository;

    public VerificaFuncaoUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void verificacao(MarcarPontoDTO marcarPontoDTO) {
        Optional<Usuario> usuario = usuarioRepository.findById(marcarPontoDTO.idUsuario());

        if (usuario.isPresent() && usuario.get().getFuncao().equals(Funcao.ADMIN)) {
            throw new ApenasFuncionariosException();
        }
    }
}
