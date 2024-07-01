package com.devsu.apicliente.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRegistroDTO {
    @NotNull
    private String nombre;
    @NotNull
    private String genero;
    @NotNull
    private Integer edad;
    @NotNull
    private Long dni;
    @NotNull
    private String direccion;
    @NotNull
    private Long telefono;
    @NotNull
    private String contrasenia;
}
