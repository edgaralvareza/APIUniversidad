package com.ibm.proyectos.universidad.servicios;

import java.util.Optional;

import com.ibm.proyectos.universidad.excepciones.NotFoundException;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.repositorios.PersonaRepository;
import com.ibm.proyectos.universidad.servicios.GenericoDAOImpl;
import com.ibm.proyectos.universidad.servicios.PersonaDAO;

@Service
@Primary
public class PersonaDAOImpl extends GenericoDAOImpl<Persona, PersonaRepository> implements PersonaDAO
{

	@Autowired
	public PersonaDAOImpl(PersonaRepository repository)
	{
		super(repository);
	}


	@Override
	@Transactional(readOnly = true)
	public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) 
	{
		return repository.buscarPorNombreYApellido(nombre, apellido);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Persona> buscarPorDni(String dni) 
	{
		return repository.buscarPorDni(dni);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Persona> buscarPersonaPorApellido(String apellido)
	{
		return repository.buscarPersonaPorApellido(apellido);
	}

	@Override
	public Persona actualizar(Long personaId, Persona persona) {

		Optional<Persona> oPersona = repository.findById(personaId);

		if(!oPersona.isPresent())
			throw new NotFoundException(String.format("La persona con ID %d no existe", personaId));

		Persona personaActualizada = null;
		oPersona.get().setNombre(persona.getNombre());
		oPersona.get().setApellido(persona.getApellido());
		personaActualizada = repository.save(oPersona.get());
		return personaActualizada;

	}
}
