package com.pradocode.pontos.service;

import com.pradocode.pontos.dto.CadastrarUsuarioDTO;
import com.pradocode.pontos.exception.usuario.UsuarioJaAtivoException;
import com.pradocode.pontos.exception.usuario.UsuarioNaoAtivoException;
import com.pradocode.pontos.exception.usuario.UsuarioNaoEncontradoException;
import com.pradocode.pontos.model.Usuario;
import com.pradocode.pontos.repository.UsuarioRepository;

import com.pradocode.pontos.validations.usuario.VerificaUsuarioExistente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final VerificaUsuarioExistente verificaUsuarioExistente;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, VerificaUsuarioExistente verificaUsuarioExistente) {
        this.usuarioRepository = usuarioRepository;
        this.verificaUsuarioExistente = verificaUsuarioExistente;
    }

    public Long cadastrarNovoUsuario(CadastrarUsuarioDTO cadastrarUsuarioDTO) {
        verificaUsuarioExistente.verificacao(cadastrarUsuarioDTO);
        Usuario novoUsuario = new Usuario(cadastrarUsuarioDTO.nome(),
                cadastrarUsuarioDTO.cpf(),
                cadastrarUsuarioDTO.funcao());
        usuarioRepository.save(novoUsuario);
        return novoUsuario.getId();
    }

    public List<Usuario> listarUsuariosAtivos() {
        return usuarioRepository.findAllByEmAtividadeTrue();
    }

    public List<Usuario> listarUsuariosNaoAtivos() {
        return usuarioRepository.findAllByEmAtividadeFalse();
    }

    public void desativarUsuario(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(idUsuario));

        if (Boolean.TRUE.equals(usuario.getEmAtividade())) {
            usuario.desativarUsuario();
            usuarioRepository.save(usuario);
        } else {
            throw new UsuarioNaoAtivoException(idUsuario);
        }
    }

    public void ativarUsuario(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(idUsuario));

        if (Boolean.FALSE.equals(usuario.getEmAtividade())) {
            usuario.ativarUsuario();
            usuarioRepository.save(usuario);
        } else {
            throw new UsuarioJaAtivoException(idUsuario);
        }
    }
}
