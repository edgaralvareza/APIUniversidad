package com.ibm.proyectos.universidad.datos;

import java.math.BigDecimal;

import com.ibm.proyectos.universidad.enumeradores.TipoEmpleado;
import com.ibm.proyectos.universidad.enumeradores.TipoPizarron;
import com.ibm.proyectos.universidad.modelo.entidades.Alumno;
import com.ibm.proyectos.universidad.modelo.entidades.Aula;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Direccion;
import com.ibm.proyectos.universidad.modelo.entidades.Empleado;
import com.ibm.proyectos.universidad.modelo.entidades.Pabellon;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.modelo.entidades.Profesor;

public class DatosDummy {

	
	
	
	public static Carrera carrera01() {
		
		return new Carrera(null, "Ingenieria en Sistemas", 50, 5, "EAlvarez");
	}
	
    public static Carrera carrera02() {
		
		return new Carrera(null, "Licenciatura en Sistemas", 30, 3, "EAlvarez");
	}
	


    public static Carrera carrera03() {
	
	    return new Carrera(null, "Ingenieria Industrial", 20, 2, "EAlvarez");
    }
    
  
    public static Persona empleado01() {
    	
    	return new Empleado(null, "Pedro", "Lopez", "25178932", "EAlv", new Direccion(), new BigDecimal("45822.20"), TipoEmpleado.ADMINISTRATIVO);
    }
    
    public static Persona empleado02() {
    	
    	return new Empleado(null, "Jesus", "Lopez", "25178333", "EAlv", new Direccion(), new BigDecimal("55822.20"), TipoEmpleado.MANTENIMIENTO);
    }
    
    public static Persona profesor01() {
    	
    	return new Profesor(null, "Martin", "Lugone", "25178954", "EAlv", new Direccion(), new BigDecimal("55822.20"));
    	
    }
    
    public static Persona alumno01() {
        	
        	return new Alumno(null, "Martin", "Lugone", "25178989", "EAlv", new Direccion());
   
    	}
    
    public static Persona alumno02() {
    	
    	return new Alumno(null, "Raul", "Benitez", "25178981", "EAlv", new Direccion());

	}
    
    public static Persona alumno03() {
    	
    	return new Alumno(null, "Jesus", "Benitez", "25178983", "EAlv", new Direccion());

	}
    
    
    public static Aula aula01() {
    	
    	return new Aula(null, 5, "200 m", 20, TipoPizarron.PIZARRON_TIZA, "EAlv");
    }
 
    public static Pabellon pabellon01() {
    	
    	
    	return new Pabellon(null, null, "Polanco", new Direccion(null, null, null, null, null, "Tijuana"), "EAlv");
    }
 
    
    
    
}
