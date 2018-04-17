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
		
public void createTables(Connection c) {
	try {
		Statement stmt1 = c.createStatement();
		String accomodations = "CREATE TABLE accomodation"
				+"( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT unique,"
			    + "	name TEXT NOT NULL,"
				+"	price INTEGER NOT NULL)";
		stmt1.executeUpdate(accomodations);
		stmt1.close();
		
		Statement stmt2 = c.createStatement();
		String activities = "CREATE TABLE activity"
				+"( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT unique,"
			    + "	name TEXT NOT NULL,"
				+ " instructor_id INTEGER NOT NULL REFERENCES instructor(id),"
				+ "	price INTEGER NOT NULL)";
		stmt2.executeUpdate(activities);
		stmt2.close();
		
		Statement stmt3 = c.createStatement();
		String campers = "CREATE TABLE camper"
				+"( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT unique,"
			    + "	name TEXT NOT NULL,"
				+"	dob DATE NOT NULL,"
				+"  NIF INTEGER NOT NULL ,"
				+"	phone_number INTEGER NOT NULL,"
				+"	email TEXT NOT NULL,"
				+"	payment_method TEXT, "
				+"	transport_id INTEGER REFERENCES transport(id), "
				+"	accomodation_id INTEGER REFERENCES accomodation(id))";
				
		//falta material 
		stmt3.executeUpdate(campers);
		stmt3.close();
		
		Statement stmt4 = c.createStatement();
		String material = "CREATE TABLE material"
				+"( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT unique,"
			    + "	name TEXT NOT NULL,"
				+"	price INTEGER NOT NULL)";
		stmt4.executeUpdate(material);
		stmt4.close();
		
		Statement stmt5 = c.createStatement();
		String instructor = "CREATE TABLE instructor"
				+"( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT unique,"
			    + "	name TEXT NOT NULL,"
				+"	phone_number INTEGER NOT NULL,"
			    +"	dob DATE NOT NULL,"
				+"  NIF TEXT NOT NULL,"
				+"	nationality TEXT NOT NULL,"
			    +"	salary INTEGER NOT NULL,"
				+"  transport_id INTEGER REFERENCES transport(id),"
			    +"  accomodation_id INTEGER REFERENCES accomodation(id))";

		stmt5.executeUpdate(instructor);
		stmt5.close();
		
		Statement stmt6 = c.createStatement();
		String transport = "CREATE TABLE transport"
				+"(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT unique,"

			    + "name TEXT NOT NULL,"
			    
			    + "price INTEGER )";
		stmt6.executeUpdate(transport);
		stmt6.close();
		
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
		
		Statement stmt9 = c.createStatement();
		String material_activity = "CREATE TABLE material_activity"
				+"( id_material INTEGER NOT NULL REFERENCES material(id),"
			    + "	id_activity INTEGER REFERENCES activity(id),"
			    + "PRIMARY KEY (id_material,id_activity))";
		stmt9.executeUpdate(material_activity);
		stmt9.close();
		
	}catch (Exception e) {
		e.printStackTrace();
	}
}

public static void main(String args[])throws Exception{

	
	DbManager d =new DbManager();
	Connect c=new Connect();
	Insertion in=new Insertion(c.getConnectiondb());
	Update up = new Update(c.getConnectiondb());
	Delete del=new Delete(c.getConnectiondb());
	Selection sel = new Selection(c.getConnectiondb());
	Search ser = new Search(c.getConnectiondb());
	c.connectiondb();
	List<Material> mat = new ArrayList();
	List<Activity> activ = new ArrayList();
	LocalDate january1st2014 = LocalDate.of(2014, Month.JANUARY, 1);

	Instructor inst=new Instructor("maria",656765456,january1st2014,"234567M","american",500);
	Instructor inst2=new Instructor("raquel",616525795,january1st2014,"9999999M","Spanish",700);

	
// no se pasa inst se pasa id
	Activity a = new Activity ("natacion",300,inst,null,null);
	Activity a2 = new Activity( "patinaje", 400,inst,null,null);
	activ.add(a);
	
	Accomodation ac= new Accomodation("hotel",300);
	Accomodation ac2 = new Accomodation("camping",800);
	
	Transport t = new Transport("plane",600);
	Transport t2 = new Transport("train",100);
	
	Material m=new Material(1,"row",100);
	Material m2=new Material(2,"board",200);
    mat.add(m);
    mat.add(m2);
	
	//d.createTables(c.getConnectiondb());
	in.insertActivity(a);
	in.insertActivity(a2);
	in.insertAccomodation( ac);
	in.insertAccomodation( ac2);
    in.insertTransport( t2);
    in.insertTransport(t);
	in.insertInstructor( inst);
	in.insertInstructor( inst2);
	

	m = in.insertMaterial( m);
	m2 = in.insertMaterial( m2);
	
    Camper c1=new Camper("Lucia",january1st2014,"567483985g",567654567,"lucia_arce96@hotmail.com","credit card",t2,ac,mat,activ);
   	Camper c2=new Camper("Maria",january1st2014,"567483985g",567654567,"lucia_arce96@hotmail.com","credit card",t2,ac2,mat,activ);
   	
	c1 = in.insertCamper( c1);
	c2 = in.insertCamper( c2);
	
	
	in.insertCamper_material( c1, m);
	in.insertCamper_material( c2, m2);
	in.insertCamper_activity( c1, a);
	in.insertCamper_activity( c2, a2);
	in.insertMaterial_activity( m, a);
	sel.selectTnsC( c1);
	JPAconnect em=new JPAconnect();
	JPARead jpa = new JPARead(em.getEntityManager());
	jpa.ReadMat_Camp(c1);
	
	


}

		
}