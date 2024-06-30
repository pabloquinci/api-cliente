package com.devsu.apicliente.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERSONA")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    @Column
    private String nombre;
    @Column
    private Long dni;
    @Column
    private String direccion;
    @Column
    private Long telefono;
    @Column
    private Integer edad;
    @Column
    private String genero;

    public Persona(String nombre, Long dni, String direccion, Long telefono, Integer edad, String genero){
        this.nombre=nombre;
        this.dni=dni;
        this.direccion=direccion;
        this.telefono=telefono;
        this.edad=edad;
        this.genero=genero;


    }

}
