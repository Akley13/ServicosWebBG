package com.ipog.bg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return this.magrep.findAll();
	}

}
