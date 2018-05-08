package database.JPA;


	import javax.persistence.EntityManager;

	import database.pojo.*;

	public class JPAUpdate {


		EntityManager em;
		
		public JPAUpdate(EntityManager em) {
			this.em=em;
		}
		
		public void UpdateCampName(Camper camp,String name) {
			em.getTransaction().begin();
			camp.setName(name);
			em.getTransaction().commit();
			em.close();
		}
		
		public void UpdateAccomAvailability(Accomodation acom, Integer a) {
			em.getTransaction().begin();
			acom.setAvailability(a);
			em.getTransaction().commit();
			em.close();
		}
		
		public void UpdateCampNIF(Camper camp,String NIF) {
			em.getTransaction().begin();
			camp.setNIF(NIF);
			em.getTransaction().commit();
			em.close();
		}
		
		public void UpdateCampPhoneNumber(Camper camp,int phoneNumber) {
			em.getTransaction().begin();
			camp.setPhonenumber(phoneNumber);
			em.getTransaction().commit();
			em.close();
		}
		
		public void UpdateCampEmail(Camper camp,String email) {
			em.getTransaction().begin();
			camp.setEmail(email);
			em.getTransaction().commit();
			em.close();
		}
	}

