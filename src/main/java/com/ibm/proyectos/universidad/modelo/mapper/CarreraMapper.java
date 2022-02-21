package com.ibm.proyectos.universidad.modelo.mapper;

import com.ibm.proyectos.universidad.modelo.dto.CarreraDTO;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;

public class CarreraMapper
{
	public static CarreraDTO mapCarrera(Carrera carrera)
	{
		CarreraDTO carreraDTO = new CarreraDTO();
		carreraDTO.setCarreraId(carrera.getId());
		carreraDTO.setNombre(carrera.getNombre());
		carreraDTO.setCantidadAnios(carrera.getCantidadAnios());
		carreraDTO.setCantidadMaterias(carrera.getCantidadMaterias());
		carreraDTO.setFechaCreacion(carrera.getFechaCreacion());
		return carreraDTO;
	}

}
