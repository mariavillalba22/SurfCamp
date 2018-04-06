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

	public Selection (){
		
	}
	
	public void selectCamper (Connection c ) throws SQLException{
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
	
	
	public void selectInstructor(Connection c) throws SQLException{
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
			//estamos print el tranport , necesitamos o no printearlo o ponerle null.
		}
		rs.close();
		stmt.close();
		
	}
	
	public void selectMaterial (Connection c)throws SQLException{
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
	public void selectTransport(Connection c)throws SQLException{
		Statement stmt = c.createStatement();
		String sql = "SELECT * FROM transport";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			Transport trans = new Transport (id,name,price);
			System.out.println(trans);
		}
		rs.close();
		stmt.close();
	}
	
	public void selectAccomodation(Connection c)throws SQLException{
		Statement stmt = c.createStatement();
		String sql = "SELECT * FROM accomodation";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			Accomodation accomodation = new Accomodation (id,name,price);
			System.out.println(accomodation);
		}
		rs.close();
		stmt.close();
	}
	
	public void selectActivity(Connection c)throws SQLException{
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
	
	public void selectTnsC(Connection c, Camper camper)throws SQLException{
		String sql="SELECT transport_id FROM camper WHERE id=?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, camper.getId());
		ResultSet rs=prep.executeQuery();
		rs.next();
		int transport_id=rs.getInt("transport_id");
		System.out.println(transport_id);
	}
	
	public ArrayList<Integer> selectMaterialC(Connection c, Camper camper)throws SQLException{
		String sql="SELECT id_material FROM camper_material WHERE id_camper=?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, camper.getId());
		ResultSet rs=prep.executeQuery();
		ArrayList<Integer> material = new ArrayList();
		while(rs.next()) {
		int material_id=rs.getInt("id_material");
		material.add(material_id);
		}
		return material;
	}
	
	
}
