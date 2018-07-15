package com.tejalo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;


import com.tejalo.entidades.Viaje;

public interface ViajeRepository extends CrudRepository<Viaje, Long>{
	//Consulta interna para realizar luego la actualizacion
	Viaje findByIdViaje(Long idviaje);	
	
	//Consulta para pasajeros
	//Filtra por distrito de origen y destino además de la fecha
	@Query(value = "select id_viaje,cantidad,distrito_destino,distrito_origen,v.estado,fecha,hora,tarifa,codigo from viaje  v  "
			+ "where v.distrito_origen = ?1 and v.distrito_destino = ?2 and v.estado='P' and v.fecha=?3 ", nativeQuery = true)
	  List<Viaje> findDataByViajeFecha(Long distritoOrigen, Long distritoDestino, String fecha);
	
	//Consulta para conductores
	//Filtra todos los viajes de los conductores
	@Query(value="Select id_viaje,cantidad,distrito_destino,distrito_origen,v.estado,fecha,hora,tarifa,codigo from viaje  v "
			+ "where v.codigo=?1",nativeQuery=true)
	 List<Viaje> findDataByViajeUsuario(Long codigo);
	

}
