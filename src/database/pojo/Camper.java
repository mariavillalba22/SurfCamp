package database.pojo;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Camper implements Serializable{
	private Integer id;
	private String name;
	private Date dob;
	private String NIF;
	private Integer phone_number;
	private String email;
	private String payment_method;
	private Transport transports;
	private Accomodation accomodation;
	private  List<Material> materials;

	private Activity activity;
	private List<Activity> activities;
	
	
	public Camper() {
		super();
		this.materials = new ArrayList<Material>();
		this.activities = new ArrayList<Activity>();
		
	}
	public Camper( String name, LocalDate dateofbirth, String NIF
			, Integer phonenumber, String email, String payment_method
			/*,Transport transports,Accomodation accomodation,List<Material> materials,
			List<Activity> activities*/) {
		super();
		this.name = name;
		this.SetDateBirth(dateofbirth);
		this.NIF = NIF;
		this.phone_number= phonenumber;
		this.email= email;
		this.payment_method= payment_method;
		this.transports=transports;
		//i coment this to prove if the insert method works
		//this.transports= transports;
		//this.accomodation= accomodation;
		//this.materials = materials;
		//this.activities=activities;
		
	}
	
	
	public Camper( int id,String name, LocalDate dateofbirth, String NIF
			, Integer phonenumber, String email, String payment_method
			/*,Transport transports, Accomodation accomodation,List<Material> materials,
			List<Activity> activities*/) {
		super();
		this.id = id;
		this.name = name;
		this.SetDateBirth(dateofbirth);
		this.NIF = NIF;
		this.phone_number= phonenumber;
		this.email= email;
		this.payment_method= payment_method;
		//i coment this to prove if the insert method works
		//this.transports= transports;
		//this.accomodation= accomodation;
		//this.materials = materials;
		//this.activities=activities;
		
	}
	
	public List<Activity> getActivities() {
		return activities;
	}
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	public List<Material> getMaterials() {
		return materials;
	}
	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}
	
	public void addActivity(Activity activity) {
		if (!activities.contains(activity)) {
			this.activities.add(activity);
		}
	}
	
	public void removeActivity(Activity activity) {
		if (!activities.contains(activity)) {
			this.activities.remove(activity);
		}
	}
	
	public void addMaterial(Material material) {
		if (!materials.contains(material)) {
			this.materials.add(material);
		}
	}
	public void removeMaterial(Material material) {
		if(materials.contains(material)) {
			this.materials.remove(material);
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
		return transports;
	}
	public void setTransports(Transport transports) {
		this.transports = transports;
	}
	public void SetDateBirth(LocalDate d) {
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
		return "Camper [id = "+id+", name = "+name+" , date of birth "+dob+" , NIF = "+NIF+" , phone number = "+phone_number+" , email = "+email+", payment method"+ payment_method+",  type of transport "+transports+", type of accomodation = "+accomodation+", type of materials = "+materials+", type of activities"+activities+"]";
	}
	
	
	

}
