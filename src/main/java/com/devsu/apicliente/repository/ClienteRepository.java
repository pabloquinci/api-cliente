package com.devsu.apicliente.repository;

import com.devsu.apicliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findAll();
}
