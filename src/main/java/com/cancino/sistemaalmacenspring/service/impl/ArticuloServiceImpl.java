package com.cancino.sistemaalmacenspring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.cancino.sistemaalmacenspring.entity.Categoria;
import com.cancino.sistemaalmacenspring.entity.Articulo;
import com.cancino.sistemaalmacenspring.repository.CategoriaRepository;
import com.cancino.sistemaalmacenspring.repository.ArticuloRepository;
import com.cancino.sistemaalmacenspring.service.ArticuloService;

@Service
public class ArticuloServiceImpl implements ArticuloService {
	@Autowired
	private ArticuloRepository repository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Articulo> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Articulo findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Articulo findByNombre(String nombre) {
		try {
			return repository.findByNombre(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Articulo> findByNombreContaining(String nombre) {
		try {
			return repository.findByNombreContaining(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Articulo create(Articulo obj) {
		try {
			obj.setActivo(true);
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println("Hola"+e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public Articulo update(Articulo obj) {
		try {
			Articulo articuloDb=repository.findById(obj.getId()).orElse(null);
			if(articuloDb==null) {
				return null;
			}
			articuloDb.setNombre(obj.getNombre());
			articuloDb.setPrecio(obj.getPrecio());
			articuloDb.setCategoria(obj.getCategoria());
			return repository.save(articuloDb);
		} catch (Exception e) {
		
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Articulo articuloDb=repository.findById(id).orElse(null);
			if(articuloDb==null) {
				return 0;
			}else {
				repository.delete(articuloDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
	}
	@Override
	@Transactional(readOnly = true)
	public List<Categoria> selectCategoria(){
		try {
			return categoriaRepository.findAll();
		} catch(Exception e) {
			return null;
		}
	}
	
}