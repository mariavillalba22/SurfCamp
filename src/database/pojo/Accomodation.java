package database.pojo;

import java.util.*;
public class Accomodation {

	private Integer id;
	private String accomodation;
	private Integer price;
	private List <Camper> campers;
	private List <Instructor> instructors;
	
	public Accomodation() {
		super();
		this.campers = new ArrayList<Camper>();
		this.instructors = new ArrayList<Instructor>();
		
	}
	public Accomodation(String accomodation, Integer price) {
		super();
		this.accomodation = accomodation;
		this.price = price;
		
	}
	public Accomodation(Integer price, String accomodation,  List<Camper> campers) {
		super();
		this.id = id;
		this.accomodation = accomodation;
		this.price = price;
		this.campers = campers;
	}
	
	public Accomodation(String accomodation, Integer price, List<Instructor> instructors) {
		super();
		this.id = id;
		this.accomodation = accomodation;
		this.price = price;
		this.instructors = instructors;
	}
	public Accomodation(String accomodation, Integer price, List<Camper> campers, List<Instructor> instructors) {
		super();
		this.accomodation = accomodation;
		this.price = price;
		this.campers = campers;
		this.instructors= instructors;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccomodation() {
		return accomodation;
	}
	public void setAccomodation(String accomodation) {
		this.accomodation = accomodation;
	}
	public List<Instructor> getInstructors() {
		return instructors;
	}
	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}
	public String toString() {
		return "Accomodation--> id: "+id+" . Type of accomodation: "+accomodation+" . Price: "+price+ " . Camper: "+campers+". Instructors: "+instructors;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public List<Camper> getCampers() {
		return campers;
	}
	public void setCampers(List<Camper> campers) {
		this.campers = campers;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accomodation other = (Accomodation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public void addCamper(Camper camper) {
		if (!campers.contains(camper)) {
			this.campers.add(camper);
		}
	}
	public void removeCamper(Camper camper) {
		if(campers.contains(camper)) {
			this.campers.remove(camper);
		}
	}

	
	
}

