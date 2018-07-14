package com.tejalo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejalo.entidades.Usuario;
import com.tejalo.repositorio.UsuarioRepository;

@RestController
@RequestMapping("/api")
public class UsuarioRest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuario")
	public List<Usuario> obtenerUsuarios(){		
		return(List<Usuario>) usuarioRepository.findAll();
	}

	@GetMapping("/usuario/{nombre}/{password}")
	public List<Usuario> obtenerUsuarioByFetch(@PathVariable(value = "nombre") String nombre,
			@PathVariable(value = "password") String password) {
		return usuarioRepository.findDataByLogin(nombre, password);
	}
}
