package com.ibm.proyectos.universidad.servicios;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.repositorios.PersonaRepository;
import com.ibm.proyectos.universidad.repositorios.ProfesorRepository;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO
{
	@Autowired
	public ProfesorDAOImpl(@Qualifier("repositorioProfesor")PersonaRepository repository)
	{
		super(repository);

	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> findProfesorByNombreCarrera(String nombreCarrera) {
		
		return ((ProfesorRepository)repository).findProfesorByNombreCarrera(nombreCarrera);
	}
	
	
	

	
	
}
