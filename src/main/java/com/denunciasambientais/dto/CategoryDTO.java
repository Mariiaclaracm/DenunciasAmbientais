package com.denunciasambientais.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryDTO(
        @NotBlank(message = "O nome da categoria é obrigatório")
        String nome
) {}
