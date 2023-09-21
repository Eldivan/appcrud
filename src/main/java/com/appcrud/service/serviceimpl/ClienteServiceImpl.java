package com.appcrud.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcrud.model.Cliente;
import com.appcrud.repository.ClienteRepository;
import com.appcrud.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente findById(long id) {
		return clienteRepository.findById(id).get();
	}

	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	
}
