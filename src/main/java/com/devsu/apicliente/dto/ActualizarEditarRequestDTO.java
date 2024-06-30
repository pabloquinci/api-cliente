package com.devsu.apicliente.dto;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarEditarRequestDTO {
    private Long idPersona;
    @Nullable
    private String nombre;
    @Nullable
    private String genero;
    @Nullable
    private Integer edad;
    @Nullable
    private Long dni;
    @Nullable
    private String direccion;
    @Nullable
    private Long telefono;
    @Nullable
    private String contrasenia;
}
