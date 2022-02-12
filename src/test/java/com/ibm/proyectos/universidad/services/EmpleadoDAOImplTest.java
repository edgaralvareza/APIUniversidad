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
import com.ibm.proyectos.universidad.enumeradores.TipoEmpleado;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Empleado;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.repositorios.CarreraRepository;
import com.ibm.proyectos.universidad.repositorios.EmpleadoRepository;
import com.ibm.proyectos.universidad.servicios.CarreraDAOImpl;
import com.ibm.proyectos.universidad.servicios.EmpleadoDAO;
import com.ibm.proyectos.universidad.servicios.EmpleadoDAOImpl;

public class EmpleadoDAOImplTest 
{

	EmpleadoDAO empleadoDAO;
	EmpleadoRepository empleadoRepository;
	
	@BeforeEach
	void SetUp() 
	{
		empleadoRepository = mock(EmpleadoRepository.class);
		empleadoDAO = new EmpleadoDAOImpl(empleadoRepository);
		
	}
	
	

	    @Test
	    @DisplayName("Test: Buscar Empleado por TIpo de Empleado")
		void findEmpleadoByTipoEmpleado() {
			
			TipoEmpleado tipoEmpleado=TipoEmpleado.ADMINISTRATIVO;
			when (empleadoRepository.findEmpleadoByTipoEmpleado(tipoEmpleado)).thenReturn(Arrays.asList(DatosDummy.empleado01(),DatosDummy.empleado02()));
			
			List <Persona> expected = (List<Persona>) empleadoDAO.findEmpleadoByTipoEmpleado(tipoEmpleado);
			
			assertThat(expected.get(0)).isEqualTo(DatosDummy.empleado01());
			
			 
			
			verify(empleadoRepository).findEmpleadoByTipoEmpleado(tipoEmpleado);
		}

}
