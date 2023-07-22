package com.cancino.sistemaalmacenspring.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cancino.sistemaalmacenspring.entity.Articulo;
import com.cancino.sistemaalmacenspring.entity.Categoria;

@SuppressWarnings("unused")
@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {
	List<Articulo> findByNombreContaining(String texto);
	Articulo findByNombre(String texto);
	
}
