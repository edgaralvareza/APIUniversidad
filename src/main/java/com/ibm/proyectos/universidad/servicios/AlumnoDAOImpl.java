package com.ibm.proyectos.universidad.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.repositorios.AlumnoRepository;
import com.ibm.proyectos.universidad.repositorios.PersonaRepository;
import com.ibm.proyectos.universidad.servicios.AlumnoDAO;
import com.ibm.proyectos.universidad.servicios.PersonaDAOImpl;

@Service
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO 
{
	@Autowired
	public AlumnoDAOImpl(@Qualifier("repositorioAlumno")PersonaRepository repository) 
	{
		super(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombreCarrera) 
	{
		return ((AlumnoRepository)repository).buscarAlumnosPorNombreCarrera(nombreCarrera);
	}
}
