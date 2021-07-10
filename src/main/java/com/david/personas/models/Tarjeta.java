package com.david.personas.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tarjetas")

public class Tarjeta {
	@Id
	@Column(name = "id_tarjeta")
	@GeneratedValue(generator = "seq_id_tarjeta")
	@SequenceGenerator(name = "seq_id_tarjeta", sequenceName = "SEQ_ID_TARJETA", allocationSize = 1)
	private long id_tarjeta;

	@Column(name = "numero", nullable = false, length = 20)
	private String numero;

	@Column(name = "anio_vencimiento", nullable = false)
	private int anio_vencimiento;
	
	@Column(name = "mes_vencimiento", nullable = false)
	private int mes_vencimiento;

	@Column(name = "ccv", nullable = false, length = 3)
	private int ccv;

	@ManyToOne()
	@JoinColumn(name = "id_persona")
	@JsonBackReference
	private Persona persona;

	public long getId_tarjeta() {
		return id_tarjeta;
	}

	public void setId_tarjeta(long id_tarjeta) {
		this.id_tarjeta = id_tarjeta;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getAnio_vencimiento() {
		return anio_vencimiento;
	}

	public void setAnio_vencimiento(int anio_vencimiento) {
		this.anio_vencimiento = anio_vencimiento;
	}

	public int getMes_vencimiento() {
		return mes_vencimiento;
	}

	public void setMes_vencimiento(int mes_vencimiento) {
		this.mes_vencimiento = mes_vencimiento;
	}

	public int getCcv() {
		return ccv;
	}

	public void setCcv(int ccv) {
		this.ccv = ccv;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
