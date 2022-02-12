package com.ibm.proyectos.universidad.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
import com.ibm.proyectos.universidad.modelo.entidades.Profesor;

@DataJpaTest
public class ProfesorRepositoryTest 

{
	@Autowired
	@Qualifier("repositorioProfesor")
	private PersonaRepository profesorRepository;
	
	@Autowired
	private CarreraRepository carreraRepository;

	@BeforeEach
	void SetUp() 
	{
	
		profesorRepository.save(DatosDummy.profesor01());
		
	}
	
	@AfterEach
	void tearDown() {
	
		profesorRepository.deleteAll();
	}
	
	@Test
	@Disabled
	@DisplayName("Test: Buscar Profesor por Nombre de Carrera")
	void findProfesorByNombreCarrera()
	{
		Iterable<Persona> personas = profesorRepository.saveAll(
				Arrays.asList(
						DatosDummy.profesor01())
						); 
		Set<Carrera> carrera = (Set<Carrera>) carreraRepository.saveAll(Arrays.asList(DatosDummy.carrera01()));
				
				personas.forEach(profesor -> ((Profesor)profesor).setCarreras((Set<Carrera>) carrera));
				profesorRepository.saveAll(personas);
				
				
				String carreraNombre ="Ingenieria en Sistemas";
				List<Persona> expected=  (List<Persona>) ((ProfesorRepository) profesorRepository).findProfesorByNombreCarrera("");
				
				
				assertThat(expected.size()==1).isTrue();
		
		
		
	}

	
}
