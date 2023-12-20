package com.neyra.denunciaapi.controller;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.neyra.denunciaapi.entity.Denuncia;
import com.neyra.denunciaapi.service.impl.DenunciaServiceImpl;

public class DenunciaController {
	@Autowired
	private DenunciaServiceImpl service;
	
	@GetMapping() 
	public ResponseEntity<List<Denuncia>> getAll(Pageable page){
		List<Denuncia> denuncia= service.findAll(page);
		return ResponseEntity.status(HttpStatus.OK).body(denuncia);
	}
	
	@GetMapping(value="/{id}") 
	public ResponseEntity<Denuncia> getById(@PathVariable("id") int id) {
		Denuncia denuncia = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(denuncia);
	}
	
	
	@PostMapping 
	public ResponseEntity<Denuncia> create(@RequestBody Denuncia denuncia) {
		Denuncia docenteDb=service.create(denuncia);
		return ResponseEntity.status(HttpStatus.CREATED).body(docenteDb);
	}
	
	
	@PutMapping
	public ResponseEntity<Denuncia> update(@RequestBody Denuncia denuncia) {
		Denuncia denunciaDb=service.update(denuncia);
		return ResponseEntity.status(HttpStatus.OK).body(denunciaDb);
	}
	
	
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
	}
}
