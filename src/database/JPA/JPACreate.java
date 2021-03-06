package database.JPA;

import javax.persistence.*;
import database.pojo.*;

public class JPACreate {
	
	EntityManager em;
	
	public JPACreate(EntityManager em) {
		this.em=em;
	}
	public void createCamper(Camper camper) {
		em.getTransaction().begin();
		em.persist(camper);
		em.getTransaction().commit();
		
	}
	
    public void createInstructor(Instructor instructor) {
		em.getTransaction().begin();
		em.persist(instructor);
		em.getTransaction().commit();
		
	}
    
    public void createActivity(Activity activity) {
	em.getTransaction().begin();
	em.persist(activity);
	em.getTransaction().commit();
	
    }
    
    public void createAccomodation(Accomodation accomodation) {
	em.getTransaction().begin();
	em.persist(accomodation);
	em.getTransaction().commit();
	
    }
    
    public void createMaterial(Material material) {
	em.getTransaction().begin();
	em.persist(material);
	em.getTransaction().commit();
    }

    public void createTransport(Transport transport) {
	em.getTransaction().begin();
	em.persist(transport);
	em.getTransaction().commit();
    }

}
