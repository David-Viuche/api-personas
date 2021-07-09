package com.david.personas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<List<Persona>> getProduct(){
		List<Persona> personas = personasDAO.findAll();
		return ResponseEntity.ok(personas);
	}
	
}
