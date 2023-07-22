package com.cancino.sistemaalmacenspring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cancino.sistemaalmacenspring.entity.Categoria;
import com.cancino.sistemaalmacenspring.repository.CategoriaRepository;
import com.cancino.sistemaalmacenspring.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	@Autowired
	private CategoriaRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Categoria findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Categoria findByNombre(String nombre) {
		try {
			return repository.findByNombre(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findByNombreContaining(String nombre) {
		try {
			return repository.findByNombreContaining(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public Categoria create(Categoria obj) {
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
	public Categoria update(Categoria obj) {
		try {
			Categoria categoriaDb=repository.findById(obj.getId()).orElse(null);
			if(categoriaDb==null) {
				return null;
			}
			categoriaDb.setNombre(obj.getNombre());
			return repository.save(categoriaDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Categoria categoriaDb=repository.findById(id).orElse(null);
			if(categoriaDb==null) {
				return 0;
			}else {
				repository.delete(categoriaDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
	}
	
}