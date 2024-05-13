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

import com.joseleandro.atividade.entities.Nota;
import com.joseleandro.atividade.services.NotaService;

@RestController
@RequestMapping(value = "/notas")
public class NotaController {

	@Autowired
	private NotaService service;

	@GetMapping
	public ResponseEntity<List<Nota>> findAll() {
		List<Nota> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Nota> findById(@PathVariable Long id) {
		Nota obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping(value = "/cadastrar")
    public ResponseEntity<Nota> create(@RequestBody Nota nota) throws URISyntaxException{
        Nota createdNota = service.create(nota);
        return ResponseEntity.created(new URI("/notas/" + createdNota.getId())).body(createdNota);
    }

	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<Nota> update(@PathVariable Long id, @RequestBody Nota nota) {
		Nota updatedNota = service.update(id, nota);
		return ResponseEntity.ok().body(updatedNota);
	}

	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
