package com.appcrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appcrud.model.Cliente;

@Service
public interface ClienteService {

	List<Cliente> findAll();
	Cliente findById(long id);
	Cliente save(Cliente cliente);
	
}
