package database;

import database.pojo.*;

import java.sql.*;

public class Drop {
		
		//public static void main(String args[]) {
			//try {
			
				
				public void dropCampers(Connection c, Camper camper) throws SQLException {
				Statement stmt1 = c.createStatement();
				String d1 = "DROP TABLE campers";
				stmt1.executeUpdate(d1);
				stmt1.close();
				}
				
				public void dropInstructors(Connection c, Instructor instructor) throws SQLException {
				Statement stmt2 = c.createStatement();
				String d2 = "DROP TABLE instructors";
				stmt2.executeUpdate(d2);
				stmt2.close();
				}
				
				public void dropTransport(Connection c, Transport transport) throws SQLException {
				Statement stmt3 = c.createStatement();
				String d3 = "DROP TABLE transport";
				stmt3.executeUpdate(d3);
				stmt3.close();
				}
				
				public void dropMaterial(Connection c, Material material) throws SQLException {
				Statement stmt4 = c.createStatement();
				String d4 = "DROP TABLE material";
				stmt4.executeUpdate(d4);
				stmt4.close();
				}
				
				public void dropAccomodation(Connection c, Accomodation accomodation) throws SQLException {
				Statement stmt5 = c.createStatement();
				String d5 = "DROP TABLE accomodation";
				stmt5.executeUpdate(d5);
				stmt5.close();
				}
				
				public void dropActivities(Connection c, Activity activity) throws SQLException {
				Statement stmt6 = c.createStatement();
				String d6 = "DROP TABLE activities";
				stmt6.executeUpdate(d6);
				stmt6.close();
				}		
			
		}
	


