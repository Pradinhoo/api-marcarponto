package com.pradocode.pontos.exception.ponto;

public class QuatroPontosJaMarcadosException extends RuntimeException {
    public QuatroPontosJaMarcadosException() {
        super(MensagensDeErroPonto.TODOS_OS_PONTOS_JA_MARCADOS);
    }
}
