package com.devsu.apicliente.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
public class Cliente extends Persona implements Serializable {

    public Cliente(){
    }
    public Cliente(String nombre, Long dni, String direccion, Long telefono, Integer edad, String genero){
        super(nombre, dni, direccion, telefono, edad, genero);

    }

    @Column
    private String contrasenia;
    @Column
    private String estado;

}
