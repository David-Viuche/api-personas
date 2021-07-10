package com.david.personas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.david.personas.daos.UsuarioDAO;
import com.david.personas.models.Usuario;

@Service("usuarioService")
public class UsuarioService implements UserDetailsService{

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioDAO.findByUsuario(username);
		System.out.println("user "+user);
		System.out.println("username "+username);
		return new User(user.getUsuario(), user.getContrasena(), buildgrant());
	}
	
	public List<GrantedAuthority> buildgrant(){
		
		List<GrantedAuthority> auths = new ArrayList<>();
		
		auths.add(new SimpleGrantedAuthority("USER"));
		
		return auths;
	}
}
