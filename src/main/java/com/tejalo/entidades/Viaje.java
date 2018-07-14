package com.tejalo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.aspectj.lang.annotation.SuppressAjWarnings;
@SuppressAjWarnings("serial")
@Entity
@Table(name = "viaje")
public class Viaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idViaje;
	private Long distritoOrigen;
	private Long distritoDestino;
	@Column(length = 16)
	private String fecha;
	@Column(length = 5)
	private String hora;
	private int cantidad;
	private double tarifa;
	@Column(length = 1)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="codigo")
	private Usuario usuario;

	

	public Long getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(Long idViaje) {
		this.idViaje = idViaje;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getDistritoOrigen() {
		return distritoOrigen;
	}

	public void setDistritoOrigen(Long distritoOrigen) {
		this.distritoOrigen = distritoOrigen;
	}

	public Long getDistritoDestino() {
		return distritoDestino;
	}

	public void setDistritoDestino(Long distritoDestino) {
		this.distritoDestino = distritoDestino;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	

}
