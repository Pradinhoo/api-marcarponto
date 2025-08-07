package com.pradocode.pontos.exception.ponto;

public class MensagensDeErroPonto {
    public static final String CPF_INVALIDO = "Os 4 primeiros dígitos do CPF não correspondem ao usuário com ID %s";
    public static final String APENAS_FUNCIONARIOS = "Apenas funcionparios devem marcar ponto!";
    public static final String HORARIO_NAO_PERMITIDO = "Não é possível marcar o ponto antes das 08h00!";
    public static final String TODOS_OS_PONTOS_JA_MARCADOS = "Usuário já registrou todos os pontos do dia!";

    public MensagensDeErroPonto() {}
}
