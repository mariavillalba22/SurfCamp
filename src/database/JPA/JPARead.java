package database.JPA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import database.pojo.*;


public class JPARead {
 EntityManager em;
	public JPARead(EntityManager em) {
		this.em = em;
	}
	
	public void ReadMat_Camp(Camper camper) {
		Query q1 = em.createNativeQuery("SELECT * FROM material WHERE id = (SELECT id_material FROM"
				+ "camper_material WHERE id_camper =  ?", Camper.class);
		q1.setParameter(1, "%" + camper.getId() + "%");
		List<Material> mat = (List<Material>) q1.getResultList();
		System.out.println(mat);
	}
	
	public void ReadTransport(Transport transport) {
		Query q1 = em.createNativeQuery("SELECT * FROM material WHERE id = (SELECT id_material FROM"
				+ "camper_material WHERE id_camper =  ?", Transport.class);
		q1.setParameter(1, "%" + transport.getId() + "%");
		List<Material> mat = (List<Material>) q1.getResultList();
		System.out.println(mat);
	}
}
