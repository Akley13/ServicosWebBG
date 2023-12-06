package com.ipog.bg.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="personagens")

public class Personagens {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="ativo")
	private Boolean ativo;
	
	// Construtor padrão, sem atributos
	public Personagens() {
		super();
		// TODO Auto-generated constructor stub
	}


	// Construtor com todos os campos
	public Personagens(Long iD, String nome) {
		super();
		ID = iD;
		this.nome = nome;
	}
	
	
	// Todos os getters e setters
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Boolean getAtivo() {
		return ativo;
	}


	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
