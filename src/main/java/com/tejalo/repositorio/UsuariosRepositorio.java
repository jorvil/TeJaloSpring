package com.tejalo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tejalo.entidades.Usuarios;

public interface UsuariosRepositorio extends CrudRepository<Usuarios, Long>{

	Usuarios findBycodigo(Long codigo);
	 
	 @Query(value = "SELECT * FROM usuario u WHERE u.dni = ?1", nativeQuery = true)
	 Usuarios findDataByDNI(String DNI);
	 
	 @Query(value = "SELECT * FROM usuario u WHERE u.email = ?1", nativeQuery = true)
	 Usuarios findDataByemail(String email);
	 
	 
	 @Query(value = "SELECT * FROM usuario u WHERE u.nombre = ?1 and password = ?2 and estado='A'", nativeQuery = true)
	  List<Usuarios> findDataByLogin(String nombre, String password);
	 
	 
	
}
