package com.pradocode.pontos.exception.usuario;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(Long idUsuario) {
        super(String.format(MensagensDeErroUsuario.USUARIO_NAO_ENCONTRADO, idUsuario));
    }
}
