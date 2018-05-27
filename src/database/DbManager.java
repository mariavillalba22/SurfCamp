package database;
import java.util.*;

import javax.persistence.EntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;

import database.pojo.Camper;
import database.JPA.*;
import database.pojo.*;
public class DbManager {
	
		public DbManager() {
		}
		
public void createTables(Connection c) throws SQLException{
	
		Statement stmtSeq ;
		String sqlSeq;
		
		Statement stmt1 = c.createStatement();
		String accomodations = "CREATE TABLE accomodation"
				+"( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
			    + "	name TEXT NOT NULL,"
			    + " availability INTEGER NOT NULL,"
				+"	price INTEGER NOT NULL)";
		stmt1.executeUpdate(accomodations);
		stmt1.close();
		
		stmtSeq = c.createStatement();
		sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('accomodation', 1)";
		stmtSeq.executeUpdate(sqlSeq);
		
		Statement stmt2 = c.createStatement();
		String activities = "CREATE TABLE activity"
				+"( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
			    + "	name TEXT NOT NULL,"
			    + " availability INTEGER NOT NULL,"
				+ " instructor_id INTEGER REFERENCES instructor(id) ON DELETE SET NULL,"
				+ "	price INTEGER NOT NULL)";
		stmt2.executeUpdate(activities);
		stmt2.close();
		
		stmtSeq = c.createStatement();
        sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('activity', 1)";
		stmtSeq.executeUpdate(sqlSeq);
		
		Statement stmt3 = c.createStatement();
		String campers = "CREATE TABLE camper"
				+"( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
			    + "	name TEXT NOT NULL,"
				+"	dob DATE ," 
				+"  NIF INTEGER NOT NULL ,"
				+"	phone_number INTEGER ,"
				+"	email TEXT ,"
				+"	payment_method TEXT,"
				+"  needtopay INTEGER NOT NULL, "
				+"	transport_id INTEGER REFERENCES transport(id) ON DELETE SET NULL, "
				+"	accomodation_id INTEGER REFERENCES accomodation(id) ON DELETE SET NULL)";
		stmt3.executeUpdate(campers);
		stmt3.close();
		
		stmtSeq = c.createStatement();
        sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('camper', 1)";
		stmtSeq.executeUpdate(sqlSeq);;
		
		Statement stmt4 = c.createStatement();
		String material = "CREATE TABLE material"
				+"( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
			    + "	name TEXT NOT NULL,"
				+"	price INTEGER NOT NULL)";
		stmt4.executeUpdate(material);
		stmt4.close();
		
		stmtSeq = c.createStatement();
		sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('material', 1)";
		stmtSeq.executeUpdate(sqlSeq);
		
		Statement stmt5 = c.createStatement();
		String instructor = "CREATE TABLE instructor"
				+"( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
			    + "	name TEXT NOT NULL,"
				+"	phone_number INTEGER NOT NULL,"
			    +"	dob DATE NOT NULL," 
				+"  NIF TEXT NOT NULL,"
				+"	nationality TEXT NOT NULL,"
			    +"	salary INTEGER NOT NULL,"
				+"  transport_id INTEGER REFERENCES transport(id) ON DELETE SET NULL,"
			    +"  accomodation_id INTEGER REFERENCES accomodation(id) ON DELETE SET NULL)";

		stmt5.executeUpdate(instructor);
		stmt5.close();
		
		stmtSeq = c.createStatement();
		sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('instructor', 1)";
		stmtSeq.executeUpdate(sqlSeq);
		
		Statement stmt6 = c.createStatement();
		String transport = "CREATE TABLE transport"
				+"(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
			    + "name TEXT NOT NULL,"
			    + "availability INTEGER NOT NULL,"
			    + "price INTEGER NOT NULL )";
		stmt6.executeUpdate(transport);
		stmt6.close();
		
		stmtSeq = c.createStatement();
	    sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('transport', 1)";
		stmtSeq.executeUpdate(sqlSeq);
		
		Statement stmt7 = c.createStatement();
		String camper_material = "CREATE TABLE camper_material"
				+"(id_camper INTEGER NOT NULL REFERENCES camper(id),"
				+ "id_material INTEGER REFERENCES material(id),"
			    + "	PRIMARY KEY (id_camper,id_material))";
		stmt7.executeUpdate(camper_material);
		stmt7.close();
		
		Statement stmt8 = c.createStatement();
		String camper_activity = "CREATE TABLE camper_activity"
				+"( id_camper INTEGER NOT NULL REFERENCES camper(id),"
			    + "	id_activity INTEGER REFERENCES activity(id),"
			    + "PRIMARY KEY (id_camper,id_activity))";
		stmt8.executeUpdate(camper_activity);
		stmt8.close();
		
	
}


}