package com.tejalo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.tejalo.entidades.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeJaloApplicationTests {

	@Autowired  
	private TestRestTemplate restTemplate;
	/*
	@Test
	public void testInsertUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNombre("Alexandra");
		usuario.setApellido("Salvatierra Barrantes");
		usuario.setDni("06707772");
		usuario.setEmail("ale_2018@outlook.com");
		usuario.setTelefono("926450413");
		usuario.setSexo("F");
		usuario.setPassword("123456");
		usuario.setEstado("A");
		
			ResponseEntity<Usuario> entidad = restTemplate.postForEntity("http://localhost:8888/api/registrarUsuario",usuario, Usuario.class);
			assertNotNull(entidad);	
	}
	*/
	/*
	@Test
	public void testGetUsuario() {
	
		Usuario usuario = restTemplate.getForObject("http://localhost:8888/api/usuario/2", Usuario.class);
		assertNotNull(usuario);
	}
	
	*/
	
	@Test
	public void testLoginUsuario() {
		
		Usuario usuario = restTemplate.getForObject("http://localhost:8888/api/usuario/Hugo/123456", Usuario.class);
		assertNotNull(usuario);
	}
	

}
