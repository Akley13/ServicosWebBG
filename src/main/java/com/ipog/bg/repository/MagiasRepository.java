package com.ipog.bg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipog.bg.model.Magias;

@Repository
public interface MagiasRepository extends JpaRepository<Magias, Long>{

	List<Magias> findAll();

}
