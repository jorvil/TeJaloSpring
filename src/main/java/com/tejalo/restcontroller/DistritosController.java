package com.tejalo.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejalo.entidades.Distritos;
import com.tejalo.repositorio.DistritosRepositorio;

@RestController
@RequestMapping("/api")
public class DistritosController {
	@Autowired
	private DistritosRepositorio ProvinciasRepositorio;

	@GetMapping("/distritos")
	public List<Distritos> obtenerProductos() {
		return (List<Distritos>) ProvinciasRepositorio.findAll();
	}

	@PostMapping("/distrito")
	public Distritos creatProducto(@Valid @RequestBody Distritos distrito) {
		return ProvinciasRepositorio.save(distrito);
	}

	@GetMapping("/distrito/{codigo}")
	public Optional<Distritos> obtenerProductoById(@PathVariable(value = "codigo") Long codigo) {
		return ProvinciasRepositorio.findById(codigo);

	}
}