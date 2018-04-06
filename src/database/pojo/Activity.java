package database.pojo;
import java.io.*;

import database.pojo.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "activity")

public class Activity  implements Serializable {

	private static final long serialVersionUID = -4281575077333973070L;
	
	@Id
	@GeneratedValue(generator="activity")
	@TableGenerator(name="activity", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="activity")
	private Integer id;
	private String name;
	private Integer price;
	@ManyToMany
	@JoinTable(name="camper",
		joinColumns={@JoinColumn(name="id_activity", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="id_camper", referencedColumnName="id")})
	private List<Camper> campers;
	@ManyToMany
	@JoinTable(name="material",
		joinColumns={@JoinColumn(name="id_activity", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="id_material", referencedColumnName="id")})
	private List<Material> material;
// faltan metodos
	public Activity() {
		super();
		this.campers = new ArrayList<Camper>();
	}

	public Activity(String activity, Integer price, List<Camper> campers, List<Material> material) {
		super();
		this.name = activity;
		this.price = price;
		if(campers!= null)
		    this.campers = campers;
		else
			this.campers = new ArrayList<Camper>();
		if(material!= null)
			this.material = material;
		else
			this.material = new ArrayList<Material>();
	}


	public Activity(String activity, Integer price) {
		super();
		this.name = activity;
		this.price = price;
		this.campers = new ArrayList<Camper>();
		this.material = new ArrayList<Material>();
	}
	public Activity(Integer id,String activity, Integer price) {
		super();
		this.id = id;
		this.name = activity;
		this.price = price;
		this.campers = new ArrayList<Camper>();
		this.material = new ArrayList<Material>();
	}

	public String toString() {
    	return " The activity ID is: "+id+"."+
    "Name of activity: "+name+" Price: "+price;
    	
    
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
