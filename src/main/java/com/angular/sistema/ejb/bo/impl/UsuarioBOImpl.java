package com.angular.sistema.ejb.bo.impl;


import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.angular.sistema.ejb.bo.IUsuarioBO;
import com.angular.sistema.ejb.dao.TipoIdentificacionDAO;
import com.angular.sistema.ejb.dao.UsuarioDAO;
import com.angular.sistema.ejb.dto.DatosUsuarioDTO;
import com.angular.sistema.ejb.exception.BOException;
import com.angular.sistema.ejb.model.TipoIdentificacion;
import com.angular.sistema.ejb.model.Usuario;

@Stateless
public class UsuarioBOImpl implements IUsuarioBO{

	@EJB
	UsuarioDAO objUsuarioDAO;
	
	@EJB
	TipoIdentificacionDAO objTipoIdentificacionDAO;
	
	public Usuario persist(DatosUsuarioDTO du) throws BOException {
		
		TipoIdentificacion objTipoIdentificacion= objTipoIdentificacionDAO.find(du.tipoIdentificacion);
		
		if(objTipoIdentificacion==null) {
			throw new BOException("No existe el tipo de identificacion ingresado");
		}
		
		Usuario objUsuario=new Usuario();
		objUsuario.setIdUsuario(du.idUsuario);
		objUsuario.setTipoIdentificacionBean(objTipoIdentificacion);
		objUsuario.setNroIdentificacion(du.nroIdentificacion);
		objUsuario.setPrimerNombre(du.primerNombre);
		objUsuario.setSegundoNombre(du.segundoNombre);
		objUsuario.setPrimerApellido(du.primerApellido);
		objUsuario.setSegundoApellido(du.segundoApellido);
		objUsuario.setFechaNacimiento(du.fechaNacimiento);
		objUsuario.setEmail(du.email);
		return objUsuarioDAO.persist(objUsuario);	
	}

	public void update(Usuario u) throws BOException {
		objUsuarioDAO.update(u);
		
	}

	public Usuario find(int u) throws BOException {
		return objUsuarioDAO.find(u);
	}

	@Override
	public void delete(int u) throws BOException {
		Usuario user=objUsuarioDAO.find(u);
		objUsuarioDAO.delete(user);
	}
}
