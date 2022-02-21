package com.ibm.proyectos.universidad.servicios;

import java.util.Optional;

import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.servicios.GenericoDAO;

public interface PersonaDAO extends GenericoDAO<Persona>
{
	public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
	public Optional<Persona> buscarPorDni(String dni);
	public Optional<Persona> buscarPersonaPorApellido(String apellido);
	public Persona actualizar(Long personaId, Persona persona);
}
