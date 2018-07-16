package com.tejalo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "viaje")
public class Viaje implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idViaje;	
	@Column(length = 16)
	private String fecha;
	@Column(length = 5)
	private String hora;
	private int cantidad;
	private double tarifa;
	@Column(length = 1)
	private String estado;
	private int disponible;
	
	@ManyToOne
	@JoinColumn(name="codigo")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="origen")
	private Distritos origen;
	
	@ManyToOne
	@JoinColumn(name="destino")
	private Distritos destino;
	

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

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	public Distritos getOrigen() {
		return origen;
	}

	public void setOrigen(Distritos origen) {
		this.origen = origen;
	}

	public Distritos getDestino() {
		return destino;
	}

	public void setDestino(Distritos destino) {
		this.destino = destino;
	}

	

}
