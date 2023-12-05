package com.ipog.bg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ipog.bg.model.Personagens;

@Repository
public interface PersonagensRepository extends JpaRepository<Personagens, Long> {

}
