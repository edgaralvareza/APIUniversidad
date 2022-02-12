package com.ibm.proyectos.universidad.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.repositorios.PersonaRepository;

@Repository("repositorioProfesor")
public interface ProfesorRepository extends PersonaRepository
{
	@Query(value ="select a from Profesor a join fetch a.carrera c  where c.nombre = ?1", nativeQuery = true)
	public Iterable<Persona> findProfesorByNombreCarrera(String nombreCarrera);
}
