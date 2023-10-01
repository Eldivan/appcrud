package com.appcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.appcrud.service.ClienteService;

@Controller
public class ClienteControler {
	
	@Autowired
	ClienteService clienteService;
	
}
