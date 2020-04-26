package com.angular.sistema.ejb.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.List;


/**
 * The persistent class for the usuario_sistema database table.
 * 
 */
@Data
@Entity
@Table(name="usuario_sistema")
public class UsuarioSistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario_sistema")
	private int idUsuarioSistema;

	@Column(name="codigo_usuario")
	private String codigoUsuario;

	private String estado;

	private String password;

	//bi-directional many-to-one association to UsuarioSistema
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private UsuarioSistema usuarioSistema;


}