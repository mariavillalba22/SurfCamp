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
			
		}
		
		public void UpdateAccomAvailability(Accomodation acom, Integer a) {
			em.getTransaction().begin();
			acom.setAvailability(a);
			em.getTransaction().commit();
		}
		
		public void UpdateCampNIF(Camper camp,String NIF) {
			em.getTransaction().begin();
			camp.setNIF(NIF);
			em.getTransaction().commit();
			
		}
		
		public void UpdateCampPhoneNumber(Camper camp,int phoneNumber) {
			em.getTransaction().begin();
			camp.setPhonenumber(phoneNumber);
			em.getTransaction().commit();
			
		}
		
		public void UpdateCampEmail(Camper camp,String email) {
			em.getTransaction().begin();
			camp.setEmail(email);
			em.getTransaction().commit();
			
		}
		public void UpdateAccomodationName(Accomodation accomodation,String name) {
			em.getTransaction().begin();
			accomodation.setAccomodation(name);
			em.getTransaction().commit();
			
		}
		public void UpdateTransportName(Transport transport,String name) {
			em.getTransaction().begin();
			transport.setType_transport(name);
			em.getTransaction().commit();
			
		}
		public void UpdateTransportPrice(Transport transport,int price) {
			em.getTransaction().begin();
			transport.setPrice(price);
			em.getTransaction().commit();
			
		}
		
		public void UpdateAccomodationPrice(Accomodation accomodation,Integer price) {
			em.getTransaction().begin();
			accomodation.setPrice(price);
			em.getTransaction().commit();
			
		}
	}

