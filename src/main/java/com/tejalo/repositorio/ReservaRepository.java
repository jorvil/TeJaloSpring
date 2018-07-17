package com.tejalo.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tejalo.entidades.Reserva;


public interface ReservaRepository extends CrudRepository<Reserva, Long>{

	//Consulta interna para realizar luego la actualizacion de estado
	Reserva findByIdReserva(Long idReserva);
	
	//Consulta para buscar las reservas por pasajero
	@Query(value="Select id_reserva,fecha,estado,hora,id_viaje,codigo from reserva  r "
			+ "where r.codigo=?1",nativeQuery=true)
	  List<Reserva> findDataByReservaPasajero(Long codigo);
	
	//Consulta para obtener las reservas que tiene un conductor por viaje
	@Query(value="Select id_reserva,fecha,estado,hora,id_viaje,codigo from reserva  r "
			+ "where r.id_viaje=?1 and r.estado='P'",nativeQuery=true)
	  List<Reserva> findDataByReservaConductor(Long idviaje);
	
	//Metodo de actualizacion masiva para un viaje que se cancela
	@Modifying
	@Transactional
	@Query(value="update reserva set estado='C' where id_viaje=?1",nativeQuery=true)
	void CancelarReservasViaje(Long idviaje);
	
	//Metodo de actualizacion masiva para un viaje que se termina
	@Modifying
	@Transactional
	@Query(value="update reserva set estado='T' where id_viaje=?1",nativeQuery=true)
	void TerminarReservasViaje(Long idviaje);
	
	
}
