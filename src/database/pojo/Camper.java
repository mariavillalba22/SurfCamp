package database.pojo;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Camper implements Serializable{
	private Integer id;
	private String name;
	private Date dateofbirth;
	private String NIF;
	private Integer phonenumber;
	private String email;
	private String payment_method;
	private Transport transports;
	private Accomodation accomodation;
	private  List<Material> materials;
	private Activity activity;
	
	
	// Aqui no sabia si poner un array de activities o un objeto
	// es que no me acordaba si alfinal era que un camper podía muchas actividades
	public Camper() {
		super();
		this.transports = new Transport();
		this.accomodation= new Accomodation();
		
	}
	public Camper(Integer id, String name, LocalDate dateofbirth, String NIF
			, Integer phonenumber, String email, String payment_method
			, Transport transports, Accomodation accomodation,Material material) {
		super();
		this.id = id;
		this.name = name;
		this.SetDateBirth(dateofbirth);
		this.NIF = NIF;
		this.phonenumber= phonenumber;
		this.email= email;
		this.payment_method= payment_method;
		this.transports= transports;
		this.accomodation= accomodation;
		//me da problemas aqui
		this.addMaterial(material);
		
	}
	
	public List<Material> getMaterials() {
		return materials;
	}
	public void setMaterials(List<Material> materials) {
		this.materials = materials;
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
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getNIF() {
		return NIF;
	}
	public void setNIF(String nIF) {
		NIF = nIF;
	}
	public Integer getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(Integer phonenumber) {
		this.phonenumber = phonenumber;
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
		this.dateofbirth= Date.valueOf(d);
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
		return "Camper [id = "+id+", name = "+name+" , date of birth "+dateofbirth+" , NIF = "+NIF+" , phone number = "+phonenumber+" , email = "+email+", payment method"+ payment_method+",  type of transport "+transports+", type of accomodation = "+accomodation+", type of materials = "+materials+"]";
	}
	
	
	

}
