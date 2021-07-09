package com.david.personas.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.personas.daos.PersonasDAO;
import com.david.personas.models.Persona;

@RestController
@RequestMapping("personas")

public class Controllers {
	
	@Autowired
	private PersonasDAO personasDAO;
	
	@GetMapping
	public ResponseEntity<List<Persona>> getPersonas(){
		List<Persona> personas = personasDAO.findAll();
		return ResponseEntity.ok(personas);
	}
	
	@RequestMapping(value= "{id_persona}")
	public ResponseEntity<Persona> getPersonaById(@PathVariable Long id_persona){
		Optional<Persona> optionalPersona = personasDAO.findById(id_persona);
		if(optionalPersona.isPresent()) {
			return ResponseEntity.ok(optionalPersona.get());
		}else {			
			return ResponseEntity.notFound().build();
		}
	}
}
