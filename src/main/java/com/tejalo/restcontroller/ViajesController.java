package com.tejalo.restcontroller;

import java.util.List;
import java.util.Optional;

//import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejalo.entidades.Distritos;
import com.tejalo.entidades.Usuario;
import com.tejalo.entidades.Viajes;
import com.tejalo.repositorio.ViajesRepositorio;

@RestController
@RequestMapping("/api")
public class ViajesController {

	@Autowired
	private ViajesRepositorio repositorio;

	@PostMapping("/viajes")
	public Viajes RegistrarViaje(@Valid @RequestBody Viajes viajes) {

		return repositorio.save(viajes);
	}

	//
	@GetMapping("/viajes/{codigo}")
	public Optional<Viajes> ObtenerViaje(@PathVariable(value = "codigo") Long codigo) {
		return repositorio.findById(codigo);
	}

	@GetMapping("/viajes/buscar/{DNI}")
	public List<Viajes> findDataByDNI(@PathVariable(value = "DNI") String DNI) {
		return (List<Viajes>) repositorio.findAll();
	}

	@PutMapping("/viajes/{codigo}")
	public Viajes ActualizarViaje(@PathVariable(value = "codigo") Long codigo,
			@Valid @RequestBody Viajes ViajesDetalles) {

		Viajes viaje = repositorio.findBycodigo(codigo);

		viaje.setActivado(ViajesDetalles.getActivado());
		Viajes update = repositorio.save(viaje);

		return update;
	}
}
