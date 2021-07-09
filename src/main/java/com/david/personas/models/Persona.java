package com.david.personas.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personas")

public class Persona {
	
	@Id   
	@Column(name = "id_persona")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_persona;
	
	@Column(name="nombre", nullable = false, length = 30)
	private String nombre;
	
	@Column(name="apellido", nullable = false, length = 30)
	private String apellido;
	
	@Column(name="direccion", nullable = false, length = 60)
	private String direccion;
	
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
	
	
}
