package com.ibm.proyectos.universidad.excepciones;

public class NotFoundException extends RuntimeException 
{
	
	public NotFoundException(String mensaje)
	{
		super(mensaje);
	}
	
	private static final long serialVersionUID = -5954272584000829880L;
}
