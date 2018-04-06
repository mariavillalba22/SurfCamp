package database.JPA;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPACreate {
	EntityManager em;
	public void createJPA () {
		em = Persistence.createEntityManagerFactory("surf camp").createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
}
