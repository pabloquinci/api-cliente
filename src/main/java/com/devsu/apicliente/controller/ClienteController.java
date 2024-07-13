package com.devsu.apicliente.controller;

import com.devsu.apicliente.dto.*;
import com.devsu.apicliente.repository.ClienteRepository;
import com.devsu.apicliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @PostMapping("/registrar")
    private ResponseEntity registrar(@RequestBody ClienteRegistroDTO request) {

    Optional<ClienteRegistroResponseDTO> response=clienteService.registrar(request);

    if (response.isPresent()){
        return ResponseEntity.ok(response.get());
    }
        return ResponseEntity.internalServerError().body("Error");

    }

    @PutMapping("/editar")
    private ResponseEntity editar(@RequestBody ActualizarEditarRequestDTO request) {

        Optional<ResultadoResponseDTO> response=clienteService.editar(request);

        if (response.isPresent()){
            return ResponseEntity.ok(response.get());
        }
        return ResponseEntity.internalServerError().body("Error");

    }
    @PatchMapping("/actualizar/{idCliente}")
    private ResponseEntity<ResultadoResponseDTO>actualizar(@RequestBody Map<String, String> request, @PathVariable("idCliente")  Long idCliente){

        Optional<ResultadoResponseDTO> resultado=clienteService.actualizar(request, idCliente);
        if(resultado.isPresent()){
            return ResponseEntity.ok(resultado.get());
        }
        return ResponseEntity.internalServerError().body(null);
    }

    @GetMapping("/getClientes")
    private ResponseEntity<ClientesResponseDTO> getClientes() {
        Optional<ClientesResponseDTO> resultado= clienteService.getClientes();
        if(resultado.isPresent()){
            return ResponseEntity.ok(resultado.get());
        }
        return ResponseEntity.internalServerError().body(null);
    }

    @DeleteMapping("/borrar/{clienteId}")
    private ResponseEntity<ResultadoResponseDTO> getClientes(@PathVariable("clienteId") Long clienteId){
        return ResponseEntity.ok(clienteService.borrar(clienteId).get());
    }

}
