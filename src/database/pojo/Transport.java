package database.pojo;


import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "transport")

public class Transport implements Serializable{
	
private static final long serialVersionUID = -4281575077333973070L;
	
	@Id
	@GeneratedValue(generator="transport")
	@TableGenerator(name="transport", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="transport")
	
	private Integer id;
	private String name;
	private Integer price;
	@OneToMany(mappedBy="transport")
	private List<Camper> campers;
	@OneToMany(mappedBy="transport")
	private List<Instructor> instructors;
	
	public Transport() {
		super();
		this.campers = new ArrayList<Camper>();
		this.instructors = new ArrayList<Instructor>();
	}
	
	public Transport (String type_transport, Integer price) {
		super();
		this.name = type_transport;
		this.price=price;
	}

	public Transport (Integer id ,String type_transport, Integer price) {
		super();
		this.id= id;
		this.name = type_transport;
		this.price=price;
	}
	
	public Transport ( String type_transport,Integer price, List<Camper>campers, List <Instructor>instructors) {
		super();
		this.id= id;
		this.price = price;
		this.name = type_transport;
		if (campers != null)
			this.campers= campers;
		else
			this.campers = new ArrayList<Camper>();
		if(instructors!= null)
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price ) {
		this.price=price;
	}

	public String getType_transport() {
		return name;
	}

	public void setType_transport(String type_transport) {
		this.name = type_transport;
	}

	public List<Camper> getCampers() {
		return campers;
	}

	public void setCampers(List<Camper> campers) {
		this.campers = campers;
	}
	
	
	@Override
	public String toString() {
		return "Transport [id=" + id + ", type_transport=" + name +  "price=" +price+"]";
	}
	//problemas a la hora de imprimir las listas en el select
	
    
	
	public List<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
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
		Transport other = (Transport) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
