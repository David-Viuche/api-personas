package com.david.personas.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tarjetas")

public class Tarjeta {
	@Id   
	@Column(name = "id_tarjeta")
	@GeneratedValue(generator="seq_id_tarjeta")
	@SequenceGenerator(name="seq_id_tarjeta", sequenceName="SEQ_ID_TARJETA", allocationSize=1)
	private long id_tarjeta;
	
	@Column(name="numero", nullable = false, length = 20)
	private String numero;
	
	@Column(name="fecha_vencimiento", nullable = false)
	private Date fecha_vencimiento;
	
	@Column(name="ccv", nullable = false, length = 3)
	private int ccv;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_persona")
	private Persona persona;
//    private University university;
//	
//	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    

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

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
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
