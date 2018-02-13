package database.pojo;

import java.io.Serializable;
import java.util.*;

public class Transport implements Serializable{
	private Integer id;
	private String type_transport;
	private List<Camper> campers;
	private List<Instructor> instructors;
	
	public Transport() {
		super();
		this.campers = new ArrayList<Camper>();
		this.instructors = new ArrayList<Instructor>();
	}
	
	public Transport (Integer id, String type_transport) {
		super();
		this.id= id;
		this.type_transport = type_transport;
		this.campers= new ArrayList<Camper>();
		this.instructors = new ArrayList<Instructor>();
	}
	public Transport(Integer id, String type_transport,List<Camper> campers) {
		super();
		this.id=id;
		this.type_transport=type_transport;
		this.campers= campers;
	}
	public Transport ( String type_transport, List<Instructor> instructors) {
		super();
		this.type_transport = type_transport;
		
		this.instructors = instructors;
	}
	public Transport (Integer id, String type_transport, List<Camper>campers, List <Instructor>instructors) {
		super();
		this.id= id;
		this.type_transport = type_transport;
		this.campers= campers;
		this.instructors = instructors;
	}
	public int hashCode() {
		final int prime =31;
		int result = -1;
		result = prime*result+((id==null)?0:id.hashCode());
		return result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType_transport() {
		return type_transport;
	}

	public void setType_transport(String type_transport) {
		this.type_transport = type_transport;
	}

	public List<Camper> getCampers() {
		return campers;
	}

	public void setCampers(List<Camper> campers) {
		this.campers = campers;
	}
	public String toString() {
		return " id ="+id+ " , Type = "+type_transport+"."+ "Campers = "+campers+". Instructors ="+instructors+".";
		
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
