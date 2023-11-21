package com.appcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcrud.model.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
