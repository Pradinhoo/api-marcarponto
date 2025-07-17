package com.pradocode.pontos.exception.ponto;

public class CpfInvalidoException extends RuntimeException {
    public CpfInvalidoException(Long idUsuario) {
        super(String.format(MensagensDeErroPonto.CPF_INVALIDO, idUsuario));
    }
}
