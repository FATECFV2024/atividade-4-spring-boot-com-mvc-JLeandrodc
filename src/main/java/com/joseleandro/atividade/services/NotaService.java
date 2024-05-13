package com.joseleandro.atividade.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseleandro.atividade.entities.Nota;
import com.joseleandro.atividade.repositories.NotaRepository;

@Service
public class NotaService {
	
	@Autowired
	private NotaRepository repository;
	
	public List<Nota> findAll(){
		return repository.findAll(); 
	}
	
	public Nota findById(Long id) {
		Optional <Nota> obj = repository.findById(id);
		return obj.orElseThrow(() -> new IllegalArgumentException("Nota não encontrado"));
	}

	public Nota create(Nota nota) {
		return repository.save(nota);
	}	
	
	public Nota update(Long id, Nota nota) {
		Nota obj = findById(id);
		obj.setNota(nota.getNota());
		obj.setMateria(nota.getMateria());
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		Nota obj = findById(id);
		repository.delete(obj);
	}
}
