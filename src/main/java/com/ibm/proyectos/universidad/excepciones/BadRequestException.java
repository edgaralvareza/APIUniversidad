package com.ibm.proyectos.universidad.excepciones;

public class BadRequestException extends RuntimeException
{


	public BadRequestException(String mensaje)
	{
		super(mensaje);
	}
	
	private static final long serialVersionUID = 7177476082375892918L;
}