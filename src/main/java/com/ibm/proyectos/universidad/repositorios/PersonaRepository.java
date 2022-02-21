package com.ibm.proyectos.universidad.repositorios;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import org.springframework.stereotype.Repository;


@Primary
public interface PersonaRepository extends CrudRepository<Persona, Long> 
{
	@Query("select p from Persona p where p.nombre = ?1 and p.apellido = ?2")
	public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
	
	@Query("select p from Persona p where p.dni = ?1")
	public Optional<Persona> buscarPorDni(String dni);
	
	@Query("select p from Persona p where p.apellido like %?1%")
	public Optional<Persona> buscarPersonaPorApellido(String apellido);
}
