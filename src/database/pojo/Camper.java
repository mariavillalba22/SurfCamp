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

	private Integer needtopay;

	


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
	private  List<Material> materials;

	@ManyToMany
	@JoinTable(name="activity",
		joinColumns={@JoinColumn(name="id_camper", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="id_activity", referencedColumnName="id")})
	private List<Activity> activities;
	
	
	
	
	public Camper() {
		super();
		this.materials = new ArrayList<Material>();
		this.activities = new ArrayList<Activity>();
		
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
		this.materials = material;
		this.activities = activities;
		
		
	}
	
	
	
	
	public Camper( int id,String name, LocalDate dateofbirth, String NIF
			, Integer phonenumber, String email, String payment_method, Integer needtopay) {
		super();
		this.id = id;
		this.name = name;
		this.setDateBirth(dateofbirth);
		this.NIF = NIF;
		this.phone_number= phonenumber;
		this.email= email;
		this.payment_method= payment_method;
		this.needtopay = needtopay;
		
	}
	
	public Camper(int id,String name,int phone) {
		this.id=id;
		this.name=name;
		this.phone_number=phone;		
	}
	public List<Activity> getActivity() {
		return activities;
	}
	public void setActivities(List<Activity> activity) {
		this.activities = activity;
	}
	public List<Material> getMaterial() {
		return materials;
	}
	public void setMaterial(List<Material> material) {
		this.materials = material;
	}
	
	public Boolean addActivity(Activity activity1) {
	Boolean h = false;
		if (!activities.contains(activity1)) {
			h = true;
			this.activities.add(activity1);
		}
		return h;
	}
	
	public boolean removeActivity(Activity activity1) {
		Boolean h = false;
		if (!activities.contains(activity1)) {
			h = true;
			this.activities.remove(activity1);
		}
		return h;
	}
	
	public boolean addMaterial(Material material1) {
		Boolean h = false;
		if (!materials.contains(material1)) {
			h = true;
			this.materials.add(material1);
		}
		return h;
	}
	public boolean removeMaterial(Material material1) {
		Boolean h = false;
		if(materials.contains(material1)) {
			h = true;
			this.materials.remove(material1);
		}
		return h;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getNeedtopay() {
		return needtopay;
	}
	public void setNeedtopay(Integer needtopay) {
		this.needtopay = needtopay;
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
	
	//Tenemos dos metodos de date pquno es local date y otro date
	//Son formatos distintos y hay que convertirlos
	
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
	
	public Integer addNeedToPay(Integer suma) {
		this.needtopay= needtopay+suma;
		return needtopay;
	}
	
	public Integer removeNeedToPay(Integer resta) {
		this.needtopay = needtopay-resta;
		return needtopay;
	}
	
	public int hashCode() {
		final int prime =31;
		int result = -1;
		result = prime*result+((id==null)?0:id.hashCode());
		return result;
	}
	
	public String toString() {
		return "Camper id = "+id+", name = "+name+" , date of birth "+dob+" , NIF = "+NIF+" , phone number = "+phone_number+" , email = "+email+", payment method = "+ payment_method+", Need to pay: "+needtopay;
	
	}
	public String showNamePhone(){
		return "Camper: [id: "+id+" Name: "+name+" Phone:"+phone_number+"]";
	}
	
	//the material ,accomododarion, activity,transport dont need to be printed.
	

}