package com.cancino.sistemaalmacenspring.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cancino.sistemaalmacenspring.entity.Rol;

@SuppressWarnings("unused")
@Repository
public interface RolRepository  extends JpaRepository<Rol, Integer>{
	List<Rol> findByNombreContaining(String texto);
	Rol findByNombre(String texto);
	
}
