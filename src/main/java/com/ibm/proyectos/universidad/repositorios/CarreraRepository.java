package com.ibm.proyectos.universidad.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.proyectos.universidad.modelo.entidades.Carrera;

@Repository("repositorioCarrera")
public interface CarreraRepository extends CrudRepository<Carrera, Long>
{

		public Iterable<Carrera> findCarrerasByNombreContains(String nombre);
		public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
		public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);
		
		@Query(value="select c from Carrera c join fetch c.profesor p where p.nombre = ?1 and p.apellido = ?2",nativeQuery = true)
		public Iterable<Carrera> findCarrerasByProfesorNombreYApellido(String nombre, String apellido); 
}
