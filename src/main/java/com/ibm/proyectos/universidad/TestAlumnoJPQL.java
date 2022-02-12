package com.ibm.proyectos.universidad;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Alumno;
import com.ibm.proyectos.universidad.modelo.entidades.Direccion;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.servicios.AlumnoDAO;
import com.ibm.proyectos.universidad.servicios.AlumnoDAOImpl;
import com.ibm.proyectos.universidad.servicios.CarreraDAO;
import com.ibm.proyectos.universidad.servicios.PersonaDAO;

@Component
public class TestAlumnoJPQL implements CommandLineRunner 
{
	@Autowired
	private CarreraDAO carreraDao;

	@Autowired
	@Qualifier("alumnoDAOImpl")
	private PersonaDAO personaDao;
	
	@Autowired
	private AlumnoDAO alumnoDao;

	@Override
	public void run(String... args) throws Exception {

		/*Direccion direccionAlumno = new Direccion("Calle falsa", "11", "2235", "1506", "15", "Puebla2");
		Persona alumno = new Alumno(null, "Juanito", "Gomez", "987654321", "EAlvarez", direccionAlumno);
		alumnoDao.guardar(alumno); */
	
		/*
Optional<Carrera> ingSistemas = carreraDao.buscarPorId(5L);
		
		Iterable<Persona> alumnos = personaDao.buscarTodos();
		
		alumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(ingSistemas.get()));
		alumnos.forEach(alumno -> personaDao.guardar(alumno));
		
		
		alumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(sistemas.get()));
		alumnos.forEach(alumno -> personaDao.guardar(alumno));
        
		*/
	}

}
