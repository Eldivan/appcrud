package com.appcrud.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.message.StructuredDataMessage.Format;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appcrud.model.Cliente;
import com.appcrud.repository.ClienteRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DummyData {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	//@PostConstruct
	public void saveCliente() {
		List<Cliente> listaCliente = new ArrayList<>(); 
		Cliente cliente1 = new Cliente();
		
		cliente1.setCpf("123");
		cliente1.setNome("Jao");
		cliente1.setEmail("email@email");
		cliente1.setTelefone("3389");
		cliente1.setDataNascimento(Date.valueOf("2000-01-01"));
		
		
		listaCliente.add(cliente1);
		
		for(Cliente cliente :listaCliente ) {
			Cliente savedCliente = clienteRepository.save(cliente);
			System.out.println(savedCliente.getId());
		}
	}
}
