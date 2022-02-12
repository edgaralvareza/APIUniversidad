package com.ibm.proyectos.universidad.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.proyectos.universidad.datos.DatosDummy;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.repositorios.CarreraRepository;
import com.ibm.proyectos.universidad.repositorios.PersonaRepository;
import com.ibm.proyectos.universidad.servicios.CarreraDAOImpl;
import com.ibm.proyectos.universidad.servicios.PersonaDAO;
import com.ibm.proyectos.universidad.servicios.PersonaDAOImpl;

public class PersonaDAOImplTest
{
	PersonaDAO personaDAO;
	
	PersonaRepository personaRepository;
	
	@BeforeEach
	void SetUp() {
		personaRepository = mock(PersonaRepository.class);
		personaDAO = new PersonaDAOImpl(personaRepository);
	}

	
	@Test
	@Disabled
	@DisplayName("Test: Buscar persona por Nombre y Apellido")
	void buscarPorNombreYApellido() 
	{
		
		String nombre = "Pedro";
		String apellido = "Lopez";

	
		//when (personaRepository.buscarPorNombreYApellido(nombre,apellido)).thenReturn(DatosDummy.empleado01());
		Optional <Persona> expected =  personaDAO.buscarPorNombreYApellido(nombre,apellido);
		
		assertThat(expected.get()).isEqualTo(DatosDummy.carrera01());
		assertThat(expected.get()).isEqualTo(DatosDummy.carrera02());
		 
		
		verify(personaRepository).buscarPorNombreYApellido(nombre,apellido);

	}

	@Test
	@DisplayName("Test: Buscar por DNI")
	void buscarPorDni() 
	{
		
	}

	@Test
	@DisplayName("Test: Buscar Persona por Apellido")
	void buscarPersonaPorApellido() 
	{
	
	}
}
