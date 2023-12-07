package com.ipog.bg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipog.bg.exception.ResourceNotFoundException;
import com.ipog.bg.model.Jogador;
import com.ipog.bg.repository.JogadorRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cJogador/")
@RestController
public class JogadorController {
	
	@Autowired
	private JogadorRepository jrep;
	
	// listar
	@GetMapping("/Jogador")
	public List<Jogador> listar() {
		
		Sort sortby = Sort.by(Sort.Direction.ASC,"id");
		
		return this.jrep.findAll(sortby);
	}
	
	// consultar
	@GetMapping("/Jogador/{id}")
	public ResponseEntity<Jogador> consultar(@PathVariable Long id) {
		
		Jogador jogador = this.jrep.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("Jogador não encontrado. ID: " + id));
			
			return ResponseEntity.ok(jogador);
	}
	
	// inserir
	@PostMapping("/Jogador")
	public Jogador inserir(@RequestBody Jogador jogador) {
		
		return this.jrep.save(jogador);
		
	}
	
	// excluir
	@DeleteMapping("/Jogador/{id}")
	public ResponseEntity<Map<String, Boolean>> excluir(@PathVariable Long id) {
		Jogador jogadorLocalizado = this.jrep.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Jogador não encontrada. ID: " + id));
		
		this.jrep.delete(jogadorLocalizado);
		
		Map<String, Boolean> resposta = new HashMap<>();
		resposta.put("Jogador excluida com sucesso!", true);
		
		return ResponseEntity.ok(resposta);
		
	}
	
	//alterar
		@PutMapping("/Jogador/{id}")
		public ResponseEntity<Jogador> alterar(@PathVariable Long id, @RequestBody Jogador jogador) {
			
			Jogador jogadorLocalizado = this.jrep.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("Jogador não encontrada. ID: " + id));
			
			jogadorLocalizado.setId(jogador.getId());
			jogadorLocalizado.setNome(jogador.getNome());
			
			Jogador jogadorAlterado = this.jrep.save(jogadorLocalizado);
			return ResponseEntity.ok(jogadorAlterado);
			
		}

}
