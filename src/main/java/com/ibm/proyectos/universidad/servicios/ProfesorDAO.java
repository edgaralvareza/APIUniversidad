package com.ibm.proyectos.universidad.servicios;

import com.ibm.proyectos.universidad.modelo.entidades.Persona;

public interface ProfesorDAO extends PersonaDAO

{

	public Iterable<Persona> findProfesorByNombreCarrera(String nombreCarrera);
	public Persona actualizar(Long profesorId, Persona profesor);
	public Persona asociarCarreraProfesores(Long carreraId, Long profesorId);

}
