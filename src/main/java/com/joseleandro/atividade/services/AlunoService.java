package com.joseleandro.atividade.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseleandro.atividade.entities.Aluno;
import com.joseleandro.atividade.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	public List<Aluno> findAll(){
		return repository.findAll(); 
	}
	
	public Aluno findById(Long id) {
		Optional <Aluno> obj = repository.findById(id);
		return obj.orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));
	}

	public Aluno create(Aluno aluno) {
		return repository.save(aluno);
	}	
	
	public Aluno update(Long id, Aluno aluno) {
		Aluno obj = findById(id);
		obj.setAluno(aluno.getAluno());
		obj.setIdade(aluno.getIdade());
		obj.setCurso(aluno.getCurso());
		obj.setMatriculado(aluno.getMatriculado());
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		Aluno obj = findById(id);
		repository.delete(obj);
	}
}
