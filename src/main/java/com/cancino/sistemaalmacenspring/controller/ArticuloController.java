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

import com.cancino.sistemaalmacenspring.service.impl.ArticuloServiceImpl;
import com.cancino.sistemaalmacenspring.service.impl.CategoriaServiceImpl;
import com.cancino.sistemaalmacenspring.entity.Articulo;
import com.cancino.sistemaalmacenspring.entity.Categoria;


@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {
	@Autowired
	private ArticuloServiceImpl service;
	
	@Autowired
	private CategoriaServiceImpl serviceCategoria;
	
	//localhost:8091/api/articulos (GET)
	@GetMapping() 
	public ResponseEntity<List<Articulo>> getAll(){
		List<Articulo> articulos= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(articulos);
	}
	
	//localhost:8091/api/articulos/1 (GET)
	@GetMapping(value="/{id}") 
	public ResponseEntity<Articulo> getById(@PathVariable("id") int id) {
		Articulo articulo = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(articulo);
	}
	
	//localhost:8091/api/articulos (POST)
	@PostMapping 
	public ResponseEntity<Articulo> create(@RequestBody Articulo articulo) {
		Articulo articuloDb=service.create(articulo);
		return ResponseEntity.status(HttpStatus.CREATED).body(articuloDb);
	}
	
	//localhost:8091/api/articulos/1 (PUT)
	@PutMapping
	public ResponseEntity<Articulo> update(@RequestBody Articulo articulo) {
		Articulo articuloDb=service.update(articulo);
		return ResponseEntity.status(HttpStatus.OK).body(articuloDb);
	}
	
	//localhost:8091/api/articulos/1 (DELETE)
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
	}
	
	//localhost:8091/api/articulos/selectCategorias (GET)
	@GetMapping(value="/selectCategorias")
	public ResponseEntity<List<Categoria>> selectCategorias(){
			List<Categoria> categorias= serviceCategoria.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(categorias);
	}
}
