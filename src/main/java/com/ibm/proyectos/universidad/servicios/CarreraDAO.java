package com.ibm.proyectos.universidad.servicios;

import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.servicios.GenericoDAO;

public interface CarreraDAO extends GenericoDAO<Carrera> 
{
	public Iterable<Carrera> findCarrerasByNombreContains(String nombre);
	public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
	public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);
	public Iterable<Carrera> findCarrerasByProfesorNombreYApellido(String nombre, String apellido); 
	public Carrera actualizar(Long carreraId, Carrera carrera);
}
