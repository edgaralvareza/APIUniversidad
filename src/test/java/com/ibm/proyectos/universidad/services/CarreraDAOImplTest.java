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

import com.ibm.proyectos.universidad.datos.DatosDummy;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.repositorios.CarreraRepository;
import com.ibm.proyectos.universidad.servicios.CarreraDAO;
import com.ibm.proyectos.universidad.servicios.CarreraDAOImpl;

public class CarreraDAOImplTest
{

	CarreraDAO carreraDAO;
	CarreraRepository carreraRepository;
	
	@BeforeEach
	void SetUp() {
		carreraRepository = mock(CarreraRepository.class);
		carreraDAO = new CarreraDAOImpl(carreraRepository);
	}
	
	
	@Test
	@DisplayName("Test: Buscar Carrera por Nombre")
	void findCarrerasByNombreContains() {
		
		String nombre = "Ingenieria";
		when (carreraRepository.findCarrerasByNombreContains(nombre)).thenReturn(Arrays.asList(DatosDummy.carrera01(),DatosDummy.carrera02()));
		
		List <Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContains(nombre);
		
		assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01());
		assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera02());
		 
		
		verify(carreraRepository).findCarrerasByNombreContains(nombre);
	}
	
	@Test
	@DisplayName("Test: Buscar Carrera por Nombre No case sensitive")
	void findCarrerasByNombreContainsIgnoreCase() 
	{
		String nombre = "Ingenieria";
		when (carreraRepository.findCarrerasByNombreContainsIgnoreCase(nombre)).thenReturn(Arrays.asList(DatosDummy.carrera01(),DatosDummy.carrera02()));
		
		List <Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase(nombre);
		
		assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01());
		assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera02());
		 
		
		verify(carreraRepository).findCarrerasByNombreContainsIgnoreCase(nombre);
	}
	@Test
	@DisplayName("Test: Buscar Carreras despues de N anios")
	void findCarrerasByCantidadAniosAfter()
	{
		Integer cantidad = 4;
		when(carreraRepository.findCarrerasByCantidadAniosAfter(cantidad)).thenReturn(Arrays.asList(DatosDummy.carrera01(),DatosDummy.carrera03()));
		
		
		List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(cantidad);
		
		
		assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01());
		assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03());
		
		
		verify(carreraRepository).findCarrerasByCantidadAniosAfter(cantidad);
		
	}
	
	@Test
	void findCarrerasByProfesorNombreYApellido(){
		
	}
}
