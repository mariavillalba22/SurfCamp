package database.JPA;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import database.pojo.Camper;

public class JPACreate {
	EntityManager em;
	public JPACreate(EntityManager em) {
		this.em=em;
	}
	public void createCamper(EntityManager em, Camper camper) {
		
		em.getTransaction().begin();
		em.persist(camper);
		em.getTransaction().commit();
		em.close();
		
	
	}
}
