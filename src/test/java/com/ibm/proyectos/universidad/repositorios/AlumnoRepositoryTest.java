package com.ibm.proyectos.universidad.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.Query;

import com.ibm.proyectos.universidad.datos.DatosDummy;
import com.ibm.proyectos.universidad.modelo.entidades.Alumno;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;


@DataJpaTest
public class AlumnoRepositoryTest 

{
	
	@Autowired
	@Qualifier("repositorioAlumno")
	private PersonaRepository alumnoRepository;
	
	@Autowired
	private CarreraRepository carreraRepository;

	@Test
	@DisplayName("Test: Buscar Alumnos por Nombre de Carrera")
	void buscarAlumnosPorNombreCarrera() 
	{
		
		Iterable<Persona> personas = alumnoRepository.saveAll(
		Arrays.asList(
				DatosDummy.alumno01(),
				DatosDummy.alumno02(),
				DatosDummy.alumno03())
				); 
		Carrera carrera = carreraRepository.save(DatosDummy.carrera01());
		
		personas.forEach(alumno -> ((Alumno)alumno).setCarrera(carrera));
		alumnoRepository.saveAll(personas);
		
		
		String carreraNombre ="Ingenieria en Sistemas";
		List<Persona> expected= (List<Persona>) ((AlumnoRepository)alumnoRepository).buscarAlumnosPorNombreCarrera(carreraNombre);
		
		
		assertThat(expected.size()==3).isTrue();
		
		
		
	}
}
