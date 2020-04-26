package com.angular.sistema.ejb.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the tipo_identificacion database table.
 * 
 */
@Data
@Entity
@Table(name="tipo_identificacion")
public class TipoIdentificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_identificacion")
	private int idTipoIdentificacion;

	@Column(name="tipo_identificacion")
	private String tipoIdentificacion;

}