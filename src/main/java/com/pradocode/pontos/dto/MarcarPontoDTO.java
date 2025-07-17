package com.pradocode.pontos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MarcarPontoDTO(

        @NotNull
        Long idUsuario,
        @NotBlank
        String inicioCpf) {
}
