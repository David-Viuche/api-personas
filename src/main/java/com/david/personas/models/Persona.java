package com.david.personas.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "personas")

public class Persona {

	@Id
	@Column(name = "id_persona")
	@GeneratedValue(generator = "seq_id_persona")
	@SequenceGenerator(name = "seq_id_persona", sequenceName = "SEQ_ID_PERSONA", allocationSize = 1)
	private long id_persona;

	@Column(name = "nombre", nullable = false, length = 30)
	private String nombre;

	@Column(name = "apellido", nullable = false, length = 30)
	private String apellido;

	@Column(name = "direccion", nullable = false, length = 60)
	private String direccion;

	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Tarjeta> tarjetas = new ArrayList<>();

	public long getId_persona() {
		return id_persona;
	}

	public void setId_persona(long id_persona) {
		this.id_persona = id_persona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

}
