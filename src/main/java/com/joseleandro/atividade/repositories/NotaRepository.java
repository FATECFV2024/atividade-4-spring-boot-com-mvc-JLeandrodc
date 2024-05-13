package com.joseleandro.atividade.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 import com.joseleandro.atividade.entities.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {	
}

