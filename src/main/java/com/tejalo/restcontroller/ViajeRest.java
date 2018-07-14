package com.tejalo.restcontroller;

import java.io.IOException;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	
	
	@GetMapping("/viajes")
	public List<Viaje> obtenerViajes(){		
		return(List<Viaje>) viajeRepository.findAll();
	}
	/*
	@GetMapping("/buscarviajes/{mensaje}")
	public List<Viaje> BuscarViaje(@PathVariable(value="mensaje") String mensaje) {

		ObjectMapper mapper = new ObjectMapper();
		Viaje viajes;
		try {
			viajes = mapper.readValue(mensaje, Viaje.class);			
			String EncontrarViajes = "SELECT * FROM VIAJE V WHERE V.estado = 'P' "
					+ "AND V.distrito_origen = 2 AND V.distrito_destino =  1 ";
			
			
			return (List<Viaje>) viajeRepository.EncontrarViajes(EncontrarViajes);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	*/
	//
	@GetMapping("/viajes/{codigo}")
	public Optional<Viaje> ObtenerViaje(@PathVariable(value = "codigo") Long codigo) {
		return viajeRepository.findById(codigo);
	}

	@GetMapping("/viajes/buscar/{DNI}")
	public List<Viaje> findDataByDNI(@PathVariable(value = "DNI") String DNI) {
		return (List<Viaje>) viajeRepository.findAll();
	}

	@PutMapping("/viajes/{codigo}")
	public Viaje ActualizarViaje(@PathVariable(value = "codigo") Long idViaje,
			@Valid @RequestBody Viaje ViajesDetalles) {

		Viaje viaje = viajeRepository.findByIdViaje(idViaje);

		viaje.setEstado(ViajesDetalles.getEstado());
		Viaje update = viajeRepository.save(viaje);

		return update;
	}
	
	@GetMapping("/viaje/{distritoorigen}/{distritodestino}/{fecha}")
	public List<Viaje> obtenerUsuarioByFetch(@PathVariable(value = "distritoorigen") Long distritoorigen,
			@PathVariable(value = "distritodestino") Long distritodestino,@PathVariable(value = "fecha") String fecha) {
		return viajeRepository.findDataByViajeFecha(distritoorigen, distritodestino,fecha);
	}
	
}
