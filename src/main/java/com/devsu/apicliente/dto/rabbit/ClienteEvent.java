package com.devsu.apicliente.dto.rabbit;

import com.devsu.apicliente.dto.CuentaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEvent {
    private String status; // pending, progress, completed
    private String message;
    private ClienteDTO cliente;
}
