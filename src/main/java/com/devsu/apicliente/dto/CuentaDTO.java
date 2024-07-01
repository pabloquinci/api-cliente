package com.devsu.apicliente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaDTO {
    private Long idCuenta;
    private Integer numCuenta;
    private Integer dni;
}
