package com.david.personas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.personas.models.Tarjeta;

public interface TarjetasDAO extends JpaRepository<Tarjeta, Long> {

}
