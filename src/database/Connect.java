package database;

import java.io.Serializable;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
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
	


