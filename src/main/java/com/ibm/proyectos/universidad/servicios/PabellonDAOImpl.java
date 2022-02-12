package com.ibm.proyectos.universidad.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.proyectos.universidad.modelo.entidades.Direccion;
import com.ibm.proyectos.universidad.modelo.entidades.Pabellon;
import com.ibm.proyectos.universidad.repositorios.PabellonRepository;

@Service
public class PabellonDAOImpl extends GenericoDAOImpl <Pabellon,PabellonRepository> implements PabellonDAO
{

	@Autowired
	public PabellonDAOImpl(PabellonRepository repository) {
		super(repository);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Pabellon> findPabellonByLocalidadContains(String localidad)
	{
	
		return repository.findPabellonByLocalidadContains(localidad);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Pabellon> findPabellonByNombreContains(String nombre) 
	{
	
		return repository.findPabellonByNombreContains(nombre);
	}
	
	

}
