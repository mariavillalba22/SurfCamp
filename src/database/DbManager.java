package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbManager {
	public static void main(String args[]) {
	try {
		Class.forName("org.sqlite.JDBC");
		Connection c = DriverManager.getConnection("jdbc:sqlite:./db/Surfcamp.db");
		c.createStatement().execute("PRAGMA foreign_keys=ON");
		System.out.println("Database connection opened.");
		String accomodations = "CREATE TABLE accomodation"
				+"( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT unique,"
			    + "	accomodations TEXT NOT NULL,"
				+"		price INTEGER NOT NULL)";
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
}
