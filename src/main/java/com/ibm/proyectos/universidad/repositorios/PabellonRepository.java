package com.ibm.proyectos.universidad.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.proyectos.universidad.modelo.entidades.Direccion;
import com.ibm.proyectos.universidad.modelo.entidades.Pabellon;

@Repository
public interface PabellonRepository extends CrudRepository <Pabellon,Long>
{
	@Query("select p from Pabellon p where p.direccion.localidad = ?1")
	public Iterable<Pabellon> findPabellonByLocalidadContains(String localidad);
	public Iterable<Pabellon> findPabellonByNombreContains(String nombre);
}
