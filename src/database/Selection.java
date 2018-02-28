package database;
import database.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;
import database.*;

import database.pojo.Camper;
import database.pojo.Instructor;

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
	
}
