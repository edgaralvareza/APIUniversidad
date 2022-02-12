package com.ibm.proyectos.universidad.servicios;

import com.ibm.proyectos.universidad.modelo.entidades.Direccion;
import com.ibm.proyectos.universidad.modelo.entidades.Pabellon;

public interface PabellonDAO extends GenericoDAO<Pabellon>
{

	public Iterable<Pabellon> findPabellonByLocalidadContains(String localidad);
	public Iterable<Pabellon> findPabellonByNombreContains(String nombre);

}
