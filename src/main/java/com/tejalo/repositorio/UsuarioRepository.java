package com.tejalo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tejalo.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	Usuario findBycodigo(Long codigo);
	 
	 @Query(value = "SELECT * FROM usuario u WHERE u.dni = ?1", nativeQuery = true)
	 Usuario findDataByDNI(String DNI);
	 
	 @Query(value = "SELECT * FROM usuario u WHERE u.email = ?1", nativeQuery = true)
	 Usuario findDataByemail(String email);
	 
	 
	 @Query(value = "SELECT * FROM usuario u WHERE u.nombre = ?1 and password = ?2 and estado='A'", nativeQuery = true)
	  List<Usuario> findDataByLogin(String nombre, String password);
	 

}
