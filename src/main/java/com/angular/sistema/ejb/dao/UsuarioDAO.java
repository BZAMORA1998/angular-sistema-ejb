package com.angular.sistema.ejb.dao;

import javax.ejb.Stateless;
import javax.persistence.*;

import com.angular.sistema.ejb.model.Usuario;


@Stateless
public class UsuarioDAO{

	@PersistenceContext(unitName = "AngularSistemaPU")
	public EntityManager em;
	
	public Usuario persist(Usuario u){
		em.persist(u);
		return u;
	}

	public void update(Usuario u){
		em.merge(u);
	}
	
	public void delete(Usuario user){
		em.remove(user);
	}

	public Usuario find(int id) {
		return em.find(Usuario.class,id);
	}

}