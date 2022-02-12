package com.ibm.proyectos.universidad.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.proyectos.universidad.enumeradores.TipoPizarron;
import com.ibm.proyectos.universidad.modelo.entidades.Aula;
import com.ibm.proyectos.universidad.modelo.entidades.Pabellon;



@Repository
public interface AulaRepository extends CrudRepository<Aula, Long>
{
			public Iterable<Aula> findAulaByTipoPizarronContains(TipoPizarron tipoPizarron);
			public Iterable<Aula> findAulaByPabellonContains(Pabellon pabellon);
			public Iterable<Aula> findAulaBynumeroAulaContains(Integer numeroAula);
					
}
