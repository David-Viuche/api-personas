package com.david.personas.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	@PostMapping
	public ResponseEntity<Tarjeta> createTarjeta(@RequestBody Tarjeta tarjeta) {
		Optional<Persona> optionalPersona = personasDAO.findById(tarjeta.getPersona().getId_persona());

		if (optionalPersona.isPresent()) {
			tarjeta.setPersona(optionalPersona.get());
			Tarjeta newTarjeta = tarjetasDAO.save(tarjeta);
			return ResponseEntity.ok(newTarjeta);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping
	public ResponseEntity<Tarjeta> updateTarjeta(@RequestBody Tarjeta tarjeta) {
		Optional<Tarjeta> optionalTarjeta = tarjetasDAO.findById(tarjeta.getId_tarjeta());
		if (optionalTarjeta.isPresent()) {
			Tarjeta updateTarjeta = optionalTarjeta.get();

			if (tarjeta.getNumero() != null) {
				updateTarjeta.setNumero(tarjeta.getNumero());
			}

			if (tarjeta.getAnio_vencimiento() != 0) {
				updateTarjeta.setAnio_vencimiento(tarjeta.getAnio_vencimiento());
			}

			if (tarjeta.getMes_vencimiento() != 0) {
				updateTarjeta.setMes_vencimiento(tarjeta.getMes_vencimiento());
			}

			if (tarjeta.getCcv() != 0) {
				updateTarjeta.setCcv(tarjeta.getCcv());
			}

			Optional<Persona> optionalPersona = personasDAO.findById(tarjeta.getPersona().getId_persona());
	
			if (optionalPersona.isPresent()) {				
				updateTarjeta.setPersona(tarjeta.getPersona());
			}else {
				return ResponseEntity.notFound().build();
			}

			tarjetasDAO.save(updateTarjeta);

			return ResponseEntity.ok(updateTarjeta);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
