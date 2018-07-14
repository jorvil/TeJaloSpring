package com.tejalo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.hibernate.exception.SQLGrammarException;

import com.tejalo.entidades.Viaje;

public interface ViajeRepository extends CrudRepository<Viaje, Long>{

	Viaje findByIdViaje(Long idviaje);
	
	@Query(value = "?1",nativeQuery = true)
	  List<Viaje> EncontrarViajes(String Query);
	
	
	@Query(value = "select id_viaje,cantidad,distrito_destino,distrito_origen,v.estado,fecha,hora,tarifa,u.nombre from viaje v,usuario u "
			+ " where u.codigo=v.codigo and v.distrito_origen = ?1 and v.distrito_destino = ?2 and v.estado='P' and v.fecha=?3 ", nativeQuery = true)
	  List<Viaje> findDataByViajeFecha(Long distritoOrigen, Long distritoDestino, String fecha);

}
