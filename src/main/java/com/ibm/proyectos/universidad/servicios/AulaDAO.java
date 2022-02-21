package com.ibm.proyectos.universidad.servicios;
import com.ibm.proyectos.universidad.enumeradores.TipoPizarron;
import com.ibm.proyectos.universidad.modelo.entidades.Aula;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Pabellon;
import com.ibm.proyectos.universidad.servicios.GenericoDAO;

import java.util.Optional;

public interface AulaDAO extends GenericoDAO<Aula>
{
	
	public Iterable<Aula> findAulaByTipoPizarronContains(TipoPizarron tipoPizarron);
	
	public Iterable<Aula> findAulaByPabellonContains(Pabellon pabellon);
	
	public Iterable<Aula> findAulaBynumeroAulaContains(Integer numeroAula);

	public Aula actualizar(Long aulaId, Aula aula);
}
