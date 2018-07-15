package com.tejalo.restcontroller;

import java.util.List;
import java.util.Optional;

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

@RestController
@RequestMapping("/api")
public class ReservaRest {
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@PostMapping("/reservarViaje")
	public Reserva RegistrarReserva(@Valid @RequestBody Reserva reserva) {

		return reservaRepository.save(reserva);
	}
	
	@GetMapping("/Reservas")
	public List<Reserva> obtenerReservas(){		
		return(List<Reserva>) reservaRepository.findAll();
	}
	
	
	@PutMapping("/CancelarReserva/{idreserva}")
	public Reserva CancelarReserva(@PathVariable(value = "idreserva") Long idreserva,
			@Valid @RequestBody Reserva ReservaDetalles) {

		Reserva Reserva = reservaRepository.findByIdReserva(idreserva);
		Reserva.setEstado("C");
		Reserva update = reservaRepository.save(Reserva);

		return update;
	}
	
	@PutMapping("/TerminarReserva/{idViaje}")
	public Reserva TerminarReserva(@PathVariable(value = "idreserva") Long idreserva,
			@Valid @RequestBody Viaje ReservaDetalles) {

		Reserva Reserva = reservaRepository.findByIdReserva(idreserva);

		Reserva.setEstado("T");
		Reserva update = reservaRepository.save(Reserva);

		return update;
	}
	
	@GetMapping("/ReservaUsuario/{idConductor}")
	public List<Reserva> obtenerReservaByUsuario(@PathVariable(value = "idConductor") Long codigo) {
		return reservaRepository.findDataByReservaPasajero(codigo);
	}
	
	@GetMapping("/ReservaConductor/{idConductor}")
	public List<Reserva> obtenerReservaByConductor(@PathVariable(value = "idConductor") Long codigo) {
		return reservaRepository.findDataByReservaCondudctor(codigo);
	}
}
