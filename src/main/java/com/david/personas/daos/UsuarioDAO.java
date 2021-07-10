package com.david.personas.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.personas.models.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long>{

	public abstract Usuario findByUsuario(String usuario);
	
}
