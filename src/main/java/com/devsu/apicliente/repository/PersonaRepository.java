package com.devsu.apicliente.repository;

import com.devsu.apicliente.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
