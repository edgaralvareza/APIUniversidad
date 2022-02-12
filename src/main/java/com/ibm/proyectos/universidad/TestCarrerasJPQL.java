package com.ibm.proyectos.universidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ibm.proyectos.universidad.modelo.entidades.Alumno;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Direccion;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.servicios.AlumnoDAO;
import com.ibm.proyectos.universidad.servicios.CarreraDAO;
import com.ibm.proyectos.universidad.modelo.entidades.Direccion;

@Component
public class TestCarrerasJPQL implements CommandLineRunner 
{
	@Autowired
	private CarreraDAO carreraDao;
	
	@Autowired
	private AlumnoDAO alumnoDao; 
	
	@Override
	public void run(String... args) throws Exception 
	{
		
		 /* Carrera ingIndustrial = new Carrera(null, "Ingenieria Industrial", 55, 5, "EAlvarez");
	        Carrera ingAlimentos = new Carrera(null, "Ingenieria en Alimentos", 53, 5, "EAlvarez");
	        Carrera ingElectronica = new Carrera(null, "Ingenieria Electronica", 45, 5, "EAlvarez");
	        Carrera licSistemas = new Carrera(null, "Licenciatura en Sistemas", 40, 4, "EAlvarez");
	        Carrera licTurismo = new Carrera(null, "Licenciatura en Turismo", 42, 4, "EAlvarez");
	        Carrera licYoga = new Carrera(null, "Licenciatura en Yoga", 25, 3, "EAlvarez");
	        Carrera licRecursos = new Carrera(null, "Licenciatura en Recursos Humanos - RRHH", 33, 3, "EAlvarez"); 
	        
	        carreraDao.guardar(ingIndustrial);
	        carreraDao.guardar(ingAlimentos);
	        carreraDao.guardar(ingElectronica);
	        carreraDao.guardar(licSistemas);
	        carreraDao.guardar(licTurismo);
	        carreraDao.guardar(licYoga);
	        carreraDao.guardar(licRecursos); */
	        
	       /* Carrera ingTelematica = new Carrera(null, "Ingenieria en telematica", 48, 6, "EAlvarez");
	        carreraDao.guardar(ingTelematica);
	        /*
	        Carrera ingenieriaSistemas = new Carrera(null, "sistemas", 60, 5, "EAlvarez");
			Carrera carrera = carreraDao.guardar(ingenieriaSistemas);
			System.out.println(carrera.toString());  */	
			
	        
	        
	      
			
	}
}
