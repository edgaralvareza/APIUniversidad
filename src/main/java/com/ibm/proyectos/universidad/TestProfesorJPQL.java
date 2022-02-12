package com.ibm.proyectos.universidad;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ibm.proyectos.universidad.modelo.entidades.Alumno;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Direccion;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.modelo.entidades.Profesor;
import com.ibm.proyectos.universidad.servicios.CarreraDAO;
import com.ibm.proyectos.universidad.servicios.PersonaDAO;
import com.ibm.proyectos.universidad.servicios.ProfesorDAO;

@Component
public class TestProfesorJPQL implements CommandLineRunner
{
	
	@Autowired
	private CarreraDAO carreraDao;
	
	@Autowired
	@Qualifier("profesorDAOImpl")
	private PersonaDAO personaDAO;
	
	private ProfesorDAO profesorDAO;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		/*
		
		Direccion direccionProfesor = new Direccion("Calle escuela", "13", "2231", "1501", "11", "edomex");
		Persona profesor1 = new Profesor(null, "Pedrito", "Ruiz", "21212121", "EAlvarez", direccionProfesor, null);
		profesorDAO.guardar(profesor1);
		
		
		
		<Carrera> sistemas = carreraDao.buscarPorId(5L);
		
				Iterable<Persona> profesores = personaDAO.buscarTodos();
				
				profesores.forEach(profesor -> {
					((Profesor)profesor1).setCarreras(sistemas.getClass());
					personaDAO.guardar(profesor);
				});
				
				*/
	}

}
