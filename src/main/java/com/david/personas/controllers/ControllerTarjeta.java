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
import com.david.personas.daos.TarjetasDAO;
import com.david.personas.models.Persona;
import com.david.personas.models.Tarjeta;

@RestController
@RequestMapping("tarjetas")

public class ControllerTarjeta {
	@Autowired
	private TarjetasDAO tarjetasDAO;
	
	@Autowired
	private PersonasDAO personasDAO;

	@GetMapping
	public ResponseEntity<List<Tarjeta>> getTarjetasByPersonaId() {
		List<Tarjeta> personas = tarjetasDAO.findAll();
		return ResponseEntity.ok(personas);
	}

	@PostMapping
	public ResponseEntity<Tarjeta> createTarjeta(@RequestBody Tarjeta tarjeta) {
		Optional<Persona> optionalPersona = personasDAO.findById(tarjeta.getPersona().getId_persona());
		
		if (optionalPersona.isPresent()) {
			tarjeta.setPersona(optionalPersona.get());
			Tarjeta newTarjeta = tarjetasDAO.save(tarjeta);
			return ResponseEntity.ok(newTarjeta);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
