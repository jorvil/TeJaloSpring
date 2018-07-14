package com.tejalo.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejalo.entidades.Viaje;
import com.tejalo.repositorio.ViajeRepository;

@RestController
@RequestMapping("/api")
public class ViajeRest {

	@Autowired
	private ViajeRepository viajeRepository;
	
	@PostMapping("/registrarViaje")
	public Viaje RegistrarViaje(@Valid @RequestBody Viaje viaje) {

		return viajeRepository.save(viaje);
	}
	
}
