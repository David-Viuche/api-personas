package com.david.personas.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(generator = "seq_id_usuario")
	@SequenceGenerator(name = "seq_id_usuario", sequenceName = "SEQ_ID_USUARIO", allocationSize = 1)
	private long id_usuario;
	
	@Column(name = "usuario", nullable = false, length = 30, unique=true)
	private String usuario;
	
	@Column(name = "contrasena")
	private String contrasena;

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
