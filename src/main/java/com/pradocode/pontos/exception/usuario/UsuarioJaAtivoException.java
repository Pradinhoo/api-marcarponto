package com.pradocode.pontos.exception.usuario;

public class UsuarioJaAtivoException extends RuntimeException {
    public UsuarioJaAtivoException(Long idUsuario) {
        super(String.format(MensagensDeErroUsuario.USUARIO_JA_ATIVADO, idUsuario));
    }
}
