package com.tejalo.restcontroller;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tejalo.entidades.Correo;
import com.tejalo.entidades.Usuario;
import com.tejalo.excepcion.ResourceNotFoundException;
import com.tejalo.repositorio.UsuarioRepository;


@RestController
@RequestMapping("/api")
public class UsuarioRest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/usuarios")
	public List<Usuario> obtenerUsuarios() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@PostMapping("/registrarUsuario")
	public Usuario registrarUSuario(@Valid @RequestBody Usuario usuario) {

		try {
			Usuario grabado = usuarioRepository.save(usuario);
			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper mapper = new ObjectMapper();
			
			String url = "http://intranet.fridaysperu.com:9090/api/enviar/{parametros}";
			String parametros = "{\"asunto\":\"Bienvenido a Tejalo\",\"cuerpo\":\"Bienvenido "+usuario.getApellido() +" " + usuario.getNombre() +" a la comunidad Tejalo\",\"destinatario\":\""+usuario.getEmail()+"\"}";
			String UsuarioRecibido = mapper.writeValueAsString(usuario);
			System.out.println("Estructura Usuario a Grabar:" + UsuarioRecibido);
			System.out.println("Estructura GET:" + url);
			
			 String result = restTemplate.getForObject(url, String.class, parametros);

			    System.out.println(result);
			return grabado;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Ups que fue!");	
			e.printStackTrace();
			return null;
		}		
		
		
	}

	@GetMapping("/usuario/{nombre}/{password}")
	public ResponseEntity  obtenerUsuarioByFetch(@PathVariable(value = "nombre") String nombre,
			@PathVariable(value = "password") String password) {
		Usuario usuario=usuarioRepository.findDataByLogin(nombre, password);
		if(usuario==null) {
			throw new ResourceNotFoundException("Usuario", "Nombre", nombre);
			
		}
		return ResponseEntity.ok(usuario);
	}

	/////////////////////////

	@GetMapping("/usuario/{codigo}")
	public Usuario obtenerUsuarioById(@PathVariable(value = "codigo") Long codigo) {
		return usuarioRepository.findBycodigo(codigo);
	}

	@GetMapping("/usuario/buscarDNI/{DNI}")
	public Usuario findDataByDNI(@PathVariable(value = "DNI") String DNI) {
		return usuarioRepository.findDataByDNI(DNI);
	}

	@GetMapping("/usuario/buscaremail/{email}")
	public Usuario findDataByemail(@PathVariable(value = "email") String email) {
		return usuarioRepository.findDataByemail(email);
	}

	@PutMapping("/usuario/{codigo}")
	public Usuario actualizarProducto(@PathVariable(value = "codigo") Long codigo,
			@Valid @RequestBody Usuario usuarioDetalle) {

		Usuario usuario = usuarioRepository.findBycodigo(codigo);

		usuario.setApellido(usuarioDetalle.getApellido());
		usuario.setNombre(usuarioDetalle.getNombre());
		usuario.setTelefono(usuarioDetalle.getTelefono());

		Usuario updatedUsuario = usuarioRepository.save(usuario);
		return updatedUsuario;
	}

	@PutMapping("/usuario/eliminar/{codigo}")
	public Usuario actualizarestadoProducto(@PathVariable(value = "codigo") Long codigo,
			@Valid @RequestBody Usuario usuarioDetalle) {

		Usuario usuario = usuarioRepository.findBycodigo(codigo);

		usuario.setEstado("I");

		Usuario updatedUsuario = usuarioRepository.save(usuario);
		return updatedUsuario;
	}

	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable(value = "id") Long codigo) {
		Usuario usuario = usuarioRepository.findBycodigo(codigo);

		usuarioRepository.deleteById(codigo);

		return ResponseEntity.ok().build();
	}

}
