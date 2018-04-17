package database.JPA;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import database.menu.ConnectInterface;

public class JPAconnect implements ConnectInterface{
	EntityManager em;
	public JPAconnect() throws Exception {
		this.connectiondb();
	}
	public void connectiondb() throws Exception {
			em = Persistence.createEntityManagerFactory("surfcamp").createEntityManager();
			em.getTransaction().begin();
			em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
			em.getTransaction().commit();
			em.close();
			
		}
	public EntityManager getEntityManager() {
		return em;
	}
	}


