package com.ibm.proyectos.universidad.servicios;

import com.ibm.proyectos.universidad.enumeradores.TipoEmpleado;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.repositorios.PersonaRepository;

public interface EmpleadoDAO extends PersonaDAO

{
	public Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);
	public Persona actualizar(Long empleadoId, Persona empleado);
}
