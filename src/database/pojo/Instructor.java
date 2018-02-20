package database.pojo;
import java.io.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class Instructor implements Serializable {
	
	private Integer id;
	private String name;
	private Integer phoneNumber;
	private Date dob;
	private String nacionality;
	private Integer salary;
	private Activity activityID;
	private Transport transport;
	
	public Instructor() {
		super();
	}

	public Instructor(Integer id,String name, Integer phoneNumber, LocalDate dob, String nacionality, Integer salary,
			Activity activityID, Transport transport) {
		super();
		this.id= id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.SetDateBirth(dob);
		this.nacionality = nacionality;
		this.salary = salary;
		this.activityID = activityID;
		this.transport = transport;
	}
	
	public Instructor(String name, Integer phoneNumber, LocalDate dob, String nacionality,
			Integer salary) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.SetDateBirth(dob);
		this.nacionality = nacionality;
		this.salary = salary;
		
	}
	
	public String toString() {
		return "El monitor es: "+name+". "+
        "Telephone number: "+phoneNumber+ ". "+
				"Date of birth: "+dob+". "+
        "Nacionality: "+nacionality+". "+
				"Salary: "+salary+". "+
        "Activity ID: "+activityID+
        "Transport "+transport.getType_transport();
        
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
		
	}
	public void SetDateBirth(LocalDate d) {
		this.dob= Date.valueOf(d);
	}

	public String getNacionality() {
		return nacionality;
	}

	public void setNacionality(String nacionality) {
		this.nacionality = nacionality;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Activity getActivityID() {
		return activityID;
	}

	public void setActivityID(Activity activityID) {
		this.activityID = activityID;
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
		Instructor other = (Instructor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
