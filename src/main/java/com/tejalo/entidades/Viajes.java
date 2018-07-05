package com.tejalo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "viajes")
public class Viajes implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(length = 50)
	private Long DistritoPartidaId;
	@Column(length = 50)
	private Long DistritoLlegadaId;
	@Column(length = 50)
	private Date FechaPartida;
	@Column(length = 50)
	private Date FechaLlegada;
	@Column(length = 50)
	private Float Precio;
	private Boolean Activado;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getDistritoPartidaId() {
		return DistritoPartidaId;
	}

	public void setDistritoPartidaId(Long distritoPartidaId) {
		DistritoPartidaId = distritoPartidaId;
	}

	public Long getDistritoLlegadaId() {
		return DistritoLlegadaId;
	}

	public void setDistritoLlegadaId(Long distritoLlegadaId) {
		DistritoLlegadaId = distritoLlegadaId;
	}

	public Date getFechaPartida() {
		return FechaPartida;
	}

	public void setFechaPartida(Date fechaPartida) {
		FechaPartida = fechaPartida;
	}

	public Date getFechaLlegada() {
		return FechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		FechaLlegada = fechaLlegada;
	}

	public Float getPrecio() {
		return Precio;
	}

	public void setPrecio(Float precio) {
		Precio = precio;
	}

	public Boolean getActivado() {
		return Activado;
	}

	public void setActivado(Boolean activado) {
		Activado = activado;
	}

}
