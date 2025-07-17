package com.pradocode.pontos.validations.usuario;

import com.pradocode.pontos.dto.CadastrarUsuarioDTO;
import com.pradocode.pontos.exception.usuario.UsuarioJaCadastradoException;
import com.pradocode.pontos.model.Usuario;
import com.pradocode.pontos.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VerificaUsuarioExistente {

    private final UsuarioRepository usuarioRepository;

    public VerificaUsuarioExistente(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void verificacao(CadastrarUsuarioDTO cadastrarUsuarioDTO) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByCpf(cadastrarUsuarioDTO.cpf());

        if (usuarioOptional.isPresent()) {
            throw new UsuarioJaCadastradoException();
        }
    }
}
