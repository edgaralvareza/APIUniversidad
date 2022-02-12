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
public class CarreraRepositoryTest 
{
	
	@Autowired
	private CarreraRepository carreraRepository;
	
	@Autowired
	@Qualifier("repositorioProfesor")
	private PersonaRepository profesorRepository;
	
	@BeforeEach
	void SetUp() 
	{
		carreraRepository.save(DatosDummy.carrera01());
		carreraRepository.save(DatosDummy.carrera02());
		carreraRepository.save(DatosDummy.carrera03());
		
	}
	
	@AfterEach
	void tearDown() {
		carreraRepository.deleteAll();
	}
	
	
	@Test
	@DisplayName("Test: Buscar Carreras por Nombre")
	void findCarrerasByNombreContains() {
		
		
		
		Iterable<Carrera> expected= carreraRepository.findCarrerasByNombreContains("Sistemas");
		
		
		assertThat(((List<Carrera>)expected).size()==2).isTrue();
	
	}
	
	@Test
	@DisplayName("Test: Buscar Carreras por Nombre IgnoreCase")
	void findCarrerasByNombreContainsIgnoreCase() 
	{
		
		
		
		List<Carrera> expected=(List<Carrera>) carreraRepository.findCarrerasByNombreContainsIgnoreCase("sistemas");
		
		
		assertThat(expected.size()==2).isTrue();
	}
	
	@Test
	@DisplayName("Test: Buscar Carreras por cantidad de Anios")
	void findCarrerasByCantidadAniosAfter()
	
	{
		
	
	
	List<Carrera> expected=(List<Carrera>) carreraRepository.findCarrerasByCantidadAniosAfter(4);
	
	
	assertThat(expected.size()==1).isTrue();
		
	}
	
	@Test
	@Disabled
	@DisplayName("Test: Buscar Carreras por Nombre y apellido de profesor")
	void findCarrerasByProfesorNombreYApellido()
	
	{
		Iterable<Persona> personaProfesor = profesorRepository.saveAll(
				Arrays.asList(
						DatosDummy.profesor01())
						); 
						
		Set<Carrera> carrera = (Set<Carrera>) carreraRepository.saveAll(Arrays.asList(DatosDummy.carrera01()));
		
		personaProfesor.forEach(profesor -> ((Profesor)profesor).setCarreras(carrera));
		profesorRepository.saveAll(personaProfesor);
		
				
				
				String profesorNombre ="Martin";
				String profesorApellido ="Lugone";
				Set<Carrera> expected = (Set<Carrera>) ((CarreraRepository)carreraRepository).findCarrerasByProfesorNombreYApellido(profesorNombre,profesorApellido);
				
				
				assertThat(expected.size()==1).isTrue();
	
	}

}
