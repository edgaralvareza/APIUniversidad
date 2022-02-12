package com.ibm.proyectos.universidad.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.Query;

import com.ibm.proyectos.universidad.datos.DatosDummy;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Direccion;
import com.ibm.proyectos.universidad.modelo.entidades.Pabellon;

@DataJpaTest
public class PabellonRepositoryTest 
{
	
	@Autowired
	private PabellonRepository pabellonRepository;

	@BeforeEach
	void SetUp() 
	{
	
		pabellonRepository.save(DatosDummy.pabellon01());
		
	}
	
	@AfterEach
	void tearDown() {
	
		pabellonRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Test: Buscar Pabellon por Localidad")
	void findPabellonByLocalidadContains(){
		
		
        Iterable<Pabellon> expected= pabellonRepository.findPabellonByLocalidadContains("Tijuana");
		
		
		assertThat(((List<Pabellon>)expected).size()==1).isTrue();
		
	}
	
	@Test
	@DisplayName("Test: Buscar Pabellon por Nombre")
	void findPabellonByNombreContains(){
		

        Iterable<Pabellon> expected= pabellonRepository.findPabellonByNombreContains("Polanco");
		
		
		assertThat(((List<Pabellon>)expected).size()==1).isTrue();
		
		
	}
}
