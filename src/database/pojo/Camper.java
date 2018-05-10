package database.pojo;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="camper")

public class Camper implements Serializable{
	private static final long serialVersionUID = -4281575077333973070L;
	@Id
	@GeneratedValue(generator="camper")
	@TableGenerator(name = "camper", table = "sqlite_sequence",
	pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "camper")
	
	private Integer id;
	private String name;
	private Date dob;
	private String NIF;
	private Integer phone_number;
	private String email;
	private String payment_method;
<<<<<<< HEAD
	private Transport transports;
	private Accomodation accomodation;
	private  List<Material> materials;
<<<<<<< HEAD
	private Activity activity ;
=======
=======
	
>>>>>>> branch 'master' of https://github.com/mariavillalba22/SurfCamp

<<<<<<< HEAD
	private Activity activity;
	private List<Activity> activities;
>>>>>>> branch 'master' of https://github.com/mariavillalba22/SurfCamp
=======
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transport_id")
	private Transport transport;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accomodation_id")
	private Accomodation accomodation;
	@ManyToMany
	@JoinTable(name="material",
		joinColumns={@JoinColumn(name="id_camper", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="id_material", referencedColumnName="id")})
	private  List<Material> material;

	@ManyToMany
	@JoinTable(name="activity",
		joinColumns={@JoinColumn(name="id_camper", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="id_activity", referencedColumnName="id")})
	private List<Activity> activity;
	
	
	
>>>>>>> branch 'master' of https://github.com/mariavillalba22/SurfCamp
	
	
	public Camper() {
		super();
		this.material = new ArrayList<Material>();
		this.activity = new ArrayList<Activity>();
		
	}
	public Camper( String name, LocalDate dateofbirth, String NIF
			, Integer phonenumber, String email, String payment_method
			,Transport transport,Accomodation accomodation, List<Material> material,
			List<Activity> activities) {
		super();
		this.name = name;
		this.setDateBirth(dateofbirth);
		this.NIF = NIF;
		this.phone_number= phonenumber;
		this.email= email;
		this.payment_method= payment_method;
		this.transport=transport;
		this.accomodation = accomodation;
		this.material = material;
		this.activity = activity;
		
		
	}
	
	
	
	
	public Camper( int id,String name, LocalDate dateofbirth, String NIF
			, Integer phonenumber, String email, String payment_method) {
		super();
		this.id = id;
		this.name = name;
		this.setDateBirth(dateofbirth);
		this.NIF = NIF;
		this.phone_number= phonenumber;
		this.email= email;
		this.payment_method= payment_method;
		
	}
	
	public Camper(int id,String name,int phone) {
		this.id=id;
		this.name=name;
		this.phone_number=phone;		
	}
	public List<Activity> getActivity() {
		return activity;
	}
	public void setActivities(List<Activity> activity) {
		this.activity = activity;
	}
	public List<Material> getMaterial() {
		return material;
	}
	public void setMaterial(List<Material> material) {
		this.material = material;
	}
	
	public void addActivity(Activity activity1) {
		if (!activity.contains(activity1)) {
			this.activity.add(activity1);
		}
	}
	
	public void removeActivity(Activity activity1) {
		if (!activity.contains(activity1)) {
			this.activity.remove(activity1);
		}
	}
	
	public void addMaterial(Material material1) {
		if (!material.contains(material1)) {
			this.material.add(material1);
		}
	}
	public void removeMaterial(Material material1) {
		if(material.contains(material1)) {
			this.material.remove(material1);
		}
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
	public Date getDateofbirth() {
		return dob;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dob = dateofbirth;
	}
	public String getNIF() {
		return NIF;
	}
	public void setNIF(String nIF) {
		NIF = nIF;
	}
	
	public Integer getPhonenumber() {
		return phone_number;
	}
	public void setPhonenumber(Integer phonenumber) {
		this.phone_number = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public Transport getTransports() {
		return transport;
	}
	public void setTransports(Transport transports) {
		this.transport = transports;
	}
	public void setDateBirth(LocalDate d)  {
		this.dob= Date.valueOf(d);
	}
	
	public Accomodation getAccomodation() {
		return accomodation;
	}
	public void setAccomodation(Accomodation accomodation) {
		this.accomodation = accomodation;
	}
	
	public int hashCode() {
		final int prime =31;
		int result = -1;
		result = prime*result+((id==null)?0:id.hashCode());
		return result;
	}
	
	public String toString() {
		return "Camper id = "+id+", name = "+name+" , date of birth "+dob+" , NIF = "+NIF+" , phone number = "+phone_number+" , email = "+email+", payment method"+ payment_method;
	
	}
	public String showNamePhone(){
		return "Camper: [id: "+id+" Name: "+name+" Phone:"+phone_number+"]";
	}
	
	//the material ,accomododarion, activity,transport dont need to be printed.
	

}