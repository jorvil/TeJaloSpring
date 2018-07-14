package com.tejalo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "viaje")
public class Viaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
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
	private Long usuarioCodigo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public Long getUsuarioCodigo() {
		return usuarioCodigo;
	}

	public void setUsuarioCodigo(Long usuarioCodigo) {
		this.usuarioCodigo = usuarioCodigo;
	}

}
