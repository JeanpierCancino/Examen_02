package com.cancino.sistemaalmacenspring.service;
import java.util.List;

import com.cancino.sistemaalmacenspring.entity.Rol;


public interface RolService {
	public List<Rol> findAll();
	public Rol findById(int id);
	public Rol findByNombre(String nombre);
	public List<Rol> findByNombreContaining(String nombre);
	public Rol create(Rol obj);
	public Rol update(Rol obj);
	public int delete(int id);
}
