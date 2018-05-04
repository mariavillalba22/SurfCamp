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
			Camper camper = new Camper (id,name,dob,NIF,phonenumber,email,payment_method);
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
			Transport trans = new Transport (id,name,price);
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
			Accomodation acomodation= new Accomodation (id,name,price);
			acom.add(acomodation);
		}
		rs.close();
		stmt.close();
		return acom;
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
			Activity activity = new Activity (id,name,price);
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
	
	public String selectNameMat(Integer id) throws SQLException {
		String sql = "SELECT name FROM material WHERE id=?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1,id);
		ResultSet rs = prep.executeQuery();
		String name = rs.getString("name");
		return name;
	}
	public List<String> selectMaterialNames(Camper camper)throws SQLException{

		String sql = "SELECT id_material FROM camper_material WHERE id_camper =?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1,camper.getId());
		ResultSet rs = prep.executeQuery();
		
		List<String> materialname = new ArrayList();
		while (rs.next()) {
			int id = rs.getInt("id_material");
			materialname.add(selectNameMat(id));
		}
		rs.close();
		prep.close();
		return materialname;
	}
	
	
	
	
	
	
	
}
