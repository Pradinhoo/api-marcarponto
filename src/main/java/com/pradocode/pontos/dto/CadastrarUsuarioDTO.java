package com.pradocode.pontos.dto;

import com.pradocode.pontos.model.Funcao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastrarUsuarioDTO(

        @NotBlank (message = "O campo NOME é obrigatório")
        String nome,
        @NotBlank (message = "O campo CPF é obrigatório")
        String cpf,
        @NotNull (message = "O campo FUNÇÃO é obrigatório")
        Funcao funcao) {
}
