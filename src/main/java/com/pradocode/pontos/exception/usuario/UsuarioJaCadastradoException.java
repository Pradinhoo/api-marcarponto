package com.pradocode.pontos.exception.usuario;

public class UsuarioJaCadastradoException extends RuntimeException {
    public UsuarioJaCadastradoException() {
        super(MensagensDeErroUsuario.USUARIO_JA_CADASTRADO);
    }
}
