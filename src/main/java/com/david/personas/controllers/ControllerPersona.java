package com.david.personas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.personas.daos.PersonasDAO;
import com.david.personas.models.Persona;

@RestController
@RequestMapping("personas")

public class ControllerPersona {
	
	@Autowired
	private PersonasDAO personasDAO;
	@GetMapping
	public ResponseEntity<List<Persona>> getPersonas() {
		List<Persona> personas = personasDAO.findAll();
		return ResponseEntity.ok(personas);
	}

	@RequestMapping(value = "{id_persona}")
	public ResponseEntity<Persona> getPersonaById(@PathVariable Long id_persona) {
		Optional<Persona> optionalPersona = personasDAO.findById(id_persona);
		
		if (optionalPersona.isPresent()) {
			return ResponseEntity.ok(optionalPersona.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
		Persona newPersona = personasDAO.save(persona);
		return ResponseEntity.ok(newPersona);
	}

	@PutMapping
	public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona) {
		Optional<Persona> optionalPersona = personasDAO.findById(persona.getId_persona());
		if (optionalPersona.isPresent()) {
			Persona updatePersona = optionalPersona.get();

			if (persona.getNombre() != null) {
				updatePersona.setNombre(persona.getNombre());
			}

			if (persona.getApellido() != null) {
				updatePersona.setApellido(persona.getApellido());
			}
			
			if (persona.getDireccion() != null) {
				updatePersona.setDireccion(persona.getDireccion());
			}
			
			personasDAO.save(updatePersona);

			return ResponseEntity.ok(updatePersona);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
