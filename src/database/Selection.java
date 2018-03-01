package database;
import database.*;
import java.sql.Connection;
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
	}
	
	public void selectTransport(Connection c)throws SQLException{
		Statement stmt = c.createStatement();
		String sql = "SELECT * FROM transport";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("type_transport");
			int price = rs.getInt("price");
			Transport trans = new Transport (name,price);
			System.out.println(trans);
			
		}
	}
}
