package com.ipog.bg.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ipog.bg.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

	List<Jogador> findAll(Sort sortby);

}
