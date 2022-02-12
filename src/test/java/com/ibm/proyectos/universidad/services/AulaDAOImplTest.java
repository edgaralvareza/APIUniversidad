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
import com.ibm.proyectos.universidad.enumeradores.TipoPizarron;
import com.ibm.proyectos.universidad.modelo.entidades.Aula;

import com.ibm.proyectos.universidad.modelo.entidades.Pabellon;
import com.ibm.proyectos.universidad.repositorios.AulaRepository;

import com.ibm.proyectos.universidad.servicios.AulaDAO;
import com.ibm.proyectos.universidad.servicios.AulaDAOImpl;

public class AulaDAOImplTest
{

	AulaDAO aulaDAO;
	AulaRepository aulaRepository;
	
	@BeforeEach
	void SetUp() {
		aulaRepository = mock(AulaRepository.class);
		aulaDAO = new AulaDAOImpl(aulaRepository);
	}
	
	@Test
	@DisplayName("Test: Buscar Aula por tipo Pizarron")
	void findAulaByTipoPizarronContains() {
		
		TipoPizarron tipo = TipoPizarron.PIZARRON_TIZA;
		when (aulaRepository.findAulaByTipoPizarronContains(tipo)).thenReturn(Arrays.asList(DatosDummy.aula01()));
		
		List <Aula> expected = (List<Aula>) aulaDAO.findAulaByTipoPizarronContains(tipo);
		
		assertThat(expected.get(0)).isEqualTo(DatosDummy.aula01());
		
		 
		
		verify(aulaRepository).findAulaByTipoPizarronContains(tipo);
	}
		
	


	@Test
	@DisplayName("Test: Buscar Aula por Pabellon")
	void findAulaByPabellonContains() {
		
		
	}

	@Test
	@DisplayName("Test: Buscar Aula por Numero de Aula")
	void findAulaBynumeroAulaContains() {
		
		Integer numeroAula=5;
		when (aulaRepository.findAulaBynumeroAulaContains(numeroAula)).thenReturn(Arrays.asList(DatosDummy.aula01()));
		
		List <Aula> expected = (List<Aula>) aulaDAO.findAulaBynumeroAulaContains(numeroAula);
		
		assertThat(expected.get(0)).isEqualTo(DatosDummy.aula01());
		
		 
		
		verify(aulaRepository).findAulaBynumeroAulaContains(numeroAula);
	
	}
	
}
