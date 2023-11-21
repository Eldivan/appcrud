package com.appcrud.controller;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String salvarCliente(@Validated Cliente cliente, BindingResult result, RedirectAttributes attributes ) {
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
	
	@GetMapping("/{id}")
	public String alterarCliente(@PathVariable("id") long id, Model model) {
		Optional<Cliente> clienteOpt = clienteRepository.findById(id);
		if(clienteOpt.isEmpty()) {
			throw new IllegalArgumentException("Cliente invalido");
		}
		model.addAttribute("cliente", clienteOpt.get());
		return "/formcadastrocliente";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluirCliente(@PathVariable("id") long id, Model model) {
		Optional<Cliente> clienteOpt = clienteRepository.findById(id);
		if(clienteOpt.isEmpty()) {
			throw new IllegalArgumentException("Cliente inexistente :(");
		}
		clienteRepository.delete(clienteOpt.get());
		model.addAttribute("listaClientes", clienteRepository.findAll());
		return "/listacliente";
	}
	
	
	
}
