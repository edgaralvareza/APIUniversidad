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
import com.ibm.proyectos.universidad.modelo.entidades.Pabellon;
import com.ibm.proyectos.universidad.repositorios.CarreraRepository;
import com.ibm.proyectos.universidad.repositorios.PabellonRepository;
import com.ibm.proyectos.universidad.servicios.CarreraDAOImpl;
import com.ibm.proyectos.universidad.servicios.PabellonDAO;
import com.ibm.proyectos.universidad.servicios.PabellonDAOImpl;

public class PabellonDAOImplTest 
{
	
	PabellonDAO pabellonDAO;
	
	PabellonRepository pabellonRepository;
	
	@BeforeEach
	void SetUp() {
		pabellonRepository = mock(PabellonRepository.class);
		pabellonDAO = new PabellonDAOImpl(pabellonRepository);
	}
	
	
	@Test
	@DisplayName("Test: Buscar Pabellon por Localidad")
	void findPabellonByLocalidadContains()
	{
		
		String localidad = "Tijuana";
		when (pabellonRepository.findPabellonByLocalidadContains(localidad)).thenReturn(Arrays.asList(DatosDummy.pabellon01()));
		
		List <Pabellon> expected = (List<Pabellon>) pabellonDAO.findPabellonByLocalidadContains(localidad);
		
		assertThat(expected.get(0)).isEqualTo(DatosDummy.pabellon01());
		
		 
		
		verify(pabellonRepository).findPabellonByLocalidadContains(localidad);
	
		
	}

	@Test
	@DisplayName("Test: Buscar pabellon por Nombre")
	void findPabellonByNombreContains() 
	{
		
		String nombrePabellon = "Polanco";
		when (pabellonRepository.findPabellonByNombreContains(nombrePabellon)).thenReturn(Arrays.asList(DatosDummy.pabellon01()));
		
		List <Pabellon> expected = (List<Pabellon>) pabellonDAO.findPabellonByNombreContains(nombrePabellon);
		
		assertThat(expected.get(0)).isEqualTo(DatosDummy.pabellon01());
		
		 
		
		verify(pabellonRepository).findPabellonByNombreContains(nombrePabellon);
	
		
	}

}
