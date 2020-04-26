package com.angular.sistema.ejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.angular.sistema.ejb.model.TipoIdentificacion;
import com.angular.sistema.ejb.model.Usuario;

@Stateless
public class TipoIdentificacionDAO {

	@PersistenceContext(unitName = "AngularSistemaPU")
	public EntityManager em;
	
	public TipoIdentificacion persist(TipoIdentificacion t){
		em.persist(t);
		return t;
	}

	public TipoIdentificacion update(TipoIdentificacion t ){
		em.merge(t);
		return t;
	}
	
	public void delete(Integer id){
		em.remove(em.find(Usuario.class,id));
	}

	public TipoIdentificacion find(int id) {
		return em.find(TipoIdentificacion.class,id);
	}
}
