package com.pradocode.pontos.exception.usuario;

public class UsuarioNaoAtivoException extends RuntimeException {
    public UsuarioNaoAtivoException(Long idUsuario) {
        super(String.format(MensagensDeErroUsuario.USUARIO_NAO_ATIVO, idUsuario));
    }
}
