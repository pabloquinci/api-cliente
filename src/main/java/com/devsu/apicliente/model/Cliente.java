package com.devsu.apicliente.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
//@Table(name = "CLIENTE")
public class Cliente extends Persona implements Serializable {

    //@Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Cliente(){
    }
    public Cliente(String nombre, Long dni, String direccion, Long telefono, Integer edad, String genero){
        super(nombre, dni, direccion, telefono, edad, genero);

    }
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long idCliente;

    @Column
    private String contrasenia;
    @Column
    private String estado;

}
