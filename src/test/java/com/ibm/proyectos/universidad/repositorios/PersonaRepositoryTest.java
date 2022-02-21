package com.ibm.proyectos.universidad.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.Query;

import com.ibm.proyectos.universidad.datos.DatosDummy;
import com.ibm.proyectos.universidad.modelo.entidades.Empleado;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.modelo.entidades.Profesor;


@DataJpaTest
public class PersonaRepositoryTest 
{
	
	@Autowired
	@Qualifier("repositorioAlumno")
	private PersonaRepository alumnoRepository;
	
	@Autowired
	@Qualifier("repositorioEmpleado")
	private PersonaRepository empleadoRepository;
	
	@Autowired
	@Qualifier("repositorioProfesor")
	private PersonaRepository profesorRepository;
	
	@BeforeEach
	void SetUp() 
	{
	
		
	}
	
	@AfterEach
	void tearDown() {
		alumnoRepository.deleteAll();
		empleadoRepository.deleteAll();
		profesorRepository.deleteAll();
	}
	
	
	@Test
	@DisplayName("Test: Buscar persona por Nombre y Apellido")
	void buscarPorNombreYApellido() {
		
		Persona personaEmpleado = empleadoRepository.save(DatosDummy.empleado01());
		
		
		Optional <Persona> expected = empleadoRepository.buscarPorNombreYApellido(DatosDummy.empleado01().getNombre(), DatosDummy.empleado01().getApellido());
		
		assertThat(expected.get()).isInstanceOf(Empleado.class);
		assertThat(expected.get()).isEqualTo(personaEmpleado);
	}
	
	@Test
	@DisplayName("Test: Buscar persona por DNI")
	void buscarPorDni() 
	
	{
		Persona personaProfesor = profesorRepository.save(DatosDummy.profesor01());
		
		
		Optional<Persona> expected = profesorRepository.buscarPorDni(DatosDummy.profesor01().getDni());
		
		
		assertThat(expected.get()).isInstanceOf(Profesor.class);
		assertThat(expected.get()).isEqualTo(personaProfesor);
		assertThat(expected.get().getDni()).isEqualTo(personaProfesor.getDni());
		
		
		
		
	}
	
	@Test
	@DisplayName("Test: Buscar persona por Apellido")
	void buscarPersonaPorApellido() 
	{
		
		List<Persona> listaPersonas = new ArrayList<Persona>();
		listaPersonas.add(DatosDummy.alumno01());
		listaPersonas.add(DatosDummy.alumno02());
		listaPersonas.add(DatosDummy.alumno03());
		
		Iterable<Persona> personas = alumnoRepository.saveAll(listaPersonas);
		
		/*Iterable<Persona> personas = alumnoRepository.saveAll(
		Arrays.asList(
				DatosDummy.alumno01(),
				DatosDummy.alumno02(),
				DatosDummy.alumno03())
				); */

		
		String apellido = "Benitez";
		Optional<Persona> expected =  alumnoRepository.buscarPersonaPorApellido(apellido);
		
		assertThat(expected.get().getApellido().equals(apellido));
	
		
	}

}
