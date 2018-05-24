package database;


import java.sql.Connection;
import java.sql.DriverManager;

import database.menu.ConnectInterface;



public class Connect implements ConnectInterface {

	Connection c;
	public Connect() throws Exception {
		this.connectiondb();
		
	}
	

	public void connectiondb() throws Exception {
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:./db/Surfcamp.db");
		c.createStatement().execute("PRAGMA foreign_keys=ON");
		
		}
	
	public Connection getConnectiondb() {
		return c;
	}
	public void closeconnection() throws Exception{
		try {
		c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	}
	


