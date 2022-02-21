package com.ibm.proyectos.universidad.servicios;

import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.servicios.PersonaDAO;

public interface AlumnoDAO extends PersonaDAO
{

	public Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombreCarrera);
	public Persona actualizar(Long alumnoId, Persona alumno);
	public Persona asociarCarreraAlumno(Long carreraId, Long alumnoId);

}