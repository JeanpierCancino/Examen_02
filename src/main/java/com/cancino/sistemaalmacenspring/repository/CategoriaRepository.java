package com.cancino.sistemaalmacenspring.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cancino.sistemaalmacenspring.entity.Categoria;


@SuppressWarnings("unused")
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	List<Categoria> findByNombreContaining(String texto);
	Categoria findByNombre(String texto);
	
	

}
