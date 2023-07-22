package com.cancino.sistemaalmacenspring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cancino.sistemaalmacenspring.service.impl.RolServiceImpl;
import com.cancino.sistemaalmacenspring.entity.Rol;


@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/Roles")
public class RolController {
	@Autowired
	private RolServiceImpl service;
	
	//localhost:8091/api/Roles (GET)
	@GetMapping() 
	public ResponseEntity<List<Rol>> getAll(){
		List<Rol> roles= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(roles);
	}
	
	//localhost:8091/api/roles/1 (GET)
	@GetMapping(value="/{id}") 
	public ResponseEntity<Rol> getById(@PathVariable("id") int id) {
		Rol rol = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(rol);
	}
	
	//localhost:8091/api/Roles (POST)
	@PostMapping 
	public ResponseEntity<Rol> create(@RequestBody Rol rol) {
		Rol rolDb=service.create(rol);
		return ResponseEntity.status(HttpStatus.CREATED).body(rolDb);
	}
	
	//localhost:8091/api/categorias/1 (PUT)
	@PutMapping
	public ResponseEntity<Rol> update(@RequestBody Rol rol) {
		Rol rolDb=service.update(rol);
		return ResponseEntity.status(HttpStatus.OK).body(rolDb);
	}
	
	//localhost:8091/api/roles/1 (DELETE)
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
	}
}
