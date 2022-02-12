package com.ibm.proyectos.universidad.servicios;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.proyectos.universidad.enumeradores.TipoPizarron;
import com.ibm.proyectos.universidad.modelo.entidades.Aula;
import com.ibm.proyectos.universidad.modelo.entidades.Pabellon;
import com.ibm.proyectos.universidad.repositorios.AulaRepository;




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
 


}
