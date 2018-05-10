package database.pojo;
import java.io.*;

import database.pojo.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.*;



@Entity
@Table(name = "activity")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "activity")
@XmlType(propOrder = { "id", "name", "price", "availability" })

public class Activity  implements Serializable {

	private static final long serialVersionUID = -4281575077333973070L;
	
	@Id
	@GeneratedValue(generator="activity")
	@TableGenerator(name="activity", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="activity")
	
	@XmlAttribute
	private Integer id;
	@XmlAttribute
	private String name;
	@XmlElement
	private Integer price;
	@XmlElement
	private Integer availability;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "instructor_id")
	@XmlTransient
	private Instructor inst;
	@XmlTransient
	@ManyToMany
	@JoinTable(name="camper",
		joinColumns={@JoinColumn(name="id_activity", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="id_camper", referencedColumnName="id")})
	private List<Camper> campers;
	@ManyToMany
	@XmlTransient
	@JoinTable(name="material",
		joinColumns={@JoinColumn(name="id_activity", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="id_material", referencedColumnName="id")})
	private List<Material> material;
	//ELIMINAR

// faltan metodos
	public Activity() {
		super();
		this.campers = new ArrayList<Camper>();
	}

	public Activity(String activity, Integer price, Instructor inst,List<Camper> campers, List<Material> material) {
		super();
		this.name = activity;
		this.price = price;
		this.inst = inst;
		if(campers!= null)
		    this.campers = campers;
		else
			this.campers = new ArrayList<Camper>();
		if(material!= null)
			this.material = material;
		else
			this.material = new ArrayList<Material>();
	}


	public Instructor getInst() {
		return inst;
	}

	public void setInst(Instructor inst) {
		this.inst = inst;
	}

	public Activity(String activity, Integer price) {
		super();
		this.name = activity;
		this.price = price;
		this.campers = new ArrayList<Camper>();
		this.material = new ArrayList<Material>();
	}
	public Activity(Integer id,String activity, Integer price, Integer availability) {
		super();
		this.id = id;
		this.name = activity;
		this.price = price;
		this.availability = availability;
		this.campers = new ArrayList<Camper>();
		this.material = new ArrayList<Material>();
	}

	public String toString() {
    	return " The activity ID is: "+id+". "+
    "Name of activity: "+name+".  Price: "+price;
    	
    
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
		Activity other = (Activity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActivity() {
		return name;
	}

	public void setActivity(String activity) {
		this.name = activity;
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

	public List<Material> getMaterial() {
		return material;
	}

	public void setMaterial(List<Material> material) {
		this.material = material;
	}
	public Integer getAvailability() {
		return availability;
	}

	public void setAvailability(Integer availability) {
		this.availability = availability;
	}
	
	public boolean checkAvailability() {
		boolean h;
		if( getAvailability()>15) {
			h = false;
		}else {
			h=true;
		}
		return h;
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
