package com.pradocode.pontos.service;

import com.pradocode.pontos.dto.CadastrarUsuarioDTO;
import com.pradocode.pontos.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Long cadastrarNovoUsuario(CadastrarUsuarioDTO cadastrarUsuarioDTO);
    List<Usuario> listarUsuariosAtivos();
    List<Usuario> listarUsuariosNaoAtivos();
    void desativarUsuario(Long idUsuario);
    void ativarUsuario(Long idUsuario);

}
