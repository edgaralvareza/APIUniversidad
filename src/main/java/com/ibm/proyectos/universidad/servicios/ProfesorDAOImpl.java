package com.ibm.proyectos.universidad.servicios;

import com.ibm.proyectos.universidad.excepciones.NotFoundException;
import com.ibm.proyectos.universidad.modelo.entidades.Alumno;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Profesor;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.repositorios.PersonaRepository;
import com.ibm.proyectos.universidad.repositorios.ProfesorRepository;

import java.util.Optional;
import java.util.Set;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO
{
	@Autowired
	public ProfesorDAOImpl(@Qualifier("repositorioProfesor")PersonaRepository repository)
	{
		super(repository);

	}

	@Autowired
	private CarreraDAO carreraDAO;


	@Override
	public Iterable<Persona> findProfesorByNombreCarrera(String nombreCarrera) {
		return null;
	}

	@Override
	public Persona actualizar(Long profesorId, Persona profesor) {
		Optional<Persona> oProfesor = repository.findById(profesorId);

		if(!oProfesor.isPresent())
			throw new NotFoundException(String.format("El profesor con ID %d no existe", profesorId));

		Persona profesorActualizado = null;
		oProfesor.get().setNombre(profesor.getNombre());
		oProfesor.get().setApellido(profesor.getApellido());
		oProfesor.get().setDireccion(profesor.getDireccion());
		profesorActualizado = repository.save(oProfesor.get());

		return profesorActualizado;
	}

	@Override
	public Persona asociarCarreraProfesores(Long carreraId, Long profesorId) {

		Optional<Persona> oProfesor = repository.findById(profesorId);
		if(!oProfesor.isPresent())
			throw new NotFoundException(String.format("El profesor con ID %d no existe", profesorId));

		Optional<Carrera> oCarrera = carreraDAO.buscarPorId(carreraId);
		if(!oCarrera.isPresent())
			throw new NotFoundException(String.format("La carrera con ID %d no existe", carreraId));

		((Profesor)oProfesor.get()).setCarreras((Set<Carrera>) oCarrera.get());
		return repository.save(oProfesor.get());

	}




}
