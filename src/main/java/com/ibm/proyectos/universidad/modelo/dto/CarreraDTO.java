package com.ibm.proyectos.universidad.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarreraDTO implements Serializable 
{
	
	private Long carreraId;
	private String nombre;
	private Integer cantidadMaterias;
	private Integer cantidadAnios;
	private Date fechaCreacion;

	
	
	
	public Long getCarreraId() {
		return carreraId;
	}




	public void setCarreraId(Long carreraId) {
		this.carreraId = carreraId;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public Integer getCantidadMaterias() {
		return cantidadMaterias;
	}




	public void setCantidadMaterias(Integer cantidadMaterias) {
		this.cantidadMaterias = cantidadMaterias;
	}




	public Integer getCantidadAnios() {
		return cantidadAnios;
	}




	public void setCantidadAnios(Integer cantidadAnios) {
		this.cantidadAnios = cantidadAnios;
	}




	public Date getFechaCreacion() {
		return fechaCreacion;
	}




	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}




	private static final long serialVersionUID = 3270807219679867007L;
}
