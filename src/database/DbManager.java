package database;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;

import database.pojo.Camper;
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
				+"	price INTEGER NOT NULL)";
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
				+"	accomodation_id INTEGER REFERENCES accomodation(id),"
				+"	activity_id INTEGER REFERENCES activity(id))";
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
				+"	activity_ID INTEGER ,"
				+ "	FOREIGN KEY (activity_ID) REFERENCES activity(id))";

		stmt5.executeUpdate(instructor);
		stmt5.close();
		
		Statement stmt6 = c.createStatement();
		String transport = "CREATE TABLE transport"
				+"( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT unique,"

			    + "	name TEXT NOT NULL,"
			    
			    + "price INTEGER )";
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
		
		Statement stmt9 = c.createStatement();
		String material_activity = "CREATE TABLE material_activity"
				+"( id_material INTEGER NOT NULL REFERENCES material(id),"
			    + "	id_activity INTEGER REFERENCES activities(id),"
			    + "PRIMARY KEY (id_material,id_activity))";
		stmt9.executeUpdate(material_activity);
		stmt9.close();
		
	}catch (Exception e) {
		e.printStackTrace();
	}
}
public static void main(String args[])throws ClassNotFoundException, SQLException {
	
	DbManager d=new DbManager();
	Insertion in=new Insertion();
	Update up = new Update();
	Connect c=new Connect();
	c.connectiondb();
	LocalDate january1st2014 = LocalDate.of(2014, Month.JANUARY, 1);
	


	Activity a = new Activity ("natacion",300,null,null);
	Activity a2 = new Activity(3, "patinaje", 400,null,null);



	Accomodation ac= new Accomodation(1,"hotel",300);
	List <Instructor> ins= new ArrayList<Instructor>();
	Transport t = new Transport("avion",ins,null,null);
	System.out.println(t);
	Instructor i= new Instructor(1,"maria",676767,january1st2014,"american",400,a,t);

	System.out.println(t);
	ins.add(i);
	Material m = new Material(1,"tabla",400);
	List<Material> mat = new ArrayList<Material>();
	mat.add(m);
	List<Activity> act = new ArrayList<Activity>();
	act.add(a);
	act.add(a2);
	System.out.println(m);
	Camper c = new Camper (1,"jorge",january1st2014 ,"55555",2222222,"mamamam","hshhahahahah",t,ac,mat,act);
	a.addCamper(c);
	System.out.println(c);
	System.out.println(i);
	a.removeCamper(c);
	Material l = new Material("paddletabla",700);
	c.addMaterial(l);
	System.out.println(c);
	System.out.println(i);


	Activity a=new Activity("natacion", 100);
	Activity b=new Activity("surf",200);

	Accomodation ac= new Accomodation("hotel",300);

	Accomodation bc= new Accomodation("Camping",100);
	Transport t =new Transport("plane",200);
	Transport t2 = new Transport("train",100);
	Instructor i=new Instructor("maria",656765456,january1st2014,"american",500);
	Material m=new Material("row",100);
	Material m2=new Material("board",200);
	Camper c1=new Camper("Lucia",january1st2014,"567483985g",567654567,"lucia_arce96@hotmail.com","credit card");



	List <Instructor> ins= new ArrayList<Instructor>();
	List <Camper> campers = new ArrayList<Camper>();
	Transport t = new Transport("avion",500,null,null);
	in.insertTransport(c.getConnection(), t);
	Instructor inst=new Instructor("maria",656765456,january1st2014,"234567M","american",500,a,t);

	
	Camper c1=new Camper("Lucia",january1st2014,"567483985g",567654567,"lucia_arce96@hotmail.com","credit card");
	Camper c2=new Camper("Maria",january1st2014,"567483985g",567654567,"lucia_arce96@hotmail.com","credit card");
	campers.add(c1);
	campers.add(c2);

	Activity act=new Activity("natacion", 100,campers,null);
	Activity b=new Activity("surf",200);
	Accomodation bc= new Accomodation("Camping",100,campers,ins);
	Transport tr =new Transport("plane",200,campers,ins);
	System.out.println(tr);
	Transport t2 = new Transport("train",100);


	Material m=new Material(1,"row",100);
	Material m2=new Material(2,"board",200);
	

	/*d.createTables(c.getConnection());

	d.createTables(c.getConnection());
	in.insertActivity(c.getConnection(), a);
	in.insertActivity(c.getConnection(), b);
	in.insertAccomodation(c.getConnection(), ac);
	in.insertAccomodation(c.getConnection(), bc);
	in.insertInstructor(c.getConnection(), i);
	in.insertCamper(c.getConnection(), c1);
	in.insertTransport(c.getConnection(), t);
	in.insertTransport(c.getConnection(), t2);
	in.insertMaterial(c.getConnection(), m);
	in.insertMaterial(c.getConnection(), m2);
<<<<<<< HEAD
	

=======
	*/
	 Selection s = new Selection();
	 s.selectCamper(c.getConnection());
	 s.selectInstructor(c.getConnection());
	 s.selectMaterial(c.getConnection());
	 s.selectTransport(c.getConnection());
	 s.selectAccomodation(c.getConnection());
	 s.selectActivity(c.getConnection());
	 
	 up.UpdateMaterial(c.getConnection(), 1, "pala", 600);
	 s.selectMaterial(c.getConnection());
	 Search ser = new Search ();
	 ser.SearchCamper(c.getConnection(), "567483985g");
	 
	 
	
>>>>>>> branch 'master' of https://github.com/mariavillalba22/SurfCamp
	
}

		
}
