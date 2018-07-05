package com.tejalo.repositorio;


import org.springframework.data.repository.CrudRepository;


import com.tejalo.entidades.Viajes;

public interface ViajesRepositorio extends CrudRepository<Viajes, Long>{

	Viajes findBycodigo(Long codigo);
	
}
