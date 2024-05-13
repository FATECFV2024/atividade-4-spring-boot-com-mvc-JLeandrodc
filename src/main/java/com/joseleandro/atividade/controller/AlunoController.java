package com.joseleandro.atividade.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseleandro.atividade.entities.Aluno;
import com.joseleandro.atividade.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

	@Autowired
	private AlunoService service;

	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		List<Aluno> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Long id) {
		Aluno obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping(value = "/cadastrar")
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno) throws URISyntaxException{
        Aluno createdAluno = service.create(aluno);
        return ResponseEntity.created(new URI("/alunos/" + createdAluno.getId())).body(createdAluno);
    }

	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno aluno) {
		Aluno updatedAluno = service.update(id, aluno);
		return ResponseEntity.ok().body(updatedAluno);
	}

	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
