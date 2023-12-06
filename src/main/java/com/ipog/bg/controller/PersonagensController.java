package com.ipog.bg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipog.bg.exception.ResourceNotFoundException;
import com.ipog.bg.model.Personagens;
import com.ipog.bg.repository.PersonagensRepository;



@RestController
@RequestMapping("/cpersonagens/")
public class PersonagensController {

	@Autowired
	private PersonagensRepository mrep;
	
	// listar
	@GetMapping("/Personagens")
	public List<Personagens> listar() {
		return this.mrep.findAll();
	}
	
	// consultar
	@GetMapping("/Personagens/{id}")
	public ResponseEntity<Personagens> consultar(@PathVariable Long id) {
		
		Personagens personagens = this.mrep.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("Pesonagem não encontrado. ID: " + id));
			
			return ResponseEntity.ok(personagens);
		
	}
	
	// inserir
	@PostMapping("/Personagens")
	public Personagens inserir(@RequestBody Personagens personagem) {
		
		return this.mrep.save(personagem);
		
	}
	
	//alterar
	@PutMapping("/Personagens/{id}")
	public ResponseEntity<Personagens> alterar(@PathVariable Long id, @RequestBody Personagens personagem) {
		
		Personagens personagemLocalizado = this.mrep.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Pesonagem não encontrado. ID: " + id));
		
		personagemLocalizado.setID(personagem.getID());
		personagemLocalizado.setNome(personagem.getNome());
		
		Personagens personagemAlterado = this.mrep.save(personagemLocalizado);
		return ResponseEntity.ok(personagemAlterado);
	
	}
	
	// excluir
	@DeleteMapping("/Personagens/{id}")
	public ResponseEntity<Map<String, Boolean>> excluir(@PathVariable Long id) {
		Personagens personagemLocalizado = this.mrep.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Pesonagem não encontrado. ID: " + id));
		
		this.mrep.delete(personagemLocalizado);
		
		Map<String, Boolean> resposta = new HashMap<>();
		resposta.put("Marca excluida com sucesso", true);
		
		return ResponseEntity.ok(resposta);
		
	}

}
