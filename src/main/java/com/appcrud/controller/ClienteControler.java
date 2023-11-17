package com.appcrud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.appcrud.model.Cliente;
import com.appcrud.repository.ClienteRepository;


@Controller
@RequestMapping("/cliente")
public class ClienteControler {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/inicio")
	public String inicio() {
		return "index";
	}
	
	@GetMapping("/novo")
	public String adicionarCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "/formcadastrocliente";
	}
	
	@PostMapping("/salvar")
	public String salvarCliente(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes ) {
		if( result.hasErrors()) {
			return "/formcadastrocliente";
		}
		clienteRepository.save(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!");
		return "redirect:/cliente/novo";
	}
	
	@GetMapping("/listar")
	public String listarClientes(Model model) {
		model.addAttribute("listaClientes", clienteRepository.findAll());
		return "/listacliente";
	}
	
	
}
