package com.appcrud.model;

import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")	
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	
	private String nome; 
	
	@NotBlank
	private String cpf; 
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy")
	private LocalDate dataNascimento;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String telefone;
	
	
}
