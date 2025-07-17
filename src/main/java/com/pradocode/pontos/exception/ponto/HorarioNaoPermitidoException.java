package com.pradocode.pontos.exception.ponto;

public class HorarioNaoPermitidoException extends RuntimeException {
    public HorarioNaoPermitidoException() {
        super(MensagensDeErroPonto.HORARIO_NAO_PERMITIDO);
    }
}
