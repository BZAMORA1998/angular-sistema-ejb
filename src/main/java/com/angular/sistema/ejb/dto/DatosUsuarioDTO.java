package com.angular.sistema.ejb.dto;

import java.io.Serializable;

import lombok.*;

@Data
@Getter
@Setter
public class DatosUsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public int idUsuario;
	public int tipoIdentificacion;
	public String nroIdentificacion;
	public String primerApellido;
	public String primerNombre;
	public String segundoApellido;
	public String segundoNombre;
	public String fechaNacimiento;
	public String email;

}
