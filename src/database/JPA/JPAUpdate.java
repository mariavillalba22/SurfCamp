package database.JPA;


	import javax.persistence.EntityManager;

	import database.pojo.*;

	public class JPAUpdate {


		EntityManager em;
		
		public JPAUpdate(EntityManager em) {
			this.em=em;
		}
		
		public void updateCampName(Camper camp,String name) {
			em.getTransaction().begin();
			camp.setName(name);
			em.getTransaction().commit();
			
		}
		
		public void updateAccomAvailability(Accomodation acom, Integer a) {
			em.getTransaction().begin();
			acom.setAvailability(a);
			em.getTransaction().commit();
		}
		
		public void updateCampNIF(Camper camp,String NIF) {
			em.getTransaction().begin();
			camp.setNIF(NIF);
			em.getTransaction().commit();
			
		}
		
		public void updateCampPhoneNumber(Camper camp,int phoneNumber) {
			em.getTransaction().begin();
			camp.setPhonenumber(phoneNumber);
			em.getTransaction().commit();
			
		}
		
		public void updateCampEmail(Camper camp,String email) {
			em.getTransaction().begin();
			camp.setEmail(email);
			em.getTransaction().commit();
			
		}
		public void updateAccomodationName(Accomodation accomodation,String name) {
			em.getTransaction().begin();
			accomodation.setAccomodation(name);
			em.getTransaction().commit();
			
		}
		public void updateTransportName(Transport transport,String name) {
			em.getTransaction().begin();
			transport.setType_transport(name);
			em.getTransaction().commit();
			
		}
		public void updateTransportPrice(Transport transport,int price) {
			em.getTransaction().begin();
			transport.setPrice(price);
			em.getTransaction().commit();
			
		}
		
		public void updateAccomodationPrice(Accomodation accomodation,Integer price) {
			em.getTransaction().begin();
			accomodation.setPrice(price);
			em.getTransaction().commit();
			
		}
	}

