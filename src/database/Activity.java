package database;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import sample.db.pojos.Report;
public class Activity  implements Serializable {

	private Integer id;
	private Activity activity;
	private Integer price;
	private List<Camper> campers;
	private List<Material> material;
	public Activity() {
		
	}

	public Activity(Activity activity, Integer price, List<Camper> campers, List<Material> material) {
		super();
		this.activity = activity;
		this.price = price;
		this.campers = new ArrayList<Camper>();
		this.material = new ArrayList<Material>();
	}

	public Activity(Integer id, Activity activity, Integer price) {
		super();
		this.id = id;
		this.activity = activity;
		this.price = price;
		this.campers = new ArrayList<Camper>();
		this.material = new ArrayList<Material>();
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

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", activity=" + activity + ", price=" + price + "]";
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
	
	
}
