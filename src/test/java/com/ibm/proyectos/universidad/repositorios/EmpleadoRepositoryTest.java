package com.ibm.proyectos.universidad.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.Query;

import com.ibm.proyectos.universidad.datos.DatosDummy;
import com.ibm.proyectos.universidad.enumeradores.TipoEmpleado;
import com.ibm.proyectos.universidad.modelo.entidades.Aula;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Empleado;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;

@DataJpaTest
public class EmpleadoRepositoryTest 
{
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@BeforeEach
	void SetUp() 
	{
		
	
		
	}
	
	@AfterEach
	void tearDown() {
		empleadoRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Test: Buscar Empleado por Tipo de empleado")
	void findEmpleadoByTipoEmpleado() 
	{
		
		empleadoRepository.save(DatosDummy.empleado01());
		empleadoRepository.save(DatosDummy.empleado02());
		Iterable<Persona> expected= empleadoRepository.findEmpleadoByTipoEmpleado(TipoEmpleado.ADMINISTRATIVO);
		
		assertThat(((List<Persona>)expected).size()==1).isTrue();
		
		
	}
	

}
