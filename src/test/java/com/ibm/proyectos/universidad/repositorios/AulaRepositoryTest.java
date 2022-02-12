package com.ibm.proyectos.universidad.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.proyectos.universidad.datos.DatosDummy;
import com.ibm.proyectos.universidad.enumeradores.TipoPizarron;
import com.ibm.proyectos.universidad.modelo.entidades.Alumno;
import com.ibm.proyectos.universidad.modelo.entidades.Aula;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Empleado;
import com.ibm.proyectos.universidad.modelo.entidades.Pabellon;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;

@DataJpaTest
public class AulaRepositoryTest
{
	
	@Autowired
	private AulaRepository aulaRepository;
	
	@Autowired
	private PabellonRepository pabellonRepository;
	
	

	@BeforeEach
	void SetUp() 
	{
	
		aulaRepository.save(DatosDummy.aula01());
		
	}
	
	@AfterEach
	void tearDown() {
	
		aulaRepository.deleteAll();
	}
	
	
	
	@Test
	@Disabled
	@DisplayName("Test: Buscar Aula por Tipo Pizarron")
	void findAulaByTipoPizarronContains()
	{
		Aula aula=aulaRepository.save(DatosDummy.aula01());
		
		TipoPizarron tipo = TipoPizarron.PIZARRON_TIZA;
	Iterable<Aula> expected= aulaRepository.findAulaByTipoPizarronContains(tipo);
		
		
	assertThat(((List<Aula>)expected).size()==1).isTrue();
		
	}
	
	@Test
	@Disabled
	@DisplayName("Test: Buscar Aula por Pabellon")
	void findAulaByPabellonContains(){
		
		Iterable<Aula> aulas = aulaRepository.saveAll(
				Arrays.asList(
						DatosDummy.aula01())
						
						); 
				Pabellon pabellon = pabellonRepository.save(DatosDummy.pabellon01());
				
				aulas.forEach(aula -> ((Aula)aula).setPabellon(pabellon));
				aulaRepository.saveAll(aulas);
				
				
				
				List<Aula> expected= (List<Aula>) ((AulaRepository)aulaRepository).findAulaByPabellonContains(pabellon);
				
				
				assertThat(expected.get(0)).isInstanceOf(Aula.class);
				//assertThat(expected.get(0)).isEqualTo(aulas);
		
		
	}
	
	@Test
	@Disabled
	@DisplayName("Test: Buscar Aula por Numero de Aula")
	void findAulaBynumeroAulaContains() {
		


		Iterable<Aula> aula = aulaRepository.saveAll(
				Arrays.asList(
						DatosDummy.aula01())
						); 
		
		
		Iterable <Aula> expected = aulaRepository.findAulaBynumeroAulaContains(DatosDummy.aula01().getNumeroAula());
		
		assertThat(((List <Aula>) expected).get(0)).isInstanceOf(Aula.class);
		
		
	}
}
