package com.angular.sistema.ejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.angular.sistema.ejb.model.UsuarioSistema;

@Stateless
public class UsuarioSistemaDAO {
	
	@PersistenceContext(unitName = "AngularSistemaPU")
	public EntityManager em;
	
	public UsuarioSistema persist(UsuarioSistema u){
		em.persist(u);
		return u;
	}

	public void update(UsuarioSistema u){
		em.merge(u);
	}
	
	public void delete(UsuarioSistema user){
		em.remove(user);
	}

	public UsuarioSistema find(int id) {
		return em.find(UsuarioSistema.class,id);
	}
	
	public boolean autenticacion(String strCodUsuario, String strPassword) {
	
			String query="SELECT COUNT(1)\n"
						+"FROM  UsuarioSistema U\n"
						+ "WHERE U.codigoUsuario=:CodUsuario\n"
						+ "AND U.password=:Password";
			
			return em.createQuery(query,Long.class)
					.setParameter("CodUsuario",strCodUsuario)
					.setParameter("Password",strPassword)
					.getSingleResult().longValue() >0 ? true : false;
		
	}

}
