package com.pradocode.pontos.exception.ponto;

public class ApenasFuncionariosException extends RuntimeException {
    public ApenasFuncionariosException() {
        super(MensagensDeErroPonto.APENAS_FUNCIONARIOS);
    }
}
