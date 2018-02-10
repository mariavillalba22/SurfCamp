package database.pojo;
import java.io.*;

public class Material implements Serializable{

	
	private Integer id;
	private String material;
	private Integer price;
	
	public Material() {
		super();
	}
	public Material(String material, Integer price) {
		super();
		
		this.material = material;
		this.price = price;
	}
	public Material(Integer id,String material, Integer price) {
		super();
		this.id= id;
		this.material = material;
		this.price = price;
	}
    public String toString() {
    	return "Material ID: "+id+" . Name: "+material+" . Price: "+price;
    }
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
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

