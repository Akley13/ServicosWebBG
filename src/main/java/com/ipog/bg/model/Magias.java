package com.ipog.bg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Date;

import jakarta.persistence.Column;

@Entity
@Table(name="Magias")
public class Magias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="dano")
	private Double dano;
	
	@Column(name="custoDeMana")
	private int custoDeMana;
	
	@Column(name="DataDeFabricacao")
	private Date dataDeCriacao;
	
	@Column(name="magiaAtiva")
	private Boolean magiaAtiva;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Personagens personagem;
	
	
	// Construtor sem atributos para a superclasse
	public Magias() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//Construtor com atributos para superclasse
	public Magias(Long id, String nome, Double dano, int custoDeMana, Date dataDeCriacao, Boolean magiaAtiva,
			Personagens personagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.dano = dano;
		this.custoDeMana = custoDeMana;
		this.dataDeCriacao = dataDeCriacao;
		this.magiaAtiva = magiaAtiva;
		this.personagem = personagem;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getDano() {
		return dano;
	}


	public void setDano(Double dano) {
		this.dano = dano;
	}


	public int getCustoDeMana() {
		return custoDeMana;
	}


	public void setCustoDeMana(int custoDeMana) {
		this.custoDeMana = custoDeMana;
	}


	public Date getDataDeCriacao() {
		return dataDeCriacao;
	}


	public void setDataDeCriacao(Date dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}


	public Boolean getMagiaAtiva() {
		return magiaAtiva;
	}


	public void setMagiaAtiva(Boolean magiaAtiva) {
		this.magiaAtiva = magiaAtiva;
	}


	public Personagens getPersonagem() {
		return personagem;
	}


	public void setPersonagem(Personagens personagem) {
		this.personagem = personagem;
	}
	
	
	
	
	
}
