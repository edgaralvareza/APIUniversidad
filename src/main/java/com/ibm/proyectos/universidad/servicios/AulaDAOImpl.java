package com.ibm.proyectos.universidad.servicios;

import com.ibm.proyectos.universidad.excepciones.NotFoundException;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.proyectos.universidad.enumeradores.TipoPizarron;
import com.ibm.proyectos.universidad.modelo.entidades.Aula;
import com.ibm.proyectos.universidad.modelo.entidades.Pabellon;
import com.ibm.proyectos.universidad.repositorios.AulaRepository;

import java.util.Optional;


@Service
public class AulaDAOImpl extends GenericoDAOImpl<Aula, AulaRepository> implements AulaDAO

{
    @Autowired
	public AulaDAOImpl(AulaRepository repository) {
		super(repository);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Aula> findAulaByTipoPizarronContains(TipoPizarron tipoPizarron) {

		return repository.findAulaByTipoPizarronContains(tipoPizarron);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Aula> findAulaByPabellonContains(Pabellon pabellon) {
		
		return repository.findAulaByPabellonContains(pabellon);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Aula> findAulaBynumeroAulaContains(Integer numeroAula) {
		
		return repository.findAulaBynumeroAulaContains(numeroAula);
	}

	@Override
	public Aula actualizar(Long aulaId, Aula aula) {
		Optional<Aula> oAula = repository.findById(aulaId);

		if(!oAula.isPresent())
			throw new NotFoundException(String.format("El aula con ID %d no existe", aulaId));

		Aula aulaActualizada = null;
		oAula.get().setCantidadPupitres(aula.getCantidadPupitres());
		oAula.get().setTipoPizarron(aula.getTipoPizarron());
		aulaActualizada = repository.save(oAula.get());
		return aulaActualizada;
	}


}
