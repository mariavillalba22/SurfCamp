package database.JPA;

import javax.persistence.EntityManager;

import database.pojo.*;

public class JPADelete {
	

	EntityManager em;
	
	public JPADelete(EntityManager em) {
		this.em=em;
	}
	
	public void deleteCamper(Camper camper) {
		em.getTransaction().begin();
		em.remove(camper);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteAccomodation( Accomodation accomodation) {
		em.getTransaction().begin();
		em.remove(accomodation);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteActivity(Activity activity) {
		em.getTransaction().begin();
		em.remove(activity);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteInstructor( Instructor instructor) {
		em.getTransaction().begin();
		em.remove(instructor);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteMaterial( Material material) {
		em.getTransaction().begin();
		em.remove(material);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteTransport(Transport transport) {
		em.getTransaction().begin();
		em.remove(transport);
		em.getTransaction().commit();
		em.close();
	}

}