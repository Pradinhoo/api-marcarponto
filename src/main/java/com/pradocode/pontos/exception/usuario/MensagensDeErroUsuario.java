package com.pradocode.pontos.exception.usuario;

public class MensagensDeErroUsuario {
    public static final String USUARIO_NAO_ENCONTRADO = "Usuário com ID %s não encontrado";
    public static final String USUARIO_NAO_ATIVO = "Usuário com ID %s não está ativo no banco de dados";
    public static final String USUARIO_JA_CADASTRADO = "Usuário com o CPF digitado já cadastrado no banco de dados!";
    public static final String USUARIO_JA_ATIVADO = "Usuário com o ID %s já está como ativo no banco de dados!";

    public MensagensDeErroUsuario() {}
}
