package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {
		Connection c;
		public DbManager() {
			
		}
		public void connectiondb() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:./db/Surfcamp.db");
		c.createStatement().execute("PRAGMA foreign_keys=ON");
		System.out.println("Database connection opened.");
		}
public void createTables() {
	try {
		Statement stmt1 = c.createStatement();
		String accomodations = "CREATE TABLE accomodation"
				+"( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT unique,"
			    + "	accomodations TEXT NOT NULL,"
				+"		price INTEGER NOT NULL)";
		stmt1.executeUpdate(accomodations);
		stmt1.close();
		
		Statement stmt2 = c.createStatement();
		String activities = "CREATE TABLE activities"
				+"( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT unique,"
			    + "	activity TEXT NOT NULL,"
				+"	price INTEGER NOT NULL)";
		stmt2.executeUpdate(activities);
		stmt2.close();
		
		Statement stmt3 = c.createStatement();
		String campers = "CREATE TABLE campers"
				+"( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT unique,"
			    + "	name TEXT NOT NULL,"
				+"	dateofb DATE NOT NULL,"
				+"  NIF INTEGER NOT NULL ,"
				+"	phone_number INTEGER NOT NULL,"
				+"	email TEXT NOT NULL,"
				+"	payment_method TEXT, "
				+"	transportid INTEGER, "
				+"	accomodationid INTEGER,"
				+"	activityid INTEGER)";
		stmt3.executeUpdate(campers);
		stmt3.close();
		
		Statement stmt4 = c.createStatement();
		String material = "CREATE TABLE material"
				+"( id INTEGER NOT NULL,"
			    + "	materials TEXT NOT NULL,"
				+"	price INTEGER NOT NULL)";
		stmt4.executeUpdate(material);
		stmt4.close();
		
		Statement stmt5 = c.createStatement();
		String monitors = "CREATE TABLE monitors"
				+"( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT unique,"
			    + "	name TEXT NOT NULL,"
				+"	phone_number INTEGER NOT NULL,"
			    +"	age INTEGER,"
				+"	nacionalitty TEXT NOT NULL,"
			    +"	salary INTEGER NOT NULL,"
				+"	activityid INTEGER NOT NULL)";
		stmt5.executeUpdate(monitors);
		stmt5.close();
		
		Statement stmt6 = c.createStatement();
		String transport = "CREATE TABLE transport"
				+"( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT unique,"
			    + "	wayoftransport TEXT NOT NULL)";
		stmt6.executeUpdate(transport);
		stmt6.close();
		
		Statement stmt7 = c.createStatement();
		String camper_material = "CREATE TABLE camper_material"
				+"( id_camper INTEGER NOT NULL REFERENCES campers(id),"
				+ "id_material INTEGER REFERENCES material(id),"
			    + "	PRIMARY KEY (id_camper,id_material))";
		stmt7.executeUpdate(camper_material);
		stmt7.close();
		
		Statement stmt8 = c.createStatement();
		String camper_activity = "CREATE TABLE camper_activity"
				+"( id_camper INTEGER NOT NULL REFERENCES camper(id),"
			    + "	id_activity INTEGER REFERENCES activities(id),"
			    + "PRIMARY KEY (id_camper,id_activity))";
		stmt8.executeUpdate(camper_activity);
		stmt8.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
}
public static void main(String args[])throws ClassNotFoundException, SQLException {
	
	DbManager d=new DbManager();
	d.connectiondb();
	d.createTables();
	
	
}

		
}
