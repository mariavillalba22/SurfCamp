package database;
import database.*;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;
import database.pojo.*;


public class Selection {
	Connection c;
	public Selection (Connection c){
		this.c=c;
	}
	
	public List<Camper> selectCamper () throws SQLException{
		Statement stmt = c.createStatement();
		String sql = "SELECT * FROM camper";
		ResultSet rs = stmt.executeQuery(sql);
		List<Camper> campers = new ArrayList();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			LocalDate dob = rs.getDate("dob").toLocalDate();
			String NIF=rs.getString("NIF");
			int phonenumber=rs.getInt("phone_number");
			String email=rs.getString("email");
			String payment_method=rs.getString("payment_method");
			Integer needtopay = rs.getInt("needtopay");
			Camper camper = new Camper (id,name,dob,NIF,phonenumber,email,payment_method,needtopay);
			campers.add(camper);
		}
		rs.close();
		stmt.close();
		return campers;

	}
	public List<Camper> selectCamperbyName(String name) throws SQLException{
		String sql = "SELECT id,name,phone_number FROM camper WHERE name LIKE ? ";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1, name);
		ResultSet rs = prep.executeQuery();
		List<Camper> campers = new ArrayList();
		while(rs.next()) {
			int id=rs.getInt("id");
			String nm=rs.getString("name");
			int pn=rs.getInt("phone_number");
			Camper c=new Camper(id,nm,pn);
			campers.add(c);
		}
		rs.close();
		prep.close();
		return campers;
	}
	
	
	public List<String> selectCamperName () throws SQLException{
		Statement stmt = c.createStatement();
		String sql = "SELECT name FROM camper";
		ResultSet rs = stmt.executeQuery(sql);
		List<String> names = new ArrayList();
		while (rs.next()) {
			names.add(rs.getString("name"));
		}
		rs.close();
		stmt.close();
		return names;

	}	
	
	public String selectCamperNamefromId (Integer idcamper) throws SQLException{//NUEVO
		String sql = "SELECT name FROM camper WHERE id=?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, idcamper);
		ResultSet rs = prep.executeQuery();
		String name = rs.getString("name");
		return name;
	}
		

	public List<Instructor> selectInstructor() throws SQLException{
		Statement stmt = c.createStatement();
		String sql = "SELECT * FROM instructor";
		ResultSet rs = stmt.executeQuery(sql);
		List<Instructor> instructors = new ArrayList();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int phone_number=rs.getInt("phone_number");
			LocalDate dof = rs.getDate("dob").toLocalDate();
			String NIF=rs.getString("NIF");
			String nacionality=rs.getString("nationality");
			int salary = rs.getInt("salary");
			Instructor instructor = new Instructor (id,name,phone_number,dof,NIF,nacionality,salary);
			instructors.add(instructor);
		}
		rs.close();
		stmt.close();
		return instructors;
	}
	
	public List<Material> selectMaterial ()throws SQLException{
		Statement stmt = c.createStatement();
		String sql = "SELECT * FROM material";
		ResultSet rs = stmt.executeQuery(sql);
		List<Material> materials = new ArrayList();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			Material mat = new Material (id,name,price);
			materials.add(mat);
			
		}
		rs.close();
		stmt.close();
		return materials;
	}
	public List<Transport> selectTransport() throws SQLException{
		Statement stmt = c.createStatement();
		String sql = "SELECT * FROM transport";
		ResultSet rs = stmt.executeQuery(sql);
		List<Transport> t = new ArrayList();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			Integer availability = rs.getInt("availability");
			Transport trans = new Transport (id,name,price, availability);
			t.add(trans);
			
		}
		rs.close();
		stmt.close();
		return t;
	}
	
	public List<Accomodation> selectAccomodation()throws SQLException{
		Statement stmt = c.createStatement();
		String sql = "SELECT * FROM accomodation";
		ResultSet rs = stmt.executeQuery(sql);
		List<Accomodation> acom = new ArrayList();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			Integer availability = rs.getInt("availability");
			Accomodation acomodation= new Accomodation (id,name,price, availability);
			acom.add(acomodation);
		}
		rs.close();
		stmt.close();
		return acom;
	}
	
	public List<Accomodation> selectAccomodationHigher(Integer hprice)throws SQLException{
		
		String sql = "SELECT * FROM accomodation WHERE price < ?";
		List<Accomodation> acom = new ArrayList();
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, hprice);
		ResultSet rs = prep.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			Integer availability = rs.getInt("availability");
			Accomodation acomodation= new Accomodation (id,name,price, availability);
			acom.add(acomodation);
		}
		rs.close();
		prep.close();
		return acom;
	}
	
public List<Activity> selectActivityHigher(Integer hprice)throws SQLException{
		
		String sql = "SELECT * FROM activity WHERE price < ?";
		List<Activity> act = new ArrayList();
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, hprice);
		ResultSet rs = prep.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			Integer availability = rs.getInt("availability");
			Activity activity= new Activity (id,name,price, availability);
			act.add(activity);
		}
		rs.close();
		prep.close();
		return act;
	}

public List<Material> selectMaterialHigher(Integer hprice)throws SQLException{
	
	String sql = "SELECT * FROM material WHERE price < ?";
	List<Material> mat = new ArrayList();
	PreparedStatement prep = c.prepareStatement(sql);
	prep.setInt(1, hprice);
	ResultSet rs = prep.executeQuery();
	
	while (rs.next()) {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		int price = rs.getInt("price");
		Material material= new Material (id,name,price);
		mat.add(material);
	}
	rs.close();
	prep.close();
	return mat;
}


	
	public List<Activity> selectActivity()throws SQLException{
		Statement stmt = c.createStatement();
		String sql = "SELECT * FROM activity";
		ResultSet rs = stmt.executeQuery(sql);
		List<Activity> activities= new ArrayList();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			Integer availability = rs.getInt("availability");
		    Activity activity = new Activity(id, name,price, availability);
			activities.add(activity);
		}
		rs.close();
		stmt.close();
		return activities;
	}
	
	public Integer selectTnsC( Camper camper)throws SQLException{
		String sql="SELECT transport_id FROM camper WHERE id=?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, camper.getId());
		ResultSet rs=prep.executeQuery();
		rs.next();
		int transport_id=rs.getInt("transport_id");
		return transport_id;
	}
	
	
	public Integer selectTnsI( Instructor instructor)throws SQLException{
		String sql="SELECT transport_id FROM instructor WHERE id=?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, instructor.getId());
		ResultSet rs=prep.executeQuery();
		rs.next();
		int transport_id=rs.getInt("transport_id");
		return transport_id;
	}
	
	
	public List<Integer> selectActI( Instructor instructor)throws SQLException{
		String sql="SELECT id FROM activity WHERE instructor_id=?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, instructor.getId());
		ResultSet rs=prep.executeQuery();
		List<Integer> ids = new ArrayList();
		while(rs.next()) {
		int activity_id=rs.getInt("id");
		ids.add(activity_id);
		}
		return ids;
		
	}
	
	public Integer selectAcomI( Instructor instructor)throws SQLException{
		String sql="SELECT accomodation_id FROM instructor WHERE id=?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, instructor.getId());
		ResultSet rs=prep.executeQuery();
		rs.next();
		int accomodation_id=rs.getInt("accomodation_id");
		return accomodation_id;
	}
	
	public Integer selectAcomC( Camper camper)throws SQLException{
		String sql="SELECT accomodation_id FROM camper WHERE id=?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, camper.getId());
		ResultSet rs=prep.executeQuery();
		rs.next();
		int accomodation_id=rs.getInt("accomodation_id");
		return accomodation_id;
	}
	
	public List<String> selectInstructorfromAcc( Integer accomodation_id)throws SQLException{
		String sql="SELECT name FROM instructor WHERE accomodation_id=?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, accomodation_id);
		ResultSet rs=prep.executeQuery();
		List<String> instInAcc = new ArrayList();
		
		while (rs.next()) {
			String name = rs.getString("name");
			instInAcc.add(name);
		}
		rs.close();
		return instInAcc;

	}
	
	public List<String> selectCamperfromAcc( Integer accomodation_id)throws SQLException{
		String sql="SELECT name FROM camper WHERE accomodation_id=?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, accomodation_id);
		ResultSet rs=prep.executeQuery();

		List<String> campersInAcc = new ArrayList();
		
		while (rs.next()) {
			String name = rs.getString("name");
			campersInAcc.add(name);
		}
		rs.close();
		return campersInAcc;

	}
	public String selectNameAct(Integer id) throws SQLException {
		String sql = "SELECT name FROM activity WHERE id=?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1,id);
		ResultSet rs = prep.executeQuery();
		String name = rs.getString("name");
		return name;
	}
	
	
	public String selectNameMat(Integer id) throws SQLException {
		String sql = "SELECT name FROM material WHERE id=?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1,id);
		ResultSet rs = prep.executeQuery();
		String name = rs.getString("name");
		return name;
	}
	public List<Integer> selectMaterial(Camper camper)throws SQLException{

		String sql = "SELECT id_material FROM camper_material WHERE id_camper =?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1,camper.getId());
		ResultSet rs = prep.executeQuery();
		
		List<Integer> material = new ArrayList();
		while (rs.next()) {
			int id = rs.getInt("id_material");
			material.add(id);
		}
		rs.close();
		prep.close();
		return material;
	}
	
	public List<String> selectMaterialNames(Camper camper)throws SQLException{

		String sql = "SELECT id_material FROM camper_material WHERE id_camper =?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1,camper.getId());
		ResultSet rs = prep.executeQuery();
		
		List<String> material = new ArrayList();
		while (rs.next()) {
			int id = rs.getInt("id_material");
			material.add(selectNameMat(id));
		}
		rs.close();
		prep.close();
		return material;
	}
	
	public List<Integer> selectActivity(Camper camper)throws SQLException{

		String sql = "SELECT id_activity FROM camper_activity WHERE id_camper =?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1,camper.getId());
		ResultSet rs = prep.executeQuery();
		
		List<Integer> name = new ArrayList();
		while (rs.next()) {
			int id = rs.getInt("id_activity");
			name.add(id);
		}
		rs.close();
		prep.close();
		return name;
	}
	
	public List<String> selectActivityNames(Camper camper)throws SQLException{

		String sql = "SELECT id_activity FROM camper_activity WHERE id_camper =?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1,camper.getId());
		ResultSet rs = prep.executeQuery();
		
		List<String> name = new ArrayList();
		while (rs.next()) {
			int id = rs.getInt("id_activity");
			name.add(selectNameAct(id));
		}
		rs.close();
		prep.close();
		return name;
	}
	
	public List<Activity> selectActOfInst(Instructor ins) throws SQLException{
		String sql = "SELECT * FROM activity WHERE instructor_id =?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1,ins.getId());
		ResultSet rs = prep.executeQuery();
		
		List<Activity> act = new ArrayList();
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			Integer availability = rs.getInt("availability");
		    Activity activity = new Activity(id, name,price, availability);
			act.add(activity);
		}
		return act;
	}
	
	
	
	
	
}
