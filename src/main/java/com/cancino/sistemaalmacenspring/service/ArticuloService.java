package com.cancino.sistemaalmacenspring.service;

import java.util.List;

import com.cancino.sistemaalmacenspring.entity.Articulo;
import com.cancino.sistemaalmacenspring.entity.Categoria;

public interface ArticuloService {
	public List<Articulo> findAll();
	public Articulo findById(int id);
	public Articulo findByNombre(String nombre);
	public List<Articulo> findByNombreContaining(String nombre);
	public Articulo create(Articulo obj);
	public Articulo update(Articulo obj);
	public int delete(int id);
	public List<Categoria> selectCategoria();
	
}
