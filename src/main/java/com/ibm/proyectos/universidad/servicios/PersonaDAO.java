package com.ibm.proyectos.universidad.servicios;

import java.util.Optional;

import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.servicios.GenericoDAO;

public interface PersonaDAO extends GenericoDAO<Persona>
{
	public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
	public Optional<Persona> buscarPorDni(String dni);
	public Iterable<Persona> buscarPersonaPorApellido(String apellido);
}
