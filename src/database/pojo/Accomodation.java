package database.pojo;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "accomodation")

public class Accomodation {

private static final long serialVersionUID = -4281575077333973070L;
	
	@Id
	@GeneratedValue(generator="accomodation")
	@TableGenerator(name="accomodation", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="accomodation")
	private Integer id;
	private String name;
	private Integer price;
	private Integer availability;
	@OneToMany(mappedBy="accomodation")
	private List <Camper> campers;
	@OneToMany(mappedBy="accomodation")
	private List <Instructor> instructors;
	
	public Accomodation() {
		super();
		this.campers = new ArrayList<Camper>();
		this.instructors = new ArrayList<Instructor>();
		
	}
	public Accomodation(String accomodation, Integer price) {
		super();
		this.name = accomodation;
		this.price = price;
	}
	public Accomodation(Integer id,String accomodation, Integer price, Integer availability) {
		super();
		this.id = id;
		this.name = accomodation;
		this.price = price;
		this.availability = availability;
	}
	
	public Accomodation(Integer price, String accomodation,  List<Camper> campers) {
		super();
		this.id = id;
		this.name = accomodation;
		this.price = price;
		this.campers = campers;
	}
	
	public Accomodation(String accomodation, Integer price, List<Instructor> instructors) {
		super();
		this.id = id;
		this.name = accomodation;
		this.price = price;
		this.instructors = instructors;
	}
	public Accomodation(String accomodation, Integer price, List<Camper> campers, List<Instructor> instructors) {
		super();
		this.name = accomodation;
		this.price = price;
		if(campers!= null)
			this.campers = campers;
		else
			this.campers = new ArrayList<Camper>();
		if(instructors !=null)
			this.instructors = instructors;
		else
			this.instructors = new ArrayList<Instructor>();

	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccomodation() {
		return name;
	}
	public void setAccomodation(String accomodation) {
		this.name = accomodation;
	}
	public List<Instructor> getInstructors() {
		return instructors;
	}
	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}
	public String toString() {
		return "Accomodation_Id: "+id+" . Type of accomodation: "+name+" . Price: "+price;
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
	public boolean checkAvailability() {
		boolean h;
		if( getAvailability()>150) {
			h = false;
		}else {
			h=true;
		}
		return h;
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
	public Integer getAvailability() {
		return availability;
	}
	public void setAvailability(Integer availability) {
		this.availability = availability;
	}

	
	
}

