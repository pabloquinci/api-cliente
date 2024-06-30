package com.devsu.apicliente.controller;

import com.devsu.apicliente.exception.UserAlreadyFollowedException;
import com.devsu.apicliente.exception.UserNotFoundExcdeption;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
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

    @ExceptionHandler(UserAlreadyFollowedException.class)
    protected ResponseEntity<String> userAlreadyException(UserAlreadyFollowedException ex){
        return new ResponseEntity<String>("Error: Ud ya sigue al usuario solicitado", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
