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
			em = Persistence.createEntityManagerFactory("summercamp").createEntityManager();
			em.getTransaction().begin();
			em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
			em.getTransaction().commit();
			
			
		}
	public EntityManager getEntityManager() {
		return em;
	}
	public void closeconnection() {
		em.close();
	}
	}


