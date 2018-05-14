package database;

import database.pojo.*;

import java.sql.*;

public class Drop {
		
	Connection c;
	public Drop(Connection c) {
		this.c=c;
	}
			
				
				public void dropCampers() throws SQLException {
				Statement stmt1 = c.createStatement();
				String d1 = "DROP TABLE camper";
				stmt1.executeUpdate(d1);
				stmt1.close();
				}
				
				public void dropInstructors() throws SQLException {
				Statement stmt2 = c.createStatement();
				String d2 = "DROP TABLE instructor";
				stmt2.executeUpdate(d2);
				stmt2.close();
				}
				
				public void dropTransport() throws SQLException {
				Statement stmt3 = c.createStatement();
				String d3 = "DROP TABLE transport";
				stmt3.executeUpdate(d3);
				stmt3.close();
				}
				
				public void dropMaterial() throws SQLException {
				Statement stmt4 = c.createStatement();
				String d4 = "DROP TABLE material";
				stmt4.executeUpdate(d4);
				stmt4.close();
				}
				
				public void dropAccomodation() throws SQLException {
				Statement stmt5 = c.createStatement();
				String d5 = "DROP TABLE accomodation";
				stmt5.executeUpdate(d5);
				stmt5.close();
				}
				
				public void dropActivities() throws SQLException {
				Statement stmt6 = c.createStatement();
				String d6 = "DROP TABLE activity";
				stmt6.executeUpdate(d6);
				stmt6.close();
				}		
			
		}
	


