package com.tejalo.restcontroller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejalo.entidades.Usuarios;
import com.tejalo.repositorio.UsuariosRepositorio;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuariosRepositorio usuariosRepositorio;
	
	@GetMapping("/usuarios")
	public List<Usuarios> obtenerUsuarios(){		
		return(List<Usuarios>) usuariosRepositorio.findAll();
	}

	@PostMapping("/registrarUsuario")
	public Usuarios registrarUSuario(@Valid @RequestBody Usuarios usuario) {

		return usuariosRepositorio.save(usuario);
	}
	
	
	@GetMapping("/usuarios/{nombre}/{password}")
	public List<Usuarios> obtenerUsuarioByFetch(@PathVariable(value = "nombre") String nombre,
			@PathVariable(value = "password") String password) {
		return usuariosRepositorio.findDataByLogin(nombre, password);
	}
	
	
	/////////////////////////
	
	@GetMapping("/usuario/{codigo}") 
	 public Usuarios	obtenerUsuarioById(@PathVariable(value = "codigo") Long codigo) {
		return usuariosRepositorio.findBycodigo(codigo);
	    }
	

	@GetMapping("/usuario/buscarDNI/{DNI}") 
	 public Usuarios	 findDataByDNI(@PathVariable(value = "DNI") String DNI) {
	    return usuariosRepositorio.findDataByDNI(DNI);
	    }
	
	@GetMapping("/usuario/buscaremail/{email}") 
	 public Usuarios	 findDataByemail(@PathVariable(value = "email") String email) {
	    return usuariosRepositorio.findDataByemail(email);
	    }
	
	@PutMapping("/usuario/{codigo}")
	public Usuarios actualizarProducto(@PathVariable(value = "codigo") Long codigo,
			@Valid @RequestBody Usuarios usuarioDetalle) {
		
		Usuarios usuario = usuariosRepositorio.findBycodigo(codigo);
		
		usuario.setApellido(usuarioDetalle.getApellido());
		usuario.setNombre(usuarioDetalle.getNombre());
		usuario.setTelefono(usuarioDetalle.getTelefono());

		Usuarios updatedUsuario = usuariosRepositorio.save(usuario);
		return updatedUsuario;
	}
	
	
	@PutMapping("/usuario/eliminar/{codigo}")
	public Usuarios actualizarestadoProducto(@PathVariable(value = "codigo") Long codigo,
			@Valid @RequestBody Usuarios usuarioDetalle) {
		
		Usuarios usuario = usuariosRepositorio.findBycodigo(codigo);
		
		usuario.setEstado("I");		

		Usuarios updatedUsuario = usuariosRepositorio.save(usuario);
		return updatedUsuario;
	}	
	
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable(value = "id") Long codigo) {
	    Usuarios usuario = usuariosRepositorio.findBycodigo(codigo);	            

	    usuariosRepositorio.deleteById(codigo);

	    return ResponseEntity.ok().build();
	}
}
