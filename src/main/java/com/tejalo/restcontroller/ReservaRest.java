package com.tejalo.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejalo.entidades.Reserva;
import com.tejalo.entidades.Viaje;
import com.tejalo.repositorio.ReservaRepository;
import com.tejalo.repositorio.ViajeRepository;

@RestController
@RequestMapping("/api")
public class ReservaRest {
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private ViajeRepository viajeRepository;
	
	
	@PostMapping("/reservarViaje")
	public Reserva RegistrarReserva(@Valid @RequestBody Reserva reserva) {		
		Reserva reservaGrabada=reservaRepository.save(reserva);
		Viaje viaje=viajeRepository.findByIdViaje(reservaGrabada.getViaje().getIdViaje());
		viaje.setDisponible(viaje.getDisponible()-1);
		viajeRepository.save(viaje);
		return reservaGrabada;
	}
	
	@GetMapping("/reservas")
	public List<Reserva> obtenerReservas(){		
		return(List<Reserva>) reservaRepository.findAll();
	}
	
	
	@PutMapping("/cancelarReserva/{idReserva}")
	public Reserva CancelarReserva(@PathVariable(value = "idReserva") Long idReserva) {

		Reserva Reserva = reservaRepository.findByIdReserva(idReserva);
		Reserva.setEstado("C");
		Reserva update = reservaRepository.save(Reserva);
		Viaje viaje=viajeRepository.findByIdViaje(Reserva.getViaje().getIdViaje());
		viaje.setDisponible(viaje.getDisponible()+1);
		viajeRepository.save(viaje);

		return update;
	}
	
	@PutMapping("/terminarReserva/{idViaje}")
	public Reserva TerminarReserva(@PathVariable(value = "idreserva") Long idreserva) {

		Reserva Reserva = reservaRepository.findByIdReserva(idreserva);

		Reserva.setEstado("T");
		Reserva update = reservaRepository.save(Reserva);

		return update;
	}
	
	@GetMapping("/reservaPasajero/{idPasajero}")
	public List<Reserva> obtenerReservaByPasajero(@PathVariable(value = "idPasajero") Long codigo) {
		return reservaRepository.findDataByReservaPasajero(codigo);
	}
	
	@GetMapping("/reservaConductor/{idConductor}")
	public List<Reserva> obtenerReservaByConductor(@PathVariable(value = "idConductor") Long codigo) {
		return reservaRepository.findDataByReservaCondudctor(codigo);
	}
}
