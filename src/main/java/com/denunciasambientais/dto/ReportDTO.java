package com.denunciasambientais.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReportDTO(
        @NotBlank(message = "A descrição da denúncia é obrigatória")
        String descricao,

        @NotNull(message = "O ID do usuário é obrigatório")
        Long usuarioId,

        @NotNull(message = "O ID da categoria é obrigatório")
        Long categoriaId,

        String localizacao
) {}
