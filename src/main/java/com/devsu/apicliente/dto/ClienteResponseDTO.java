package com.devsu.apicliente.dto;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteResponseDTO {
    private Long idPersona;
    @Nullable
    private String nombre;
    @Nullable
    private Long dni;
    @Nullable
    private String direccion;
    @Nullable
    private Long telefono;
    @Nullable
    private Integer edad;
    @Nullable
    private String genero;
}
