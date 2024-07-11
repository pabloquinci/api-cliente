package com.devsu.apicliente.controller;

import com.devsu.apicliente.exception.UserAlreadyExistsException;
import com.devsu.apicliente.exception.UserNotFoundExcdeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(UserNotFoundExcdeption.class)
    protected ResponseEntity<String> userException(UserNotFoundExcdeption ex){
        return new ResponseEntity<String>("Error: El usuario que quiere editar o actualizar no existe", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    protected ResponseEntity<String> userAlreadyException(UserAlreadyExistsException ex){
        return new ResponseEntity<String>("Error: Ya existe el usuario con ese DNI", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<String> userAlreadyException(Exception ex){
        return new ResponseEntity<String>("Error: Respuesta solicitud usuario", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
