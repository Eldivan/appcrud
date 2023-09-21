package com.appcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appcrud.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
