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

import com.tejalo.entidades.Usuario;
import com.tejalo.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@GetMapping("/usuarios")
	public List<Usuario> obtenerUsuarios(){		
		return(List<Usuario>) usuarioRepositorio.findAll();
	}

	@PostMapping("/registrarUsuario")
	public Usuario registrarUSuario(@Valid @RequestBody Usuario usuario) {

		return usuarioRepositorio.save(usuario);
	}
	
	
	@GetMapping("/usuarios/{nombre}/{password}")
	public List<Usuario> obtenerUsuarioByFetch(@PathVariable(value = "nombre") String nombre,
			@PathVariable(value = "password") String password) {
		return usuarioRepositorio.findDataByLogin(nombre, password);
	}
	
	
	/////////////////////////
	
	@GetMapping("/usuario/{codigo}") 
	 public Usuario	obtenerUsuarioById(@PathVariable(value = "codigo") Long codigo) {
		return usuarioRepositorio.findBycodigo(codigo);
	    }
	

	@GetMapping("/usuario/buscarDNI/{DNI}") 
	 public Usuario	 findDataByDNI(@PathVariable(value = "DNI") String DNI) {
	    return usuarioRepositorio.findDataByDNI(DNI);
	    }
	
	@GetMapping("/usuario/buscaremail/{email}") 
	 public Usuario	 findDataByemail(@PathVariable(value = "email") String email) {
	    return usuarioRepositorio.findDataByemail(email);
	    }
	
	@PutMapping("/usuario/{codigo}")
	public Usuario actualizarProducto(@PathVariable(value = "codigo") Long codigo,
			@Valid @RequestBody Usuario usuarioDetalle) {
		
		Usuario usuario = usuarioRepositorio.findBycodigo(codigo);
		
		usuario.setApellido(usuarioDetalle.getApellido());
		usuario.setNombre(usuarioDetalle.getNombre());
		usuario.setTelefono(usuarioDetalle.getTelefono());

		Usuario updatedUsuario = usuarioRepositorio.save(usuario);
		return updatedUsuario;
	}
	
	
	@PutMapping("/usuario/eliminar/{codigo}")
	public Usuario actualizarestadoProducto(@PathVariable(value = "codigo") Long codigo,
			@Valid @RequestBody Usuario usuarioDetalle) {
		
		Usuario usuario = usuarioRepositorio.findBycodigo(codigo);
		
		usuario.setEstado("I");		

		Usuario updatedUsuario = usuarioRepositorio.save(usuario);
		return updatedUsuario;
	}	
	
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable(value = "id") Long codigo) {
	    Usuario usuario = usuarioRepositorio.findBycodigo(codigo);	            

	    usuarioRepositorio.deleteById(codigo);

	    return ResponseEntity.ok().build();
	}
}
