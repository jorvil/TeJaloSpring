package com.tejalo.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejalo.entidades.Reserva;

import com.tejalo.repositorio.ReservaRepository;

@RestController
@RequestMapping("/api")
public class ReservaRest {
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@PostMapping("/registrarViaje")
	public Reserva RegistrarViaje(@Valid @RequestBody Reserva reserva) {

		return reservaRepository.save(reserva);
	}
	
}
