package com.angular.sistema.ejb.bo;


import javax.ejb.Local;
import javax.validation.constraints.NotNull;

import com.angular.sistema.ejb.dto.DatosUsuarioDTO;
import com.angular.sistema.ejb.exception.BOException;
import com.angular.sistema.ejb.model.Usuario;

@Local
public interface IUsuarioBO {

	public Usuario persist(DatosUsuarioDTO du) throws BOException;

	public void update(Usuario u) throws BOException;
	
	public void delete(@NotNull int id) throws BOException;
	
	public Usuario find(@NotNull int id)  throws BOException;

}
