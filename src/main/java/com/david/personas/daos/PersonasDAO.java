package com.david.personas.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.personas.models.Persona;

public interface PersonasDAO extends JpaRepository<Persona, Long>{
	
}
