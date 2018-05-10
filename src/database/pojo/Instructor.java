package database.pojo;
import java.io.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import database.XML.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@Entity
@Table(name = "instructor")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Instructor")
@XmlType(propOrder = { "id", "name", "phone_number","dob","NIF","nationality","salary","activities" })
public class Instructor implements Serializable {
	
private static final long serialVersionUID = -4281575077333973070L;
	
	@Id
	@GeneratedValue(generator="instructor")
	@TableGenerator(name="instructor", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="instructor")
	@XmlAttribute
	private Integer id;
	@XmlAttribute
	private String name;
	@XmlElement
	private Integer phone_number;
	@XmlElement
	@XmlJavaTypeAdapter(SQLDateAdapter.class)
	private Date dob;
	@XmlElement
	private String NIF;
	@XmlElement
	private String nationality;
	@XmlElement
	private Integer salary;
	
	@OneToMany(mappedBy="inst")
	@XmlElement(name = "activity")
	@XmlElementWrapper(name = "activities")
	//Because many activities can have different instructors
	//We are not showing the activities in instructor because we 
	//are showing it in activities
	private List<Activity> activities;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transport_id")
	@XmlTransient
	private Transport transport;
    //SI DA TIEMPO SE HACE
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accomodation_id")
	@XmlTransient
	private Accomodation accomodation;

	
	public Instructor() {
		super();
	}

	public Instructor (String name, Integer phoneNumber, LocalDate dob,String NIF, String nacionality, Integer salary){
		super();
		
		this.name = name;
		this.phone_number = phoneNumber;
		this.SetDateBirth(dob);
		this.NIF=NIF;
		this.nationality = nationality;
		this.salary = salary;
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
	
	
	public String toString() {
		return "Id : "+id+". "
				+ "Name: "+name+". "+
        "Telephone number: "+phone_number+ ". "+
				"Date of birth: "+dob+". "+
        "Nacionality: "+nationality+". "+
				"Salary: "+salary+". ";
	}
	
	
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
	public void setDateBirth(LocalDate d)  {
		this.dob= Date.valueOf(d);
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


	
	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
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
	
	public Accomodation getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(Accomodation accomodation) {
		this.accomodation = accomodation;
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
