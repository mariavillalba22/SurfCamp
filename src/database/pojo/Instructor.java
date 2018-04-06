package database.pojo;
import java.io.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "instructor")

public class Instructor implements Serializable {
	
private static final long serialVersionUID = -4281575077333973070L;
	
	@Id
	@GeneratedValue(generator="instructor")
	@TableGenerator(name="instructor", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="instructor")
	
	private Integer id;
	private String name;
	private Integer phone_number;
	private Date dob;
	private String NIF;
	private String nationality;
	private Integer salary;
	
	@OneToMany(mappedBy="instructor")
	private Activity activity;
	@OneToMany(mappedBy="instructor")
	private Transport transport;
	//accomodation???
	
	public Instructor() {
		super();
	}

	public Instructor(String name, Integer phoneNumber, LocalDate dob,String NIF, String nacionality, Integer salary,
			Activity activity, Transport transport) {
		super();
		
		this.name = name;
		this.phone_number = phoneNumber;
		this.SetDateBirth(dob);
		this.NIF=NIF;
		this.nationality = nationality;
		this.salary = salary;
		this.activity = activity;
		this.transport = transport;
	}
	

	public Instructor(Integer id,String name, Integer phoneNumber, LocalDate dob, String NIF,String nationality,
			Integer salary) {
		super();
		this.id=id;
		this.name = name;
		this.phone_number = phoneNumber;
		this.NIF=NIF;
		this.SetDateBirth(dob);
		this.nationality = nationality;
		this.salary = salary;
		
	}
	public Instructor(String name, Integer phoneNumber, LocalDate dob, String NIF,String nationality,
			Integer salary) {
		super();
		this.name = name;
		this.phone_number = phoneNumber;
		this.NIF=NIF;
		this.SetDateBirth(dob);
		this.nationality = nationality;
		this.salary = salary;
		
	}
	

	
	public String toString() {
		return "El monitor es: "+name+". "+
        "Telephone number: "+phone_number+ ". "+
				"Date of birth: "+dob+". "+
        "Nacionality: "+nationality+". "+
				"Salary: "+salary+". "+
         "Activity ID: "+activity+
        "Transport "+transport;
	}
	
	// nos imprime continuamente NULL en activity y en transport
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public Integer getPhoneNumber() {
		return phone_number;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phone_number = phoneNumber;
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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
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
