package com.joseleandro.atividade.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseleandro.atividade.entities.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {	
}

