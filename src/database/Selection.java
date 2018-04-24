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
	
	public void selectCamper () throws SQLException{
		Statement stmt = c.createStatement();
		String sql = "SELECT * FROM camper";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			LocalDate dob = rs.getDate("dob").toLocalDate();
			String NIF=rs.getString("NIF");
			int phonenumber=rs.getInt("phone_number");
			String email=rs.getString("email");
			String payment_method=rs.getString("payment_method");
			Camper camper = new Camper (id,name,dob,NIF,phonenumber,email,payment_method);
			System.out.println(camper);
		}
		rs.close();
		stmt.close();

	}
	
	
	public void selectInstructor() throws SQLException{
		Statement stmt = c.createStatement();
		String sql = "SELECT * FROM instructor";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int phone_number=rs.getInt("phone_number");
			LocalDate dof = rs.getDate("dob").toLocalDate();
			String NIF=rs.getString("NIF");
			String nacionality=rs.getString("nationality");
			int salary = rs.getInt("salary");
			Instructor instructor = new Instructor (id,name,phone_number,dof,NIF,nacionality,salary);
			System.out.println(instructor);
		}
		rs.close();
		stmt.close();
		
	}
	
	public void selectMaterial ()throws SQLException{
		Statement stmt = c.createStatement();
		String sql = "SELECT * FROM material";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			Material mat = new Material (id,name,price);
			System.out.println(mat);
			
		}
		rs.close();
		stmt.close();
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
			System.out.println(trans);
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
	
	public void selectActivity()throws SQLException{
		Statement stmt = c.createStatement();
		String sql = "SELECT * FROM activity";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			Activity activity = new Activity (id,name,price);
			System.out.println(activity);
		}
		rs.close();
		stmt.close();
	}
	
	public void selectTnsC( Camper camper)throws SQLException{
		String sql="SELECT transport_id FROM camper WHERE id=?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, camper.getId());
		ResultSet rs=prep.executeQuery();
		rs.next();
		int transport_id=rs.getInt("transport_id");
		System.out.println(transport_id);
	}
	
	
	
	
}
