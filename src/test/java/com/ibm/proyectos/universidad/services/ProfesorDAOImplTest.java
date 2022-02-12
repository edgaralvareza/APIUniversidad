package com.ibm.proyectos.universidad.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.proyectos.universidad.datos.DatosDummy;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.repositorios.CarreraRepository;
import com.ibm.proyectos.universidad.repositorios.ProfesorRepository;
import com.ibm.proyectos.universidad.servicios.CarreraDAOImpl;
import com.ibm.proyectos.universidad.servicios.ProfesorDAO;
import com.ibm.proyectos.universidad.servicios.ProfesorDAOImpl;

public class ProfesorDAOImplTest 
{
	ProfesorDAO profesorDAO;
	
	ProfesorRepository profesorRepository;
	
	
	@BeforeEach
	void SetUp() {
		profesorRepository = mock(ProfesorRepository.class);
		profesorDAO = new ProfesorDAOImpl(profesorRepository);
	}
	
	
	@Test
	@DisplayName("Test: Buscar Profesor por Nombre de Carrera")
	void findProfesorByNombreCarrera() {
		
	
		
	}

}
