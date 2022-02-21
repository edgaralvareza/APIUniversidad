package com.ibm.proyectos.universidad.modelo.entidades;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.ForeignKey;


import com.ibm.proyectos.universidad.enumeradores.TipoEmpleado;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "empleados", schema = "universidad")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Empleado extends Persona 
{
	@Column(name = "sueldo")
	private BigDecimal sueldo;
	
	@Column(name = "tipo_empleado")
	@Enumerated(EnumType.STRING)
	private TipoEmpleado tipoEmpleado;
	
	@OneToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "pabellon_id", foreignKey = @ForeignKey(name = "FK_PABELLON_ID"))
	private Pabellon pabellon;
	
	public Empleado(Long id, String nombre, String apellido, String dni, String usuarioCreacion, Direccion direccion, BigDecimal sueldo, TipoEmpleado tipoEmpleado) 
	{
		super(id, nombre, apellido, dni, usuarioCreacion, direccion);
		this.sueldo = sueldo;
		this.tipoEmpleado = tipoEmpleado;
	}
	
	@Override
	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Empleado [sueldo=");
		builder.append(sueldo);
		builder.append(", tipoEmpleado=");
		builder.append(tipoEmpleado);
		builder.append("]");
		return builder.toString();
	}


	private static final long serialVersionUID = -5852043009745034886L;
}
