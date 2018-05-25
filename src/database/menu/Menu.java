package database.menu;

import java.io.*;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

import database.*;
import database.JPA.*;
import database.XML.XMLdb;
import database.XML.XMLmanager;
import database.pojo.*;

public class Menu {
	
	private static final String NULL = null;
	static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	static Boolean h;
	
	public static void main(String[] args) throws Exception {
    	
		
		List <Camper> campers = new ArrayList();
		List<Transport> transports = new ArrayList();
		List<Accomodation> accomodations = new ArrayList();
		List<Instructor>  instructors = new ArrayList();
		List<Activity> activities = new ArrayList ();
		List<Material> materials = new ArrayList();
		
    	Integer optionNumber  = 0;
    	JPAconnect em=new JPAconnect();
    	em.connectiondb();
   
    	String readString ;
    	DbManager d =new DbManager();

    	
    	Connect c=new Connect();
    	c.connectiondb();
    	
    	try {
    		d.createTables(c.getConnectiondb());
    		System.out.println("\n\nTables have been created succesfully.");
    	}catch(SQLException ex) {
    		System.out.println("\n\nTables are already created.");
    	}
    	
    	Insertion in=new Insertion(c.getConnectiondb());
    	Update up = new Update(c.getConnectiondb());
    	Delete del=new Delete(c.getConnectiondb());
    	Selection sel = new Selection(c.getConnectiondb());
    	Search ser = new Search(c.getConnectiondb());
    	
    	JPADelete delete = new JPADelete(em.getEntityManager());
    	JPACreate create = new JPACreate(em.getEntityManager());
    JPAUpdate update = new JPAUpdate(em.getEntityManager());
    JPARead read = new JPARead(em.getEntityManager());
    
    XMLmanager xmlm = new XMLmanager();
    
    	do {
    		Camper camper1 = new Camper();
    		Transport transport1 = new Transport();
    		Accomodation accomodation1 =new Accomodation();
    		Activity activity1=new Activity();
    		Material material1= new Material();
    		Instructor instructor1=new Instructor();
        try {

			System.out.println("\n ____________________________________________________\n");
            System.out.println("SELECT AN OPTION: \n"
                    + "1) VIEW\n"
                    + "2) INSERT\n" // a partir de aqui hay q comprobar si hay algo
                    + "3) MODIFY\n"
                    + "4) DELETE\n"
                    + "5) WORK WITH XML\n"
                    + "6) EXIT");
			System.out.println("____________________________________________________");
            
            do {
             	System.out.println("Option number[1-6]: ");
			 	readString = console.readLine();
		        optionNumber = Integer.parseInt(readString);
			} while (optionNumber < 1 || optionNumber > 6);

            switch (optionNumber) {
	
                case 1: {// VIEW
                    System.out.println("WHAT WOULD YOU LIKE TO SEE: "
                            + "\n1) Campers\t"
                            + "\n2) Transport\t" // a partir de aqui hay q comprobar si hay algo
                            + "\n3) Accomodation\t"
                            + "\n4) Activities\t"
                            + "\n5) Material\t"
                            + "\n6) Instructor\t"
                            + ""
                            + "\nOption number:\t ");

                    readString = console.readLine();
                    int optionNumberView = Integer.parseInt(readString);
                    switch (optionNumberView) {
                        case 1:{ //Mostrar campers
                        	campers=sel.selectCamper();
                        	if(campers.isEmpty()) {
                        		System.out.println("There are any camper register.\n");
                        	}else {
                        	System.out.println("SELECT ONE OF THE FOLLOWING OPTIONS: "
                                    + "\n1) List all campers (Full view)\t"
                                    + "\n2) List all campers names\t"
                                   
                                    + "\nOption number: \t");
                        	
                        	readString = console.readLine();
                        	int optnum = Integer.parseInt(readString);
                        	
                        	
                        	switch (optnum) {
                        	
                        	case 1:{
                            		for (Camper camper : campers) {
                            			System.out.println(camper);
                            			Transport transport = ser.searchTransport(sel.selectTnsC(camper));
                            			accomodation1 = ser.searchAccomodation(sel.selectAcomC(camper));
                            			System.out.println("The transport for camper "+camper.getId()+" is "+ transport.getType_transport()+""
                            					+ "\nThe accomodation is "+accomodation1.getAccomodation());
                            		   
                            			List<String> x = new ArrayList();
                            			x= sel.selectMaterialNames(camper);
                                         for(String s :x) {
                                        	System.out.println("The material for this camper is " +s); 
                                       
                                         }
                                         
                                     x = sel.selectActivityNames(camper);
                                     for(String s :x) {
                                     	System.out.println("The activity for this camper is " +s); 
                                      } 
                                   

									}
	
                        		}break;//case 1 full view campers
                            	
                        	case 2:{
                        		List<String>campNames=new ArrayList();
                        		campNames=sel.selectCamperName();
                        		for(String camperNames: campNames) {
                        		System.out.println(camperNames);
                        		}
                        		
                            
                        		}break; //case 2 short view campers 	
                        	
                        	 } //Switch opciones de visualizado de campers
                        	
                    }}break; //CASE 1 VIEW CAMPERS
               
                        case 2:{ //Mostrar transporte
                        	transports = sel.selectTransport();
                        	if(transports.isEmpty()) {
                        		System.out.println("There are any transport.");
                        	}else {
                        	
                        	System.out.println("SELECT ONE OF THE FOLLOWING OPTIONS: "
                                    + "\n1) List all transports (Full view)\t"
                                    + "\n2) List all transports available\t"
                                    + "\n3) List all transports under a specific price"
                                    + "\nOption number: \t");
                        	
                        	readString = console.readLine();
                        	int optnum2 = Integer.parseInt(readString);
                        	
                        	
                        	switch (optnum2) {
                        	
                        	case 1:{
                        		//Here we use JPA instead of JDBC to show that it works
                        		transports = read.ReadTransports();
                        		for (Transport transport : transports) {
                        			System.out.println(transport);
                        			
                        		}
                        		
                            	}break; //case 1 view full transports
                            	
                            	
                        	case 2:{
                        		for(Transport transport: transports) {
                        			if(transport.checkAvailability()) {
                        				System.out.println(transport);
                        			}
                        		}
                        		}break;
                            	
                            case 3:{
                            	
                            	System.out.println("Insert a maximum price:\t");
                            	readString = console.readLine();
                            	int priceComp = Integer.parseInt(readString);
                            	transports=sel.selectTransport();
                            
                    				}break;	
                    				
                    			}//switch opciones de view transport
                        	
                        	
                        	}}break;//case 2 view transport
                        	
                            

                        case 3:{ //Mostrar acomodation
                        	accomodations=sel.selectAccomodation();
                        	if(accomodations.isEmpty()){
                        		System.out.println("There are any accomodations.");
                        	}else {
                        	System.out.println("SELECT ONE OF THE FOLLOWING OPTIONS: "
                                    + "\n1) List all accomodation (Full view)\t"
                                    + "\n2) List all accomodation available\t"
                                    + "\n3) List all accomodation under a specific price"
                                    + "\n4) List all campers and instructors accomodated in a specific place"
                                    + "\nOption number: \t");
                        	
                        	readString = console.readLine();
                        	int optnum3 = Integer.parseInt(readString);
                        	
                        	
                        	switch (optnum3) {
                        	
                        	case 1:{
                        		
                        		for (Accomodation accomodation : accomodations) {
                        			System.out.println(accomodation);
                        		}
                        		
                        	}break;// case 1 accomodation full view
                            	
                        	case 2:{
                        		
                        		for(Accomodation accomodation : accomodations) {
                        			if(accomodation.checkAvailability()) {
                        				System.out.println(accomodation);
                        			}
                        		}
                        		
                        	}break;// case 2 availability
                            	
                            case 3:{
                            	
                            	System.out.println("Insert a maximum price:\t");
                            	readString = console.readLine();
                            	int priceComp = Integer.parseInt(readString);
                            	accomodations=sel.selectAccomodationHigher(priceComp);
                            	for(Accomodation accomodation: accomodations) {
                            		System.out.println(accomodation);
                            	}
                            	
                            	
                            }break;	//case 3 view accomodation price
                            case 4:{
                            	
                           
                            	for (Accomodation accomodation : accomodations) {
                        			System.out.println(accomodation);
                            	 }
                            	
                            	System.out.println("Insert accomodation id:\t");
                            	readString = console.readLine();
                            	int acc_id = Integer.parseInt(readString);
                            	accomodation1 = ser.searchAccomodation(acc_id);
                            	List<String>x= new ArrayList();
                            	x=sel.selectCamperfromAcc(acc_id);
                            	System.out.println("This are the campers staying in the "+ accomodation1.getAccomodation());
                            	for(String cNA : x) {
                            		System.out.println(cNA);
                            	}
                            	x = sel.selectInstructorfromAcc(acc_id);
                            	System.out.println("This are the instructors staying in the "+accomodation1.getAccomodation());
                            	for(String cNA : x ) {
                            		System.out.println(cNA);
                            	}
	
                            	
                        	}break;//case 4 mostrar el precio de una acomodacion introducida
                        	
                        	}//switch opciones view accomodation
                        	
                }}break;//case 3 view accomodation
                        	
                        	
                            

                        case 4:{ //mostrar activities
                        	activities=sel.selectActivity();
                        	if(activities.isEmpty()) {
                        		System.out.println("There are any activity available.");
                        	}else {
                        	System.out.println("SELECT ONE OF THE FOLLOWING OPTIONS: "
                                    + "\n1) List all activities (Full view)\t"
                                    + "\n2) List all activities available\t"
                                    + "\n3) List all activities under a specific price"
                                    + "\nOption number: \t");
                        	
                        	readString = console.readLine();
                        	int optnum4 = Integer.parseInt(readString);
                        	
                        	
                        	switch (optnum4) {
                        	
                        	case 1:{
                        		
                        		for (Activity activity : activities) {
                        			System.out.println(activity);
                        		}
                        		
                        	}break;//case 1 listar full view actividades
                            	
                        	case 2:{
                        		for (Activity activity: activities) {
                        			if(activity.checkAvailability()) {
                        				System.out.println(activity);
                        			}
                        		}
                        	}break;
                            	
                            case 3:{
                            	
                            	System.out.println("Insert a maximum price:\t");
                            	readString = console.readLine();
                            	int priceComp = Integer.parseInt(readString);
                            	activities=sel.selectActivityHigher(priceComp);
                            	for (Activity activity : activities) {
                        			System.out.println(activity);
                        		}
                            	//PROBARLO

                        	}break;//case 3 mostrar actividad por precio
                        	
                        	}//switch de las 4 opciones
                        }}break;//case 4 mostrar actividades

                        case 5:{ //mostrar material;
                        	
                        	System.out.println("SELECT ONE OF THE FOLLOWING OPTIONS: "
                                    + "\n1) List all Material (Full view)\t"
                                    + "\n2) List a Material\t"
                                    + "\n3) List all Material under a specific price"
                                    + "\nOption number: \t");
                        	
                        	readString = console.readLine();
                        	int optnum5 = Integer.parseInt(readString);
                        	
                        	
                        	switch (optnum5) {
                        	
                        	case 1:{
                        		materials=sel.selectMaterial();
                        		for (Material material : materials) {
                        			System.out.println(material);
                        		}
                        		
                        		
                        	}break;//case 1 view full materials
                            	
                        	case 2:{
                        		System.out.println("This are the materials: ");
                        		materials=sel.selectMaterial();
                        		for(Material material: materials) {
                        			System.out.println(material.getMaterial());
                        		}
                        		System.out.println("Introduce the name of the material you want to see: ");
                        		readString = console.readLine();
                        		System.out.println(material1);
                        		
                        		
                        		
                        		
                        		
                        		
                        	}break;//case 2 listar nombres
                            	
                            case 3:{
                            	
                            	System.out.println("Insert a maximum price:\t");
                            	readString = console.readLine();
                            	int priceComp = Integer.parseInt(readString);
                            	materials=sel.selectMaterialHigher(priceComp);
                            	for(Material material: materials) {
                            		System.out.println(material);
                            	}
                            	
                            	}break;// case 3 listar por precio
                        	
                        	}//switch opciones material
                            
                }break;
                        case 6:{ //mostrar instructors
                        	
                        	System.out.println("SELECT ONE OF THE FOLLOWING OPTIONS: "
                                    + "\n1) List all instructors (Full view)\t"
                                    + "\n2) List all instructors names\t"
                                    + "\nOption number: \t");
                        	
                        	readString = console.readLine();
                        	int optnum6 = Integer.parseInt(readString);
                        	
                        	
                        	switch (optnum6) {
                        	
                        	case 1:{
                        		instructors=sel.selectInstructor();
                        		
                        		for (Instructor instructor : instructors) {
                        			System.out.println(instructor);
                            transport1 = ser.searchTransport(sel.selectTnsI(instructor));
                         	accomodation1 = ser.searchAccomodation(sel.selectAcomI(instructor));
                        	System.out.println("The transport for instructor "+instructor.getId()+" is "+ transport1.getType_transport()+""
                        			+ "\nThe accomodation is "+accomodation1.getAccomodation());
                        	activities = sel.selectActOfInst(instructor);
                        	for(Activity act: activities) {
                        		System.out.println(act.getActivity());
                        	}
                        		   
                        		}
                        	}break; //case 1 long instructor
                        			
                            	
                        	case 2:{
                        		instructors=sel.selectInstructor();
                        		for(Instructor instructor : instructors) {
                        			System.out.println(instructor.getName());
                        		}
                        		}break;//case 2 instructor names

                        	}//switch optnum6
                        	
                        	
                            }break; // case 6 view instructor
                    

                }//SWITCH OPCIONES VIEW: CAMPERS, TRANSPORT.......
              
             }break;//CASE 1 VIEW
                
//*******************************insert**************************************************		
                case 2: { //INSERT

                    System.out.println("WHAT WOULD YOU LIKE TO INSERT:\n"
                            + "1) Campers\n"
                            + "2) Transport\n" 
                            + "3) Accomodation\n"
                            + "4) Activities\n"
                            + "5) Material\n"
                            + "6) Instructor\n"
                            + "7) A new material in camper\n"
                            + "8) A new activity in camper\n\n"
                            + ""
                            + "Option number: ");

                    readString = console.readLine();
                    int optionNumberInsert = Integer.parseInt(readString);
//+++++++++++++++++++++++++++++++++++++++ins camper+++++++++++++++++++++++++++++++++++++++++++			
                    switch (optionNumberInsert) {
                        case 1: {
                          
                       	System.out.println("Insert the name of the camper:" );
                            do {  
                            readString = console.readLine();
                            if(readString.isEmpty()) {
                            	System.out.println("You have to introduce a name. Try again: ");
                            readString = console.readLine();
                            }else {
                            camper1.setName(readString);
                            }
                            }while(readString.isEmpty());
                            
                         System.out.println("Insert date of birth (yyyy-mm-dd): ");
        					  readString = console.readLine();
        					  String withoutTime = readString;
        					  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        					  LocalDate date= LocalDate.parse(withoutTime, formatter);
        					  camper1.setDateBirth(date);
        					  

                        	System.out.println("Insert the NIF of the camper:" );
                            do {  
                            readString = console.readLine();
                            if(readString.isEmpty()) {
                            	System.out.println("You have to introduce a NIF. Try again: ");
                            readString = console.readLine();
                            }else {
                            camper1.setNIF(readString);
                            }
                            }while(readString.isEmpty());
                            
                            
                         System.out.println("Insert phone number: ");
        						String telephone = console.readLine();
        						camper1.setPhonenumber(Integer.parseInt(telephone));
        					
        					System.out.println("Insert email:");
        						do {
        						 readString = console.readLine();
        						 if(readString.isEmpty()&& telephone.isEmpty()){
        							 System.out.println("We need to contact with the client.We required the email or the phone number ");
        							 System.out.println("If you want to introduce the email insert 1 and if you want to introduce the phone number insert 2:");
        							 readString = console.readLine();
        							 if(Integer.parseInt(readString)==1) {
        								 do {
        								 System.out.println("Insert the email");
        								 readString = console.readLine();
        								 if(readString.isEmpty()) {
        									 System.out.println("Invalid email.");
        								 }else {
        									camper1.setEmail(readString);
        									 }
        								 }while(readString.isEmpty());
        							 }else {
        								 if(Integer.parseInt(readString)==2) {
        									 do {
                								 System.out.println("Insert the phonenumber");
                								 readString = console.readLine();
                								 if(readString.isEmpty()) {
                									 System.out.println("Invalid phonenumber.");
                								
                								 }else {
                									camper1.setPhonenumber(Integer.parseInt(readString));
                									 }
                								 }while(readString.isEmpty());
        	
        						              }else {
        							          camper1.setEmail(readString);
        						                     }
        						             }
        						}else {camper1.setEmail(readString);}
        					}while(readString.isEmpty()&&telephone.isEmpty());
         
        				System.out.println("Insert the payment method you will use: ");
        				System.out.println("1.VISA  2.MASTERCARD  3. CASH");
        				  do {  
                              readString = console.readLine();
                              if(readString.isEmpty()) {
                              	System.out.println("You have to introduce a paymentmethod. Try again: ");
                              
                              }else {
                              camper1.setPayment_method(readString);
                              }
                           }while(readString.isEmpty());
        				  
        				camper1.setNeedtopay(0);
        				in.insertCamper(camper1);
    
        				
        				
                    System.out.println("Does the camper want a transport? (Y/N)");  
                    readString= console.readLine();
                    if(readString.equals("Y")) {
                    	transports = sel.selectTransport();
                    	if(transports.isEmpty()) {
                    	System.out.println("There is any transport available. Sorry");
                    	}else {
                    		for(Transport trans: transports) {
                    			System.out.println(trans);
                    		}
                    		System.out.println("Introduce the id of the one you want.");
                    		do {
                    			readString = console.readLine();
                    		    Transport trans1 = ser.searchTransport(Integer.parseInt(readString));
                    		    if(trans1.checkAvailability()) {
                    			Integer a = trans1.getAvailable() + 1;
                    			trans1.setAvailable(a);
                         	up.updateTransport(trans1);
                         	camper1.addNeedToPay(trans1.getPrice());
                         	up.updateCamper(camper1);
                    			in.insertTransInC(camper1, trans1);
                    			
                    			h = true;
                    		    }else {
                    		 	   System.out.println("The transport "+trans1.getType_transport()+ " is not abailable. Choose another: ");
                    		 	   h = false;
                    		           }
                          	}while(h= false);
                    		
                    	}
                    }
                    
                    System.out.println("Does the camper want an accomodation? (Y/N)");  
                    readString= console.readLine();
                    if(readString.equals("Y")) {
                    	accomodations = sel.selectAccomodation();
                    	if(accomodations.isEmpty()) {
                    	System.out.println("There is any accomodation available. Sorry");
                    	}else {
                    		for(Accomodation acom: accomodations) {
                    			System.out.println(acom);
                    		}
                    		
                    		System.out.println("Introduce the id of the one you want.");
                    		do {
                    		readString = console.readLine();
                    	    Integer accomid = Integer.parseInt(readString);
                    		Accomodation accomodation = ser.searchAccomodation(accomid);
                    		if(accomodation.checkAvailability()) {
                    	    Integer a = accomodation.getAvailability() + 1;
                    	    accomodation.setAvailability(a);
                    	    up.updateAccomodation(accomodation);
                    	    camper1.addNeedToPay(accomodation.getPrice());
                         up.updateCamper(camper1);
                    		in.insertAccomInC(camper1, accomodation);
                    		
                    		h = true;
                    		}else {
                    			System.out.println("The accomodation "+ accomodation.getAccomodation()+" is not available. Choose a diferent one:");
                    			h = false;
                    	
                    		}
                       	}     while(h = false);
                    	}
                    }
                    
                    
                    	System.out.println("Does the camper want an activity? (Y/N)");
                    	readString = console.readLine();
                    	if(readString.equals("Y")) {
                    		activities = sel.selectActivity();
                    		if(activities.isEmpty()) {
                    			System.out.println("There is any activity available. Sorry.");
                    		}else {
                    			for(Activity act : activities) {
                    				System.out.println(act);
                    			}
                    			do {
                    			System.out.println("Introduce the id of the activity wanted:");
                    			do{
                    				readString = console.readLine();
                    			
                    			activity1= ser.searchActivity(Integer.parseInt(readString));
                    			if(activity1.checkAvailability()) {
                    				Integer a = activity1.getAvailability() +1;
                    				activity1.setAvailability(a);
                    				camper1.addNeedToPay(activity1.getPrice());
                    				in.insertCamper_activity(camper1, activity1);
                    				up.updateCamper(camper1);
                    				up.updateActivity(activity1);
                    				h = true;
                    			}else{
                    				System.out.println("The activity is already full. CHoose a diferent one:");
                    				h = false;
                    			}
                    			}while(h = false);
                    			
                    			System.out.println("Would you want another activity? (Y/N) ");
                    			readString = console.readLine();
                    			if(readString.equals("Y")) {
                    				h = true;
                    			}else {
                    				h = false;
                    			}
                    			}while(h == true);
                    		
                    			
                    		}
                    		
                    	}
                    	
                    	System.out.println("Does the camper want any material? (Y/N)");
                    	readString = console.readLine();
                    	if(readString.equals("Y")) {
                    		materials = sel.selectMaterial();
                    		if(materials.isEmpty()) {
                    			System.out.println("There is any material available. Sorry.");
                    		}else {
                    			for(Material mat: materials) {
                    				System.out.println(mat);
                    			}
                    			
                    			do {
                    				
                    			System.out.println("Introduce the id of the material wanted:");
                    			readString = console.readLine();
                    			Material mat = ser.searchMaterial(Integer.parseInt(readString));
                    			camper1.addNeedToPay(mat.getPrice());
                             up.updateCamper(camper1);
                    			in.insertCamper_material(camper1, mat);
                    			System.out.println("Would you want another material? (Y/N) ");
                    			readString = console.readLine();
                    			if(readString.equals("Y")) {
                    				h = true;
                    			}else {
                    				h = false;
                    			}
                    			}while(h == true);
                    		}
                    		
                    	}
                    }
                    
                    break;
              
                        case 2: 
                        	System.out.println("Insert the name of the transport");
                       transport1 = new Transport();
                        	do {
                        	readString = console.readLine();
                        	
                        	
                        		if(ser.searchTransportN(readString).getType_transport()==NULL) {
                        		    transport1.setType_transport(readString);
                        			h = true;
                        		}else {
                        			System.out.println("The name you have introduce exit. Insert a different one.");
                        			h = false;
                        		}
                        		
                        	}while(h==false);
                        	
                        	System.out.println("Insert the price:");
                        	readString = console.readLine();
                        	Integer price = Integer.parseInt(readString);
                        	transport1.setPrice(price);
                        	transport1.setAvailable(0);
                        	in.insertTransport(transport1);
                        	
                        	
   
                            break;

                        case 3: 
                        	
                        	System.out.println("Insert the name of the accomodation");
                        accomodation1 = new Accomodation();
                        	do {
                        	readString = console.readLine();
                        	
                        		if(ser.searchAccomodationN(readString).getAccomodation()==NULL) {
                        			accomodation1.setAccomodation(readString);
                        			h = true;
                        		}else {
                        			System.out.println("The name you have introduce exit. Insert a different one.");
                        			h = false;
                        		}
                        		
                        	}while(h==false);
                        	
                        	System.out.println("Insert the price:");
                        	readString = console.readLine();
                        	accomodation1.setPrice(Integer.parseInt(readString));
                        	accomodation1.setAvailability(0);
                        	create.createAccomodation(accomodation1);
                        	
                            break;

                        case 4: 
                        	System.out.println("Insert the name of the activity");
                         activity1 = new Activity();
                        	do {
                        	readString = console.readLine();
                        	
                        		if((ser.searchActivityN(readString)).getActivity()==NULL) {
                        			activity1.setActivity(readString);
                        			h = true;
                        		}else {
                        			System.out.println("The name you have introduce exit. Insert a different one.");
                        			h = false;
                        		}
                        		
                        	}while(h==false);
                        	
                        	System.out.println("Insert the price:");
                        	readString = console.readLine();
                         activity1.setPrice(Integer.parseInt(readString));
                         activity1.setAvailability(0);
                         in.insertActivity(activity1);
                         
                         System.out.println("These are the instructors:");
                         instructors = sel.selectInstructor();
                         if(instructors.isEmpty()) {
                        	 System.out.println("There are any instructors available");
                         }else {
                         for(Instructor inst: instructors) {
                 			System.out.println(inst);
                 		}
                         do {
                         System.out.println("Introduce the id of the instructor, who is going to be in charge of the activity:");
                         readString = console.readLine();
                         if(readString.isEmpty()){
                        	 System.out.println("The activity must have an instructor, choose one:");
                         readString = console.readLine();
                         }else {
                        	 
                        	instructor1 = ser.searchInstructor(Integer.parseInt(readString));
                         in.insertInstructorInA(instructor1, activity1);
                        	
                         }
                         
                         }while(readString.isEmpty());
                         
                          }
                         
                         break;

                        case 5: 
                        {
                        	System.out.println("Insert the name of the material");
                        material1 = new Material();
                     	do {
                      	readString = console.readLine();
                    	
                    		if(ser.searchMaterialN(readString).getMaterial()==NULL) {
                    			material1.setMaterial(readString);
                    			h = true;
                    		  }else {
                    			System.out.println("The name you have introduce exits. Insert a different one.");
                    			h = false;
                    		        }
                    		
                      	}while(h==false);
                    	
                    	System.out.println("Insert the price:");
                    	readString = console.readLine();
                     material1.setPrice(Integer.parseInt(readString));
                     create.createMaterial(material1);
                    	
                        }
                        break;


                        case 6 : 
                        {
                        	System.out.println("Insert the name of the instructor:" );
                            do {  
                            readString = console.readLine();
                            if(readString.isEmpty()) {
                            	System.out.println("You have to introduce a name. Try again: ");
                            readString = console.readLine();
                            }else {
                            instructor1.setName(readString);
                            }
                            }while(readString.isEmpty());
                            
                         System.out.println("Insert date of birth (yyyy-mm-dd): ");
        					  readString = console.readLine();
        					  String withoutTime = readString;
        					  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        					  LocalDate date= LocalDate.parse(withoutTime, formatter);
        					  instructor1.setDateBirth(date);
        					  

                        	System.out.println("Insert the NIF of the instructor:" );
                            do {  
                            readString = console.readLine();
                            if(readString.isEmpty()) {
                            	System.out.println("You have to introduce a NIF. Try again: ");
                            readString = console.readLine();
                            }else {
                            instructor1.setNIF(readString);
                            }
                            }while(readString.isEmpty());
                            
                            
                         System.out.println("Insert phone number: ");
        						do {
        							readString = console.readLine();
        						
        						if(readString.isEmpty()) {
        							System.out.println("You must introduce a phone number, because we need to contact with the instructor."
        									+ "\n Insert a correct phone number: ");
        						readString = console.readLine();
        						}else {
        						instructor1.setPhoneNumber(Integer.parseInt(readString));
        						}
        						}while(readString.isEmpty());
        					
        				System.out.println("Insert the nationality: ");
        				
        				  do {  
                              readString = console.readLine();
                              if(readString.isEmpty()) {
                              	System.out.println("You have to introduce a nationality . Try again: ");
                              readString = console.readLine();
                              }else {
                              instructor1.setNationality(readString);
                              }
                              }while(readString.isEmpty());
        			  
        				  System.out.println("Introduce the salary of the instructor:");
        				  do {
        				  readString = console.readLine();
        				  if(readString.isEmpty()) {
        					  System.out.println("We need to pay to our employees (IT IS ILEGAL NOT TO"
        					  		+ "\n Insert the salary again: ");
        					  readString = console.readLine();
        				  }else{
        					  instructor1.setSalary(Integer.parseInt(readString));
        				  }
        				  }while(readString.isEmpty());
        				
        			    create.createInstructor(instructor1);
        				
                    System.out.println("Does the instructor requires a transport? (Y/N)");  
                    readString= console.readLine();
                    if(readString.equals("Y")) {
                    	transports = sel.selectTransport();
                    	if(transports.isEmpty()) {
                    	System.out.println("There is any transport available. Sorry");
                    	}else {
                    		for(Transport trans: transports) {
                    			System.out.println(trans);
                    		}
                    		System.out.println("Introduce the id of the one you want.");
                    		do {
                    			readString = console.readLine();
                    		    transport1 = ser.searchTransport(Integer.parseInt(readString));
                    		    if(transport1.checkAvailability()) {
                    			Integer a = transport1.getAvailable() + 1;
                    			transport1.setAvailable(a);
                    			up.updateTransport(transport1);
                    			in.insertTransInI(instructor1, transport1);
                    			h = true;
                    		    }else {
                    		 	   System.out.println("The transport "+transport1.getType_transport()+ " is not abailable. Choose another: ");
                    		 	   h = false;
                    		           }
                          	}while(h= false);
                    	}
                    }
                    
                    System.out.println("Does the instructor want an accomodation? (Y/N)");  
                    readString= console.readLine();
                    if(readString.equals("Y")) {
                    	accomodations = sel.selectAccomodation();
                    	if(accomodations.isEmpty()) {
                    	System.out.println("There is any accomodation available. Sorry");
                    	}else {
                    		for(Accomodation acom: accomodations) {
                    			System.out.println(acom);
                    		}
                    		
                    		System.out.println("Introduce the id of the one you want.");
                    		do{readString = console.readLine();
                    	    Integer accomid = Integer.parseInt(readString);
                    		accomodation1 = ser.searchAccomodation(accomid);
                    		if(accomodation1.checkAvailability()) {
                            Integer a = accomodation1.getAvailability()+ 1;
                    			accomodation1.setAvailability(a);
                    			up.updateAccomodation(accomodation1);
                    		in.insertAccomInI(instructor1, accomodation1);
                    		}else {
                    			System.out.println("The accomodation is not abailable. Introduce a different one: ");
                    		}
                    		}while(h = false);
                    	}
                    }
                    
                    	System.out.println("The instructor must be incharge of an activity.");
                    		
                    		activities = sel.selectActivity();
                    		if(activities.isEmpty()) {
                    			System.out.println("No activities yet");
                    		}else {
                    			do {
                    			for(Activity act : activities) {
                    				System.out.println(act);
                    			}
                    			
                    			System.out.println("Introduce the id of the activity wanted:");
                    			readString = console.readLine();
                    			activity1 = ser.searchActivity(Integer.parseInt(readString));
                    		    in.insertInstructorInA(instructor1, activity1);
                    			
                    			System.out.println("Would you want another activity? (Y/N");
                    			readString = console.readLine();
                    			if(readString.equals("Y")) {
                    				h = true;
                    			}else {
                    				h = false;
                    			}
                    			}while(h == true);
                    			
                    		}
                    		
                        	break;
                    }
                        
                        case 7: 
                        {
                        	
                        	System.out.println("The campers are: ");
                        	campers = sel.selectCamper();
                        	List<String> x = new ArrayList();
                			
                        	for(Camper camp : campers) {
                        		System.out.println("ID: "+camp.getId()+" .Name: " +camp.getName());
                        	}
                        	System.out.println("Insert the ID of the camper to which you will add a material: ");
                        	readString = console.readLine();
                        	camper1 = ser.searchCamper(Integer.parseInt(readString));
                        	materials = sel.selectMaterial();
                        	System.out.println("The materials are: ");
                        	for(Material mat : materials) {
                        		System.out.println("ID: "+mat.getId()+" .Name: " +mat.getMaterial());
                        	}
                        	System.out.println("Insert the ID of the material you want to insert: ");
                        	readString = console.readLine();
                        	material1 = ser.searchMaterial(Integer.parseInt(readString));
                        	in.insertCamper_material(camper1, material1);
                        	
                        	break;
                        }
                        
                        case 8:
                        {
                        	System.out.println("The campers are: ");
                        	campers = sel.selectCamper();
                        	List<String> x = new ArrayList();
                			
                        	for(Camper camp : campers) {
                        		System.out.println("ID: "+camp.getId()+" .Name: " +camp.getName());
                        	}
                        	System.out.println("Insert the ID of the camper to which you will add a material: ");
                        	readString = console.readLine();
                        	camper1 = ser.searchCamper(Integer.parseInt(readString));
                         activities = sel.selectActivity();
                        	System.out.println("The activities are: ");
                        	for(Activity act: activities) {
                        		System.out.println("ID: "+act.getId()+" .Name: " +act.getActivity());
                        	}
                        	System.out.println("Insert the ID of the activity you want to insert: ");
                        	readString = console.readLine();
                        	activity1 = ser.searchActivity(Integer.parseInt(readString));
                        	in.insertCamper_activity(camper1, activity1);
                        	break;
                        }
                        
                        	
                        	
                        	
                    }}
            
                break;

              //*******************************modify****************************************************		
                case 3:{ //modify
                    System.out.println("WHERE WOULD YOU LIKE TO MODIFY: \n\n"
                            + "1) Campers"
                            + "  2) Transport" //DUDA 
                            + "  3) Accomodation"//DUDA
                            + "  4) Activities"//DUDA
                            + "  5) Material"//DUDA
                            + "  6) Instructor\n\n"//DUDA
                            + ""
                            + "  Option number: ");

                    readString = console.readLine();
                    int optionNumberModify = Integer.parseInt(readString);

                    switch (optionNumberModify) {

                        case 1: {//campers
                        campers = sel.selectCamper();
                        	if(campers.isEmpty()) {
                        	System.out.println("There is any camper available. Sorry");
                        	}else {
                        		for(Camper camp: campers) {
                        			System.out.println(camp);
                        		}
                        		System.out.println("Introduce the NIF of the one you want: ");
                        		readString = console.readLine();
                        		camper1 = new Camper();
                        		camper1 = ser.searchCamper(readString);
                            
                            System.out.println("WHAT WOULD YOU LIKE TO MODIFY: \n\n"
                                    + "1) Name"
                                    + "  2) Date of Birth"
                                    + "  3) NIF"
                                    + "  4) Phone Number"
                                    + "  5) Email"
                                    + "  6) Payment method"
                                    + "  7) Transport"
                                    + "  8) Accomodation"
                                    + "  9) Activity\n\n"
                                    + "  10) Material\n\n"
                                    + "  Option number: ");

                            readString = console.readLine();
                            int optionNumberModifyCamper = Integer.parseInt(readString);

                            switch (optionNumberModifyCamper) {

                                case 1: {
                                	System.out.println("Insert the new name: ");
                                
                                readString = console.readLine();
                                camper1.setName(readString);
                                up.updateCamper(camper1);
                                
                                    break;
                                }
                                case 2: //mod date of b
                                	System.out.println("Introduce the new date of birth: (yyyy-mm-dd)");
                                	readString = console.readLine();
              					  	String withoutTime = readString;
              					  	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
              					  	LocalDate date= LocalDate.parse(withoutTime, formatter);
              					  	camper1.setDateBirth(date);
              					  	up.updateCamper(camper1);
                                	break;

                                case 3: //nif
                                	System.out.println("Insert the new NIF: ");
                                    
                                    readString = console.readLine();
                                    camper1.setNIF(readString);
                                    update.updateCampNIF(camper1, readString);
                                	
                                    break;

                                case 4: // mod phone
                                	System.out.println("Insert the new phone number: ");
                                    
                                    readString = console.readLine();
                                    camper1.setPhonenumber(Integer.parseInt(readString));
                                    update.updateCampPhoneNumber(camper1, Integer.parseInt(readString) );
                                	
                                    break;

                                case 5: //mod email
                                	System.out.println("Insert the new email: ");
                                    
                                    readString = console.readLine();
                                    camper1.setEmail(readString);
                                    update.updateCampEmail(camper1, readString);
                                	
                                    break;

                                case 6: //mod payment method
                                	System.out.println("Insert the new payment method: ");
                                    
                                    readString = console.readLine();
                                    camper1.setPayment_method(readString);
                                    up.updateCamper(camper1);
                                	
                                    break;

                                case 7: //transport
                                	transports=sel.selectTransport();
                                	if(transports.isEmpty()){
                                    	System.out.println("There is any trasport available. Sorry");
                                	}
                                	else{
                                		System.out.println("Choose the new trasport: ");
                                		for (Transport transport : transports) {
                            			System.out.println(transport);
                            		}
                                    
                                    readString = console.readLine();
                                    Transport trans =new Transport();
                                    trans=ser.searchTransportN(readString);
                                    
                                    camper1.setTransports(trans);
                                    up.updateTransportInCamper(trans, camper1);
                                	
                                	}break;

                                case 8:{ //accomodation	
                                
                                	
                                	accomodations=sel.selectAccomodation();
                                	if(accomodations.isEmpty()){
                                    	System.out.println("There is any material available. Sorry");
                                	}
                                	else {
                                		System.out.println("Choose the new accomodation: ");
                                	for (Accomodation accomodation : accomodations) {
                            			System.out.println(accomodation);
                            		}
                                	                          
                                    readString = console.readLine();
                                    Accomodation accom =new Accomodation();
                                    accom=ser.searchAccomodationN(readString);
                                    
                                    camper1.setAccomodation(accom);
                                    up.updateAccomodationInCamper(accom, camper1);
 
                                	}break;}

                                case 9:
                                {
                                		activities =sel.selectActivity();
                                		if(activities.isEmpty()){
                                        	System.out.println("There is any activity available. Sorry");
                                    	}
                                		else {
                                			do {
                                				System.out.println("Choose the activity you want to change: ");
                                    		    List<String> x=sel.selectActivityNames(camper1);
                                    		    for(String s :x) {
                                                 	System.out.println("The activity for this camper is " +s); 
                                                  }
                                    			readString = console.readLine();
                                    			Activity act1=ser.searchActivityN(readString);
                                    			del.deleteActivityfromCMbyN(act1);
                                    			System.out.println("Introduce the new material: ");
                                    			for(Activity act:activities) {
                                    				System.out.println(act);
                                    			}
                                    			readString=console.readLine();
                                    			Activity act2=ser.searchActivityN(readString);
                                    			in.insertCamper_activity(camper1, act2);
                                	System.out.println("Would you want another activity? (Y/N");
                        			readString = console.readLine();
                        			if(readString.equals("Y")) {
                        				h = true;
                        			}else {
                        				h = false;
                        			}
                        			}while(h == true);
                                		}break;}
                                    
                                case 10:
                                	
                                		{materials =sel.selectMaterial();
                                		if(materials.isEmpty()){
                                        	System.out.println("There is any material available. Sorry");
                                    	}
                                		else {
                                			do {
                                		    System.out.println("Choose the material you want to change: ");
                                		    List<String> x=sel.selectMaterialNames(camper1);
                                		    for(String s :x) {
                                             	System.out.println("The material for this camper is " +s); 
                                              }
                                			readString = console.readLine();
                                			Material mat1=ser.searchMaterialN(readString);
                                			del.deleteMaterialfromCMbyN(mat1);
                                			System.out.println("Introduce the new material: ");
                                			for(Material mat:materials) {
                                				System.out.println(mat);
                                			}
                                			readString=console.readLine();
                                			Material mat2=ser.searchMaterialN(readString);
                                			in.insertCamper_material(camper1, mat2);
                                			
                                			System.out.println("Would you want to change another material? (Y/N)");
                                			readString = console.readLine();
                                			if(readString.equals("Y")) {
                                				h = true;
                                			}else {
                                				h = false;
                                			}
                                			}while(h == true);
                                		}	break;}
                               
                            }

                        }
                        break;}

                        case 2:{ //transport
                        	
                        
                        	transports = sel.selectTransport();
                         	if(transports.isEmpty()) {
                         	System.out.println("There is any transport available. Sorry");
                         	}else {
                         		for(Transport trans: transports) {
                         			System.out.println(trans);
                         		}
                         	
                         		System.out.println("Introduce the id of the transport you want to modify: ");
                         		readString = console.readLine();
                         		transport1= ser.searchTransport(Integer.parseInt(readString));
                         
                         		
                         		System.out.println("WHAT WOULD YOU LIKE TO MODIFY:\n "
                                        + "1) Name\n"
                                        + "2) Price\n\n"
                                        + "Option number: ");

                                readString = console.readLine();
                                int optionNumberModifyTransport = Integer.parseInt(readString);

                       switch(optionNumberModifyTransport){
                          case 1: //Modify type of transport
                          {	System.out.println("Insert the new type of transport: ");
                      	
                             readString = console.readLine();
                              transport1.setType_transport(readString);
                              //System.out.println(trans1);
                             up.updateTransport(transport1);
                              
                              break;
                              
                        	  
                          }
                          case 2: //Modify price of the transport
                          {
                        		System.out.println("Insert the new price of the transport: ");
                            	
                                readString = console.readLine();
                                int price=Integer.parseInt(readString);
                                
                                up.updateTransport(transport1);
                                System.out.println(transport1);
                                       break;
                          }
                       }
                       }
                            break;}

                          

                        case 3: //accomodation no funciona!!
                        	   {accomodations = sel.selectAccomodation();
                        	     if(accomodations.isEmpty()) {
                        	    	 System.out.println("There is any activity aviable. Sorry");
                        	     }else {
                        	    	     for(Accomodation acc: accomodations) {
                        	    	    	     System.out.println(acc);
                        	    	     }
                        	    	     System.out.println("Introduce the id of the accomodation you want: ");
                                  		readString = console.readLine();
                                  		accomodation1= ser.searchAccomodation(Integer.parseInt(readString));
                                  
                                  		
                                  		System.out.println("WHAT WOULD YOU LIKE TO MODIFY:\n "
                                                 + "1) Name\n"
                                                 + "2) Price\n\n"
                                                 + "Option number: ");

                                         readString = console.readLine();
                                         int optionNumberModifyAccomodation = Integer.parseInt(readString);

                                switch(optionNumberModifyAccomodation){
                                   case 1: //Modify name of the accomodation
                                   {	System.out.println("Insert the new name of the accomodation: ");
                               	
                                      readString = console.readLine();  
                                      accomodation1.setAccomodation(readString);
                                       up.updateAccomodation(accomodation1);
                                       System.out.println(accomodation1);
                                       break;
                                 	  
                                   }
                                   case 2: //Modify price of the accomodation
                                   {
                                 		System.out.println("Insert the new price of the accomodation: ");
                                     	
                                         readString = console.readLine();
                                         int p=Integer.parseInt(readString);
                                         accomodation1.setPrice(p);
                                         System.out.println(accomodation1);
                                         up.updateAccomodation(accomodation1);
                                                break;
                                   }
                                }
                                }
                                     break;}
                        	    

                        case 4: //activity
                        	{activities = sel.selectActivity();
                         	if(activities.isEmpty()) {
                         	System.out.println("There is any activity available. Sorry");
                         	}else {
                         		for(Activity act: activities) {
                         			System.out.println(act);
                         		}
                         	
                         		System.out.println("Introduce the id of the activity you want: ");
                         		readString = console.readLine();
                         		activity1= ser.searchActivity(Integer.parseInt(readString));
                         
                         		
                         		System.out.println("WHAT WOULD YOU LIKE TO MODIFY:\n "
                                        + "1) Name\n"
                                        + "2) Price\n\n"
                                        + ""
                                        + "Option number: ");

                                readString = console.readLine();
                                int optionNumberModifyActivity = Integer.parseInt(readString);

                       switch(optionNumberModifyActivity){
                          case 1: //Modify name of the activity
                          {	System.out.println("Insert the new name of the activity: ");
                      	
                             readString = console.readLine();
                              activity1.setActivity(readString);
                              System.out.println(activity1);
                              up.updateActivity(activity1);
                              break;
                        	  
                          }
                          case 2: //Modify price of the activity
                          {
                        		System.out.println("Insert the new price of the activity: ");
                            	
                                readString = console.readLine();
                                activity1.setPrice(Integer.parseInt(readString));
                                System.out.println(activity1);
                                up.updateActivity(activity1);
                                       break;
                          }
                       }
                       }
                            break;}

                            
                        case 5://material
                        	{materials = sel.selectMaterial();
                         	if(materials.isEmpty()) {
                         	System.out.println("There is any material available. Sorry");
                         	}else {
                         		for(Material mat: materials) {
                         			System.out.println(mat);
                         		}
                         	
                         		System.out.println("Introduce the id of the material you want: ");
                         		readString = console.readLine();
                         		material1 = ser.searchMaterial(Integer.parseInt(readString));
                         
                         		System.out.println("WHAT WOULD YOU LIKE TO MODIFY:\n "
                                        + "1) Name\n"
                                        + "2) Price\n\n"
                                        + ""
                                        + "Option number: ");

                                readString = console.readLine();
                                int optionNumberModifyMaterial = Integer.parseInt(readString);

                       switch(optionNumberModifyMaterial){
                          case 1: //Modify name of the material
                          {	System.out.println("Insert the new name of the material: ");
                      	
                             readString = console.readLine();
                              material1.setMaterial(readString);
                              System.out.println(material1);
                              up.updateMaterial(material1);
                              break;
                        	  
                          }
                          case 2: //Modify price of the material
                          {
                        		System.out.println("Insert the new price of the material: ");
                            	
                                readString = console.readLine();
                                material1.setPrice(Integer.parseInt(readString));
                                System.out.println(material1);
                                up.updateMaterial(material1);
                                       break;
                          }
                       }
                       }break;}
                        	

                        case 6:  //instructor
                        {
                        	instructors = sel.selectInstructor();
                     	if(instructors.isEmpty()) {
                     	System.out.println("There is any instructor available. Sorry");
                     	}else {
                     		for(Instructor ins: instructors) {
                     			System.out.println(ins);
                     		}
                     		System.out.println("Introduce the id of the instructor you want: ");
                     		readString = console.readLine();
                     		instructor1 = new Instructor();
                     		instructor1 = ser.searchInstructor(Integer.parseInt(readString));
                         
                     		System.out.println("WHAT WOULD YOU LIKE TO MODIFY: \n\n"
                                    + "  1) Name"
                                    + "  2) Date of Birth"
                                    + "  3) Nationality"
                                    + "  4) NIF"
                                    + "  5) Phone Number"
                                    + "  6) Salary"
                                    + "  7) Transport"
                                    + "  8) Accomodation"
                                    + "  9) Activity\n\n"
                                    + "  Option number: ");

                            readString = console.readLine();
                            int optionNumberModifyInstructor = Integer.parseInt(readString);
                            
                            switch(optionNumberModifyInstructor) {
                            case 1: //Modify name of instructor
                                {System.out.println("Insert the new name of the instructor: ");
                        	
                                 readString = console.readLine();
                                 instructor1 .setName(readString);
                                 System.out.println(instructor1 );
                                 up.updateInstructor(instructor1 );
                                   break;}
                                
                            case 2: //Modify date of birth of instructor
                            {	System.out.println("Introduce the new date of birth: (yyyy-mm-dd)");
                        	readString = console.readLine();
      					  	String withoutTime = readString;
      					  	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
      					  	LocalDate date= LocalDate.parse(withoutTime, formatter);
      					  	instructor1.setDateBirth(date);
      					  	up.updateInstructor(instructor1);
                        	break;}
                            
                            case 3: //Modify nationality of instructor
                             { System.out.println("Insert the new nationality of the instructor: ");
                            	
                                readString = console.readLine();
                                instructor1 .setNationality(readString);
                                System.out.println(instructor1 );
                                up.updateInstructor(instructor1 );
                                       break;}
                            
                            case 4: //Modify nif of instructor
                              {	System.out.println("Insert the new name of the instructor: ");
                          	
                              readString = console.readLine();
                              instructor1 .setNIF(readString);
                              System.out.println(instructor1 );
                              up.updateInstructor(instructor1 );
                                     break; }
                            
                            case 5: //Modify phone number of instructor 
                               {  	System.out.println("Insert the new phone number of the instructor: ");
                           	
                               readString = console.readLine();
                               instructor1 .setPhoneNumber(Integer.parseInt(readString));
                               System.out.println(instructor1 );
                               up.updateInstructor(instructor1 );
                                      break;}
                            
                            case 6: // Modify salary of instructor
                               {  System.out.println("Insert the new salary of the instructor: ");
                           	
                               readString = console.readLine();
                               instructor1 .setSalary(Integer.parseInt(readString));
                               System.out.println(instructor1 );
                               up.updateInstructor(instructor1 );
                                      break;
                            	
                                }
                            case 7: // Modify transport
                            {transports=sel.selectTransport();
                        	if(transports.isEmpty()){
                            	System.out.println("There is any trasport available. Sorry");
                        	}
                        	else{
                        		System.out.println("Choose the new trasport: ");
                        		for (Transport transport : transports) {
                    			System.out.println(transport);
                    		}
                            
                            readString = console.readLine();
                            Transport trans =new Transport();
                            trans=ser.searchTransportN(readString);
                            
                            instructor1.setTransport(trans);
                            up.updateTransportInInstructor(trans, instructor1);     	
                        	}break;}
                        	
                            case 8: // Modify accomodation
                            {	
                            	accomodations=sel.selectAccomodation();
                            	if(accomodations.isEmpty()){
                                	System.out.println("There is any material available. Sorry");
                            	}
                            	else {
                            		System.out.println("Choose the new accomodation: ");
                            	for (Accomodation accomodation : accomodations) {
                        			System.out.println(accomodation);
                        		}
                            	                          
                                readString = console.readLine();
                                Accomodation accom =new Accomodation();
                                accom=ser.searchAccomodationN(readString);
                                
                                instructor1.setAccomodation(accom);
                                up.updateAccomodationInInstructor(accom, instructor1);

                            	}break;}
                            
                            case 9: // Modify activity
                            {	
                            	activities=sel.selectActivity();
                            	if(activities.isEmpty()){
                                	System.out.println("There is any activity available. Sorry");
                            	}
                            	else {
                        			do {
                        		    System.out.println("Choose the activity you want to change: ");
                        		    List<Activity> x=sel.selectActOfInst(instructor1);
                        		    for(Activity s :x) {
                                     	System.out.println("The Activity for this instructor is " +s); 
                                      }
                        			readString = console.readLine();
                        			Activity act1=ser.searchActivityN(readString);
                        			System.out.println("Are you sure you want to change this activity? If "
                        			+ "you do that the activity will be deleted. (Y/N)");
                        			readString=console.readLine();
                        			if(readString.equals("Y")) {
                        				del.deleteActivityN(act1);
                            			System.out.println("Introduce the new activity: ");
                            			for(Activity act:activities) {
                            				System.out.println(act);
                            			}
                            			readString=console.readLine();
                            			Activity act2=ser.searchActivityN(readString);
                            			in.insertInstructorInA(instructor1, act2);
                        			} 		
                        			else {break;}
                        			System.out.println("Would you want to change another material? (Y/N)");
                        			readString = console.readLine();
                        			if(readString.equals("Y")) {
                        				h = true;
                        			}else {
                        				h = false;
                        			}
                        			}while(h == true);
                        		
                            	}break;}
                            }

                    }
                    break;}}
                    break;}
                
                case 4: //delete
                {
                	
                	 
                		 
                	 
                    System.out.println("WHAT WOULD YOU LIKE TO DELETE:\n"
                            + "1) Campers\n"
                            + "2) Transport\n" 
                            + "3) Accomodation\n"
                            + "4) Activities\n"
                            + "5) Material\n"
                            + "6) Instructor\n"
                            + "Option:");

                    readString = console.readLine();
                     int optionNumberDelete = Integer.parseInt(readString);

                    switch (optionNumberDelete) {

                        case 1: {
                        System.out.println("Insert the campers name and surname");
                        List<Camper> list=sel.selectCamperbyName(console.readLine());
                        for (int i = 0; i < list.size(); i++) {
							System.out.println(list.get(i).showNamePhone());
						}
                        System.out.println("Select the id from the camper to be deleted:");
                        int num=Integer.parseInt(console.readLine());
                        Integer a;
                        camper1 = ser.searchCamper(num);
                      	accomodation1 = ser.searchAccomodation(sel.selectAcomC(camper1));
                      	if(accomodation1.getAccomodation()!=NULL) {
                     	a = accomodation1.getAvailability() - 1;
                	        accomodation1.setAvailability(a);
                	        up.updateAccomodation(accomodation1);
                      	}
                      	
                        	transport1 = ser.searchTransport(sel.selectTnsC(camper1));
                        	if(transport1.getType_transport()!=NULL) {
                        	a = transport1.getAvailable() - 1;
                    	    transport1.setAvailable(a);
                    	    up.updateTransport(transport1);
                        	}
                        	
                    	    List<String> nm = sel.selectActivityNames(camper1);
                    	    for(String name: nm) {
                    	    	activity1 = ser.searchActivityN(name);
                    	    	if(activity1.getActivity()!=NULL) {
                        	a = activity1.getAvailability() - 1;
                    	    activity1.setAvailability(a);
                    	    up.updateActivity(activity1);
                    	    	}
                    	    }
                    	    
                        del.deleteCamperIdfromA(num);
                        del.deleteCamperIdfromM(num);
                        del.deleteCamperId(num);
                        }
                        break;

                        case 2: {
                        
                        	transports = sel.selectTransport();
                        	if(transports.isEmpty()) {
                        	System.out.println("There is any transport available to delete. Sorry");
                        	}else {
                        		for(Transport trans: transports) {
                        			System.out.println(trans);
                        		}
                        	}
                        	System.out.println("Insert the id of the transport that you want to delete:");
                        	int num=Integer.parseInt(console.readLine());
                        	del.deleteTransportID(num);
                        	}
                            break;

                        case 3://accomodation funciona 
                        {
                        accomodations = sel.selectAccomodation();
                        	if(accomodations.isEmpty()) {
                        	System.out.println("There is any accomodations available to delete. Sorry");
                        	}else {
                        		for(Accomodation accom: accomodations) {
                        			System.out.println(accom);
                        		}
                        	}
                        	System.out.println("Insert the id of the accomodation that you want to delete:");
                        	int num=Integer.parseInt(console.readLine());
                         del.deleteAccomodationID(num);
                        	
                        	}
                            break;

                        case 4: 
                        	{
                         activities = sel.selectActivity();
                        	if(activities.isEmpty()) {
                        	System.out.println("There is any activity available to delete. Sorry");
                        	}else {
                        		for(Activity activity: activities) {
                        			System.out.println(activity);
                        		}
                        	}
                        	System.out.println("Insert the id of the activity that you want to delete:");
                        	int num=Integer.parseInt(console.readLine());
                        	del.deleteActivityIdfromCA(num);
                        	del.deleteActivityID(num);

                        }
                            break;

                        case 5:
                        	
                        {
                        materials = sel.selectMaterial();
                        	if(materials.isEmpty()) {
                        	System.out.println("There is any material available to delete. Sorry");
                        	}else {
                        		for(Material mat: materials) {
                        			System.out.println(materials);
                        		}
                        	}
                        	System.out.println("Insert the id of the material that you want to delete:");
                        	int num=Integer.parseInt(console.readLine());
                        	del.deleteMaterialIdfromCM(num);
                        	del.deleteMaterialIdfromMA(num);
                        del.deleteMaterialID(num);

                        }
                            break;

                        case 6: 
                        {
                        instructors = sel.selectInstructor();
                        	
                        	if(instructors.isEmpty()) {
                        	System.out.println("There is any instructor available to delete. Sorry");
                        	}else {
                        		for(Instructor inst:instructors) {
                        			System.out.println(inst);
                        		}
                        	}
                        	Integer a;
                        	System.out.println("Insert the id of the instructor that you want to delete:");
                        	int num=Integer.parseInt(console.readLine());
                        	instructor1 = ser.searchInstructor(num);
                        	accomodation1 = ser.searchAccomodation(sel.selectAcomI(instructor1));
                        	if(accomodation1.getAccomodation()!=NULL) {
                         a = accomodation1.getAvailability() - 1;
                    	    accomodation1.setAvailability(a);
                    	    up.updateAccomodation(accomodation1);
                        	}
                        	
                         transport1 = ser.searchTransport(sel.selectTnsI(instructor1));
                        	if(transport1.getType_transport()!=NULL) {
                        	a = transport1.getAvailable() - 1;
                    	    transport1.setAvailable(a);
                    	    up.updateTransport(transport1);
                        	}
                        	System.out.println("If you delete the instructor the activity of that instructor will requires another instructor or be delete");
                        	System.out.println("Do you want to continue (Y/N");
                        	readString = console.readLine();
                        	if(readString.equals("Y")) {
                        	del.deleteInstructorID(num);
                        	List<Integer> activity_ID = sel.selectActI(instructor1);
                        	instructors = sel.selectInstructor();
                        	if(instructors.isEmpty()) {
                        		System.out.println("No instructors, the activities will be delete.");
                        		for(Integer aid: activity_ID) {
                        			del.deleteActivityID(aid);
                        		}
                        		
                        	}else {
                        	for(Instructor ins: instructors) {
                        		System.out.println("ID: "+ins.getId()+"Name: "+ ins.getName());
                        	}
                        	for(Integer aid : activity_ID) {
                        		activity1 = ser.searchActivity(aid);
                        		System.out.println("Insert the id of the instructor for  "+activity1.getActivity());
                        		readString = console.readLine();
                        		activity1.setInst(ser.searchInstructor(Integer.parseInt(readString)));
                        		up.updateActivity(activity1);
                        	}
                        		
                        	}
                        	}
                        	
                        	

                        } break;
                           

                    }
                   
                    break;
                }
               
                case 5: {
                	 System.out.println("1. Save instructor in XML file");
                	 System.out.println("2. Store instructor in Data Base from XML file");
                	 System.out.println("3. Convert XML into HTML");	 
                	 System.out.println("Choose the option");
                	 
                	 int option=Integer.parseInt(console.readLine());
                	 switch(option) {
                	 case 1:
                	     //We transform a instructor from java to xml
                		 instructors = sel.selectInstructor();
                		 for(Instructor ins: instructors) {
                			 System.out.println(ins); 
                		 }
                		 System.out.println("Select the instructor id that you want to save");
                		 readString = console.readLine();
                		 instructor1 = ser.searchInstructor(Integer.parseInt(readString));
                		 activities = sel.selectActOfInst(instructor1);
                		 instructor1.setActivities(activities);
                		 xmlm.marshalldb(instructor1);
                		 
                		 break;
                	 
                	 case 2:
                	     //We obtain the instructor from a xml file and inserted in our database
                		 System.out.println("Introduce the file where the instructor is located: ");
                		 //in our case you should put xml/Instructor.xml
                		 readString = console.readLine();
                		 File file = new File(readString);
                		 Instructor inst = xmlm.unmarshalldb( file);
                		 in.insertInstructor(inst);
                		 System.out.println("The instructor obtain is: "+inst);

                	 
                		 break;
                	 case 3:
                		 //Here is where we transform the instructor from xml to html
                		Boolean check =  xmlm.simpleTransform("xml/Instructor.xml", "xml/Instructordb.xslt", "xml/ExternalInstructor.html");
                		 if(check==true) {
                			 System.out.println("The .html file has been correctly created.");
                		 }else {
                			 System.out.println("Sorry there was an error. Your .html cannot be created.");
                		 }
                		 break;
                		 
                	 }
                }break;
                
                case 6:
                	c.closeconnection();
                	em.closeconnection();
                	System.out.println("You have exit the database.");
                	System.exit(0);
                	
            
        }
                
            }catch(IOException ex) {
            	ex.printStackTrace();
            }
        
	
    	
			}while(optionNumber!=6);
    	
    	c.closeconnection();
    	em.closeconnection();
	}

	
	
	}

