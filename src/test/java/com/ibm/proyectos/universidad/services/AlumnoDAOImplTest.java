package com.ibm.proyectos.universidad.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.proyectos.universidad.datos.DatosDummy;
import com.ibm.proyectos.universidad.enumeradores.TipoPizarron;
import com.ibm.proyectos.universidad.modelo.entidades.Alumno;
import com.ibm.proyectos.universidad.modelo.entidades.Aula;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.repositorios.AlumnoRepository;
import com.ibm.proyectos.universidad.repositorios.AulaRepository;
import com.ibm.proyectos.universidad.repositorios.CarreraRepository;
import com.ibm.proyectos.universidad.servicios.AlumnoDAO;
import com.ibm.proyectos.universidad.servicios.AlumnoDAOImpl;
import com.ibm.proyectos.universidad.servicios.AulaDAOImpl;

public class AlumnoDAOImplTest 
{
	AlumnoDAO alumnoDAO;
	AlumnoRepository alumnoRepository;

	CarreraRepository carreraRepository;
	
	@BeforeEach
	void SetUp() {
		alumnoRepository = mock(AlumnoRepository.class);
		alumnoDAO = new AlumnoDAOImpl(alumnoRepository);

		Iterable<Persona> personas = alumnoRepository.saveAll(
				Arrays.asList(
						DatosDummy.alumno01(),
						DatosDummy.alumno02(),
						DatosDummy.alumno03())
						); 
		Carrera carrera = carreraRepository.save(DatosDummy.carrera01());
		
		personas.forEach(alumno -> ((Alumno)alumno).setCarrera(carrera));
		alumnoRepository.saveAll(personas);
	}
	
	@Test
	@Disabled
	@DisplayName("Test: Buscar Alumnos por Nombre de Carrera")
	void buscarAlumnosPorNombreCarrera() 
	{
		

	String nombreCarrera="Ingenieria";
	
	
	
		when (alumnoRepository.buscarAlumnosPorNombreCarrera(nombreCarrera)).thenReturn(Arrays.asList(DatosDummy.alumno01(),DatosDummy.alumno02(),DatosDummy.alumno03()));
		
		
		
		List <Persona> expected = (List<Persona>) alumnoDAO.buscarAlumnosPorNombreCarrera(nombreCarrera);
		 
		assertThat(expected.get(0)).isEqualTo(DatosDummy.alumno01());
		verify(alumnoRepository).buscarAlumnosPorNombreCarrera(nombreCarrera);
		
		
		
	}

}
