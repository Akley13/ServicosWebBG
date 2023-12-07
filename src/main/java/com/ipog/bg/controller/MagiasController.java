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
import com.ipog.bg.model.Magias;
import com.ipog.bg.repository.MagiasRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cMagias/")
@RestController
public class MagiasController {
	
	@Autowired
	private MagiasRepository magrep;
	
	// listar
	@GetMapping("/Magias")
	public List<Magias> listar() {
		
		Sort sortby = Sort.by(Sort.Direction.DESC,"id");
		
		return this.magrep.findAll(sortby);
	}
	
	// consultar
	@GetMapping("/Magias/{id}")
	public ResponseEntity<Magias> consultar(@PathVariable Long id) {
		
		Magias magia = this.magrep.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("Magia não encontrado. ID: " + id));
			
			return ResponseEntity.ok(magia);
	}
	
	// inserir
	@PostMapping("/Magias")
	public Magias inserir(@RequestBody Magias magia) {
		
		return this.magrep.save(magia);
		
	}
	
	// excluir
	@DeleteMapping("/Magias/{id}")
	public ResponseEntity<Map<String, Boolean>> excluir(@PathVariable Long id) {
		Magias magiaLocalizada = this.magrep.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Magia não encontrada. ID: " + id));
		
		this.magrep.delete(magiaLocalizada);
		
		Map<String, Boolean> resposta = new HashMap<>();
		resposta.put("Magia excluida com sucesso", true);
		
		return ResponseEntity.ok(resposta);
		
	}
	
	//alterar
		@PutMapping("/Magias/{id}")
		public ResponseEntity<Magias> alterar(@PathVariable Long id, @RequestBody Magias magia) {
			
			Magias magiaLocalizada = this.magrep.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("Magia não encontrada. ID: " + id));
			
			magiaLocalizada.setId(magia.getId());
			magiaLocalizada.setNome(magia.getNome());
			
			Magias magiaAlterada = this.magrep.save(magiaLocalizada);
			return ResponseEntity.ok(magiaAlterada);
			
		}


}
