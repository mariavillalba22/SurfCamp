package database.pojo;
import java.io.*;
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
@Table(name = "material")

public class Material implements Serializable{
	
	private static final long serialVersionUID = -4281575077333973070L;

	@Id
	@GeneratedValue(generator="material")
	@TableGenerator(name="material", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="material")
	
	private Integer id;
	private String name;
	private Integer price;
	@ManyToMany
	@JoinTable(name="camper",
		joinColumns={@JoinColumn(name="id_material", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="id_camper", referencedColumnName="id")})
	List<Camper> campers =new ArrayList();
	
	public Material() {
		super();
	}
	public Material(int id,String material, Integer price) {
		super();
		this.id = id;
		this.name = material;
		this.price = price;
	}
	
	public Material(String material, Integer price) {
		super();
		this.name = material;
		this.price = price;
	}
	
    public String toString() {
    	return "Material ID: "+id+" . Name: "+name+" . Price: "+price;
    }
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMaterial() {
		return name;
	}

	public void setMaterial(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public boolean addCamper(Camper camper) {
		Boolean h = false;
			if (!campers.contains(camper)) {
				this.campers.add(camper);
				h = true;
			}
			return h;
		}
		public boolean removeCamper(Camper camper) {
			Boolean h = false;
			if(campers.contains(camper)) {
				this.campers.remove(camper);
				h = true;
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
		Material other = (Material) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}


