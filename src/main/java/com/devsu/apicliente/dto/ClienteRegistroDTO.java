package com.devsu.apicliente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRegistroDTO {
    private String nombre;
    private String genero;
    private Integer edad;
    private Long dni;
    private String direccion;
    private Long telefono;
    private String contrasenia;
}
