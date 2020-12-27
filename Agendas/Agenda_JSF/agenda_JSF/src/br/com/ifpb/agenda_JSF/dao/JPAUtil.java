package br.com.ifpb.agenda_JSF.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("lista_telefonica");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void close(EntityManager em) {
		em.close();
	}
}
