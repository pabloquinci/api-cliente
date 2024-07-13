package com.devsu.apicliente.repository;

import com.devsu.apicliente.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findAll();

    Optional<Cliente> findByDni (Integer dni);
}
