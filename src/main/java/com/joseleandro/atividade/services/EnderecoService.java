package com.joseleandro.atividade.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseleandro.atividade.entities.Endereco;
import com.joseleandro.atividade.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> findAll(){
		return repository.findAll(); 
	}
	
	public Endereco findById(Long id) {
		Optional <Endereco> obj = repository.findById(id);
		return obj.orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado"));
	}

	public Endereco create(Endereco endereco) {
		return repository.save(endereco);
	}	
	
	public Endereco update(Long id, Endereco endereco) {
		Endereco obj = findById(id);
		obj.setRua(endereco.getRua());
		obj.setNumero(endereco.getNumero());
		obj.setCidade(endereco.getCidade());
		obj.setEstado(endereco.getEstado());
		obj.setCep(endereco.getCep());
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		Endereco obj = findById(id);
		repository.delete(obj);
	}
}
