package database;

public class Accomodation {

	private Integer id;
	private String accomodation;
	private Integer price;
	private List <Camper> campers;
	private List <Instructor> instructors;
	
	
	public Accomodation(String accomodation, Integer price, List<Camper> campers, List<Instructor> instructors) {
		super();
		this.accomodation = accomodation;
		this.price = price;
		this.campers = new ArrayList <Camper>();
		this.instructors = new ArrayList <Instructor>();
		
	}
	public String getAccomodation() {
		return accomodation;
	}
	public void setAccomodation(String accomodation) {
		this.accomodation = accomodation;
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
	public List<Instructor> getInstructors() {
		return instructors;
	}
	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
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

	
	
}

