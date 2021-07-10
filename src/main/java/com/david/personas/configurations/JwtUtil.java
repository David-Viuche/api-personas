package com.david.personas.configurations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Collections;

public class JwtUtil {

	static void addAuthentication(HttpServletResponse response, String username) {

		String token = Jwts.builder().setSubject(username).signWith(SignatureAlgorithm.HS512, "secret10").compact();

		response.addHeader("Authorization", "Bearer " + token);
	}

	static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		
		if(token != null) {
			String user = Jwts.parser()
					.setSigningKey("secret10")
					.parseClaimsJws(token.replace("Bearer", ""))
					.getBody()
					.getSubject();
			
			return user != null ? new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()): null;
		}
		
		return null;
	}

}
