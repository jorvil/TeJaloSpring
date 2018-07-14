package com.tejalo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReserva;
	private Long idRuta;
	private Long idPasajero;
	@Column(length = 16)
	private String fecha;
	@Column(length = 5)
	private String hora;	
	@Column(length = 1)
	private String estado;
	public Long getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}
	public Long getIdRuta() {
		return idRuta;
	}
	public void setIdRuta(Long idRuta) {
		this.idRuta = idRuta;
	}
	public Long getIdPasajero() {
		return idPasajero;
	}
	public void setIdPasajero(Long idPasajero) {
		this.idPasajero = idPasajero;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
