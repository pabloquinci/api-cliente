package com.devsu.apicliente.service;

import com.devsu.apicliente.configuration.CacheConfig;
import com.devsu.apicliente.dto.*;
import com.devsu.apicliente.exception.UserAlreadyExistsException;
import com.devsu.apicliente.exception.UserNotFoundExcdeption;
import com.devsu.apicliente.model.Cliente;
import com.devsu.apicliente.repository.ClienteRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Optional<ClienteRegistroResponseDTO> registrar(ClienteRegistroDTO clienteRegistroDTO){

        Optional<Cliente> clienteUpdate=this.clienteRepository.findByDni(clienteRegistroDTO.getDni().intValue());

        if(clienteUpdate.isPresent()){
            throw new UserAlreadyExistsException();
        }

        Cliente clienteDAO= Cliente.builder()
                .contrasenia(clienteRegistroDTO.getContrasenia())
                .estado("OK")
                .build();

        clienteDAO.setContrasenia(!Strings.isEmpty(clienteRegistroDTO.getContrasenia()) ? clienteRegistroDTO.getContrasenia() :null);
        clienteDAO.setDni(!Objects.isNull(clienteRegistroDTO.getDni()) ?clienteRegistroDTO.getDni() :null);
        clienteDAO.setNombre(!Strings.isEmpty(clienteRegistroDTO.getNombre()) ?clienteRegistroDTO.getNombre() :null);
        clienteDAO.setDireccion(!Strings.isEmpty(clienteRegistroDTO.getDireccion()) ?clienteRegistroDTO.getDireccion() :null);
        clienteDAO.setTelefono(!Objects.isNull(clienteRegistroDTO.getTelefono()) ?clienteRegistroDTO.getTelefono() :null);
        clienteDAO.setGenero(!Strings.isEmpty(clienteRegistroDTO.getGenero()) ?clienteRegistroDTO.getGenero() :null);
        clienteDAO.setEdad(!Objects.isNull(clienteRegistroDTO.getEdad()) ?clienteRegistroDTO.getEdad() :null);
        this.clienteRepository.save(clienteDAO);

        return Optional.of(ClienteRegistroResponseDTO.builder().status("OK").build());
    }

    public Optional<ResultadoResponseDTO> editar(ActualizarEditarRequestDTO clienteEdicionDTO){

        Cliente clienteUpdate=this.clienteRepository.findById(clienteEdicionDTO.getIdPersona())
                .orElseThrow(()-> new UserNotFoundExcdeption());

        clienteUpdate.setContrasenia(!Strings.isEmpty(clienteEdicionDTO.getContrasenia()) ? clienteEdicionDTO.getContrasenia() :null);
        clienteUpdate.setDni(!Objects.isNull(clienteEdicionDTO.getDni()) ?clienteEdicionDTO.getDni() :null);
        clienteUpdate.setNombre(!Strings.isEmpty(clienteEdicionDTO.getNombre()) ?clienteEdicionDTO.getNombre() :null );
        clienteUpdate.setDireccion(!Strings.isEmpty(clienteEdicionDTO.getDireccion()) ?clienteEdicionDTO.getDireccion() :null );
        clienteUpdate.setTelefono(!Objects.isNull(clienteEdicionDTO.getTelefono()) ?clienteEdicionDTO.getTelefono() :null);
        clienteUpdate.setGenero(!Strings.isEmpty(clienteEdicionDTO.getGenero()) ?clienteEdicionDTO.getGenero() :null);
        clienteUpdate.setEdad(!Objects.isNull(clienteEdicionDTO.getEdad()) ?clienteEdicionDTO.getEdad() :null);
        this.clienteRepository.save(clienteUpdate);

        return Optional.of(ResultadoResponseDTO.builder().resultado("Edicion OK").build());
    }

    public Optional<ResultadoResponseDTO> actualizar(Map<String, String> clienteUpdateDTO, Long id){
        Cliente clienteUpdate=this.clienteRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundExcdeption());

        clienteUpdateDTO.forEach((clave, valor)->{

            switch(clave){
                case "nombre" -> clienteUpdate.setNombre((String) valor);
                case "telefono" -> clienteUpdate.setTelefono(Long.parseLong((String)valor));
                case "genero" -> clienteUpdate.setGenero((String) valor);
                case "dni" -> clienteUpdate.setDni(Long.parseLong((String)valor));
                case "direccion" -> clienteUpdate.setDireccion((String) valor);
                case "contrasenia" -> clienteUpdate.setContrasenia((String) valor);
            }

        });

        this.clienteRepository.save(clienteUpdate);

        return Optional.of(ResultadoResponseDTO.builder().resultado("Edicion OK").build());

    }

//    @Cacheable(cacheNames = CacheConfig.USER_CACHE, unless = "#result == null")
@Cacheable(cacheNames = CacheConfig.CLIENTE_CACHE, unless = "#result == null")
    public Optional<ClientesResponseDTO> getClientes(){
        List<Cliente> clientes=this.clienteRepository.findAll();
        ClientesResponseDTO clientesDTO=ClientesResponseDTO.builder().clientes(new ArrayList<>()).build();
        if(clientes.size()!=0){
            clientes
                .stream()
                       .forEach(cliente->{
                       clientesDTO.getClientes().add(ClienteResponseDTO.builder()
                           .dni(cliente.getDni())
                           .direccion(cliente.getDireccion())
                           .edad(cliente.getEdad())
                           .genero(cliente.getGenero())
                           .idPersona(cliente.getIdPersona())
                           .nombre(cliente.getNombre())
                           .telefono(cliente.getTelefono())
                           .build());
                            });
        }

        return Optional.of(clientesDTO);
    }

    public Optional<ResultadoResponseDTO> borrar(Long id){
        Cliente clienteUpdate=this.clienteRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundExcdeption());
        this.clienteRepository.delete(clienteUpdate);

        return Optional.of(ResultadoResponseDTO.builder().resultado("Edicion OK").build());
    }




    }
