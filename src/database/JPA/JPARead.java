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
	
	public Material readMaterial(String name) {
		Query q1 = em.createNativeQuery("SELECT * FROM material WHERE name LIKE ?", Material.class);
		q1.setParameter(1, "%" + name + "%");
		Material material = (Material) q1.getSingleResult();
		return material;
	}
	
	public List<Transport> ReadTransports() {
		Query q1 = em.createNativeQuery("SELECT * FROM transport ", Transport.class);
		List<Transport> trans = (List<Transport>) q1.getResultList();
		return trans;
	}
}
