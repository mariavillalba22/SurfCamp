package database.menu;

import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import database.*;
import database.JPA.*;
import database.pojo.*;

public class Menu {
	private static final String NULL = null;

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
   
    	Boolean h;
    	DbManager d =new DbManager();
    	Iterator it;
    	
    	Connect c=new Connect();
    	c.connectiondb();
   // d.createTables(c.getConnectiondb());
    	Insertion in=new Insertion(c.getConnectiondb());
    	Update up = new Update(c.getConnectiondb());
    	Delete del=new Delete(c.getConnectiondb());
    	Selection sel = new Selection(c.getConnectiondb());
    	Search ser = new Search(c.getConnectiondb());
    	
    	JPACreate create = new JPACreate(em.getEntityManager());

    	
    
    	do {
    		Camper camper1 = new Camper();
    		Transport transport1 = new Transport();
    		Accomodation accomodation1 =new Accomodation();
    		Activity activity1=new Activity();
    		Material material1= new Material();
    		Instructor instructor1=new Instructor();
        try {

            System.out.println("SELECT AN OPTION: \n"
                    + "1) VIEW\n"
                    + "2) INSERT\n" // a partir de aqui hay q comprobar si hay algo
                    + "3) MODIFY\n"
                    + "4) DELETE\n"
                    + "5) EXIT\n\n"
                    + ""
                    + "Option number: ");

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String readString = console.readLine();
            optionNumber = Integer.parseInt(readString);

            
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
                        	
                        	System.out.println("SELECT ONE OF THE FOLLOWING OPTIONS: "
                                    + "\n1) List all campers (Full view)\t"
                                    + "\n2) List all campers names\t"
                                   
                                    + "\nOption number: \t");
                        	
                        	readString = console.readLine();
                        	int optnum = Integer.parseInt(readString);
                        	
                        	
                        	switch (optnum) {
                        	
                        	case 1:{
                        	
                        		campers=sel.selectCamper();
                            
                            		for (Camper camper : campers) {
                            			System.out.println(camper);
                            			Transport transport = ser.SearchTransport(sel.selectTnsC(camper));
                            			System.out.println("The transport for camper "+camper.getId()+" is: "+ transport.getType_transport());
                            		    Accomodation accomodation = camper.getAccomodation();

									}
	
                        		}break;//case 1 full view campers
                            	
                        	case 2:{
                        		campers=sel.selectCamper();
                        		
                            	//FALTA
                        		
                        		/*it=campers.iterator();
                            	while(it.hasNext()) {
                            		camper1=(Camper) it.next();
                            		
                            		System.out.println("Name:\t"+camper1.getName());
                        	}*/
                        		}break; //case 2 short view campers 	
                        	
                        	 } //Switch opciones de visualizado de campers
                        	
                    }break; //CASE 1 VIEW CAMPERS
               
                        case 2:{ //Mostrar transporte
                        	
                        	System.out.println("SELECT ONE OF THE FOLLOWING OPTIONS: "
                                    + "\n1) List all transports (Full view)\t"
                                    + "\n2) List all transports available\t"
                                    + "\n3) List all transports under a specific price"
                                    + "\nOption number: \t");
                        	
                        	readString = console.readLine();
                        	int optnum2 = Integer.parseInt(readString);
                        	
                        	
                        	switch (optnum2) {
                        	
                        	case 1:{
                        		transports=sel.selectTransport();
                        		for (Transport transport : transports) {
                        			System.out.println(transport);
                        		}
                        		
                            	/*it=transports.iterator();
                            	while(it.hasNext()) {
                            		transport1=(Transport)it.next();
                            		System.out.println("ID:\t"+transport1.getId()+"\nType:\t"+
                            		transport1.getType_transport()+"\nPrice:\t"+transport1.getPrice());*/

                            	}break; //case 1 view full transports
                            	
                            	
                        	case 2:{
                        		transports=sel.selectTransport();
                        		
                        		//FALTA
                        		
                            	/*it=transports.iterator();
                            	while(it.hasNext()) {
                            		transport1=(Transport)it.next();
                            		System.out.println("\nType:\t"+transport1.getType_transport());
                            	}*/
                        		}break;
                            	
                            case 3:{
                            	
                            	System.out.println("Insert a maximum price:\t");
                            	readString = console.readLine();
                            	int priceComp = Integer.parseInt(readString);
                            	transports=sel.selectTransport();
                            	
                            	/*it=transports.iterator();
                            	while(it.hasNext()) {
                            		transport1=(Transport)it.next();
                            		if(priceComp<=transport1.getPrice())
                            			System.out.println("\nType:\t"+transport1.getType_transport());
                            	}*/
                    				}break;	
                    				
                    			}//switch opciones de view transport
                        	
                        	
                        	}break;//case 2 view transport
                        	
                            

                        case 3:{ //Mostrar acomodation
                        	
                        	System.out.println("SELECT ONE OF THE FOLLOWING OPTIONS: "
                                    + "\n1) List all accomodation (Full view)\t"
                                    + "\n2) List all accomodation types\t"
                                    + "\n3) List all accomodation under a specific price"
                                    + "\n4 List all campers accomodated in a specific place"
                                    + "\nOption number: \t");
                        	
                        	readString = console.readLine();
                        	int optnum3 = Integer.parseInt(readString);
                        	
                        	
                        	switch (optnum3) {
                        	
                        	case 1:{
                        		accomodations=sel.selectAccomodation();
                        		for (Accomodation accomodation : accomodations) {
                        			System.out.println(accomodation);
                        		}
                        		
                            	/*it=accomodations.iterator();
                            	while(it.hasNext()) {
                            		accomodation1=(Accomodation)it.next();
                            		System.out.println("ID:\t"+accomodation1.getId()+"\nType:\t"+
                            		accomodation1.getAccomodation()+"\nPrice:\t"+accomodation1.getPrice());
                            	
                            	}*/
                        	}break;// case 1 accomodation full view
                            	
                        	case 2:{
                        		accomodations=sel.selectAccomodation();
                            	
                        		//FALTA
                        		
                        		/*it=accomodations.iterator();
                            	while(it.hasNext()) {
                            		accomodation1=(Accomodation)it.next();
                            		System.out.println("\nType:\t"+accomodation1.getAccomodation());
                            	}*/
                        	}break;// case 2 names accomodation
                            	
                            case 3:{
                            	
                            	System.out.println("Insert a maximum price:\t");
                            	readString = console.readLine();
                            	int priceComp = Integer.parseInt(readString);
                            	accomodations=sel.selectAccomodation();
                            	
                            	
                            	
                            	/*it=accomodations.iterator();
                            	while(it.hasNext()) {
                            		accomodation1=(Accomodation)it.next();
                            		if(priceComp<=transport1.getPrice())
                            			System.out.println("\nType:\t"+accomodation1.getAccomodation());
                            	}*/
                            }break;	//case 3 view accomodation price
                            case 4:{
                            	System.out.println("Insert accomodation name:\t");
                            	readString = console.readLine();
                            	accomodations=sel.selectAccomodation();
                            	
                            	
                            	
                            	/*it=accomodations.iterator();
                            	while(it.hasNext()) {
                            		accomodation1=(Accomodation)it.next();
                            		if(readString.equalsIgnoreCase(accomodation1.getAccomodation())) {
                            			System.out.print("\nPeople inside:\t");
                            			ArrayList<Camper> aux=(ArrayList<Camper>) accomodation1.getCampers();
                            			for(Camper cam:aux) {
                            				System.out.print(cam.getName()+" ");
                            			}
                            			System.out.println("\nTotal:\t"+aux.size());
                            		}
                            			
                            	}*/
                            	
                        	}break;//case 4 mostrar el precio de una acomodacion introducida
                        	
                        	}//switch opciones view accomodation
                        	
                }break;//case 3 view accomodation
                        	
                        	
                            

                        case 4:{ //mostrar activities
                        	
                        	System.out.println("SELECT ONE OF THE FOLLOWING OPTIONS: "
                                    + "\n1) List all activities (Full view)\t"
                                    + "\n2) List all activities (Names only)\t"
                                    + "\n3) List all activities under a specific price"
                                    + "\nOption number: \t");
                        	
                        	readString = console.readLine();
                        	int optnum4 = Integer.parseInt(readString);
                        	
                        	
                        	switch (optnum4) {
                        	
                        	case 1:{
                        		activities=sel.selectActivity();
                        		for (Activity activity : activities) {
                        			System.out.println(activity);
                        		}
                        		
                            	/*it=activities.iterator();
                            	while(it.hasNext()) {
                            		activity1=(Activity)it.next();
                            		System.out.println("ID:\t"+activity1.getId()+"\nType:\t"+
                            		activity1.getActivity()+"\nPrice:\t"+activity1.getPrice()+
                            		"\nInstructor:\t"+activity1.getInst()+"\nMaterial Requiered:\t"+activity1.getMaterial().toString()+
                            		"\nNumber of Campers:\t"+activity1.getCampers().size());
                            	
                            	}*/
                        	}break;//case 1 listar full view actividades
                            	
                        	case 2:{
                        		activities=sel.selectActivity();
                            	it=activities.iterator();
                            	while(it.hasNext()) {
                            		activity1=(Activity)it.next();
                            		System.out.println("\nType:\t"+activity1.getActivity());
                            	}
                        	}break;
                            	
                            case 3:{
                            	
                            	System.out.println("Insert a maximum price:\t");
                            	readString = console.readLine();
                            	int priceComp = Integer.parseInt(readString);
                            	activities=sel.selectActivity();
                            	
                            	//FALTA
                            	
                            	/*it=activities.iterator();
                            	while(it.hasNext()) {
                            		activity1=(Activity)it.next();
                            		if(priceComp<=activity1.getPrice())
                            			System.out.println("\nType:\t"+activity1.getActivity());
                            	}*/

                        	}break;//case 3 mostrar actividad por precio
                        	
                        	}//switch de las 4 opciones
                        }break;//case 4 mostrar actividades

                        case 5:{ //mostrar material;
                        	
                        	System.out.println("SELECT ONE OF THE FOLLOWING OPTIONS: "
                                    + "\n1) List all Material (Full view)\t"
                                    + "\n2) List all Material (names only)\t"
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
                        		
                        		/*
                            	it=materials.iterator();
                            	while(it.hasNext()) {
                            		material1=(Material)it.next();
                            		System.out.println("ID:\t"+material1.getId()+"\nType:\t"+
                            		material1.getMaterial()+"\nPrice:\t"+material1.getPrice());
                            	
                            	}*/
                        	}break;//case 1 view full materials
                            	
                        	case 2:{
                        		materials=sel.selectMaterial();
                            	/*it=materials.iterator();
                            	while(it.hasNext()) {
                            		material1=(Material)it.next();
                            		System.out.println("\nType:\t"+material1.getMaterial());
                            	}*/
                        	}break;//case 2 listar nombres
                            	
                            case 3:{
                            	
                            	System.out.println("Insert a maximum price:\t");
                            	readString = console.readLine();
                            	int priceComp = Integer.parseInt(readString);
                            	materials=sel.selectMaterial();
                            	
                            	/*it=materials.iterator();
                            	while(it.hasNext()) {
                            		material1=(Material)it.next();
                            		if(priceComp<=material1.getPrice())
                            			System.out.println("\nType:\t"+material1.getMaterial());
                            	}*/
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
                        		}
                        	}break; //case 1 long instructor
                        			
                            	
                        	case 2:{
                        		instructors=sel.selectInstructor();
                        		//FALTA
                            	/*it=instructors.iterator();
                            	while(it.hasNext()) {
                            		instructor1=(Instructor) it.next();
                            		System.out.println("Name:\t"+instructor1.getName());
                            		}*/
                        		}break;//case 2 instructor names

                        	}//switch optnum6
                        	
                        	
                            }break; // case 6 view instructor
                    

                }//SWITCH OPCIONES VIEW: CAMPERS, TRANSPORT.......
              
             }break;//CASE 1 VIEW
                
//*******************************insert**************************************************		
                case 2: { //INSERT

                    System.out.println("WHAT WOULD YOU LIKE TO INSERT: "
                            + "1) Campers\n"
                            + "2) Transport\n" 
                            + "3) Accomodation\n"
                            + "4) Activities\n"
                            + "5) Material\n"
                            + "6) Instructor\n\n"
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
        						camper1.setPhonenumber(Integer.parseInt(readString));
        					
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
        						}
        					}while(readString.isEmpty()&&telephone.isEmpty());
         
        				System.out.println("Insert the payment method you will use: ");
        				System.out.println("1.VISA  2.MASTERCARD  3. CASH");
        				  do {  
                              readString = console.readLine();
                              if(readString.isEmpty()) {
                              	System.out.println("You have to introduce a paymentmethod. Try again: ");
                              readString = console.readLine();
                              }else {
                              camper1.setPayment_method(readString);
                              }
                              }while(readString.isEmpty());
        			   
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
                    		System.out.println("Introduce the name of the one you want.");
                    		readString = console.readLine();
                    		Transport trans1 = ser.SearchTransport(readString);
                    		in.insertTransInC(camper1, trans1);
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
                    		readString = console.readLine();
                    	    Integer accomid = Integer.parseInt(readString);
                    		Accomodation accomodation = ser.SearchAccomodation(accomid);
                    		in.insertAccomInC(camper1, accomodation);
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
                    			readString = console.readLine();
                    			Activity activity = ser.SearchActivity(Integer.parseInt(readString));
                    			in.insertCamper_activity(camper1, activity);
                    			System.out.println("Would you want another activity? (Y/N");
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
                    			Material mat = ser.SearchMaterial(Integer.parseInt(readString));
                    			in.insertCamper_material(camper1, mat);
                    			System.out.println("Would you want another material? (Y/N");
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
                       
                        	Transport transport = new Transport();
                        	do {
                        	readString = console.readLine();
                        	
                        	
                        		if(ser.SearchTransport(readString).getType_transport()==NULL) {
                        		    transport.setType_transport(readString);
                        			h = true;
                        		}else {
                        			System.out.println("The name you have introduce exit. Insert a different one.");
                        			h = false;
                        		}
                        		
                        	}while(h==false);
                        	
                        	System.out.println("Insert the price:");
                        	readString = console.readLine();
                        	Integer price = Integer.parseInt(readString);
                        	transport.setPrice(price);
                        	//NO ME VA.
                        	create.createTransport(transport);
   
                            break;

                        case 3: 
                        	
                        	System.out.println("Insert the name of the accomodation");
                        
                        	Accomodation accomodation = new Accomodation();
                        	do {
                        	readString = console.readLine();
                        	
                        		if(ser.SearchAccomodation(readString).getAccomodation()==NULL) {
                        			accomodation.setAccomodation(readString);
                        			h = true;
                        		}else {
                        			System.out.println("The name you have introduce exit. Insert a different one.");
                        			h = false;
                        		}
                        		
                        	}while(h==false);
                        	
                        	System.out.println("Insert the price:");
                        	readString = console.readLine();
                        	accomodation.setPrice(Integer.parseInt(readString));
                        	in.insertAccomodation(accomodation);
                        	
                            break;

                        case 4: 
                        	System.out.println("Insert the name of the activity");
                         Activity activity = new Activity();
                        	do {
                        	readString = console.readLine();
                        	
                        		if((ser.SearchActivity(readString)).getActivity()==NULL) {
                        			activity.setActivity(readString);
                        			h = true;
                        		}else {
                        			System.out.println("The name you have introduce exit. Insert a different one.");
                        			h = false;
                        		}
                        		
                        	}while(h==false);
                        	
                        	System.out.println("Insert the price:");
                        	readString = console.readLine();
                         activity.setPrice(Integer.parseInt(readString));
                         in.insertActivity(activity);
                         
                         System.out.println("These are the instructors:");
                         instructors = sel.selectInstructor();
                         if(instructors.isEmpty()) {
                        	 System.out.println("There are any instructors available");
                         }else {
                         for(Instructor inst: instructors) {
                 			System.out.println(inst);
                 		}
                         do {
                         System.out.println("Introduzca el id of the instructor, who is going to be in charge of the activity:");
                         readString = console.readLine();
                         if(readString.isEmpty()){
                        	 System.out.println("The activity must have an instructor, choose one:");
                         readString = console.readLine();
                         }else {
                        	 
                        	 instructor1 = ser.SearchInstructor(Integer.parseInt(readString));
                         in.insertInstructorInA(instructor1, activity);
                        	
                         }
                         
                         }while(readString.isEmpty());
                         
                          }
                         
                         break;

                        case 5: 
                        {
                        	System.out.println("Insert the name of the material");
                        Material mat = new Material();
                     	do {
                      	readString = console.readLine();
                    	
                    		if(ser.SearchMaterial(readString).getMaterial()==NULL) {
                    			mat.setMaterial(readString);
                    			h = true;
                    		  }else {
                    			System.out.println("The name you have introduce exits. Insert a different one.");
                    			h = false;
                    		        }
                    		
                      	}while(h==false);
                    	
                    	System.out.println("Insert the price:");
                    	readString = console.readLine();
                     mat.setPrice(Integer.parseInt(readString));
                    	create.createMaterial(mat);
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
        				
        			    in.insertInstructor(instructor1);
        				
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
                    		System.out.println("Introduce the name of the one you want.");
                    		readString = console.readLine();
                    		Transport trans1 = ser.SearchTransport(readString);
                    		in.insertTransInI(instructor1, trans1);
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
                    		readString = console.readLine();
                    	    Integer accomid = Integer.parseInt(readString);
                    		accomodation = ser.SearchAccomodation(accomid);
                    		in.insertAccomInI(instructor1, accomodation);
                    	}
                    }
                    
                    	System.out.println("The instructor must be incharge of an activity.");
                    		
                    		activities = sel.selectActivity();
                    		if(activities.isEmpty()) {
                    			System.out.println("No activities yet");
                    		}else {
                    			
                    			for(Activity act : activities) {
                    				System.out.println(act);
                    			}
                    			do {
                    			System.out.println("Introduce the id of the activity wanted:");
                    			readString = console.readLine();
                    			activity = ser.SearchActivity(Integer.parseInt(readString));
                    			in.insertInstructorInA(instructor1, activity);
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
                    }
                }
                break;

//*******************************modify****************************************************		
                case 3: //modify
                    System.out.println("WHERE WOULD YOU LIKE TO MODIFY: "
                            + "1) Campers"
                            + "2) Transport" //DUDA 
                            + "3) Accomodation"//DUDA
                            + "4) Activities"//DUDA
                            + "5) Material"//DUDA
                            + "6) Instructor"//DUDA
                            + ""
                            + "Option number: ");

                    readString = console.readLine();
                    int optionNumberModify = Integer.parseInt(readString);

                    switch (optionNumberModify) {

                        case 1: {//campers
                            System.out.println("WHAT WOULD YOU LIKE TO MODIFY: "
                                    + "1) Name"
                                    + "2) Date of Birth"
                                    + "3) Nationality"
                                    + "4) NIF"
                                    + "5) Phone Number"
                                    + "6) Email"
                                    + "7) Payment method"
                                    + "8) Transport"
                                    + "9) Accomodation"
                                    + "10) Activity"
                                    + ""
                                    + "Option number: ");

                            readString = console.readLine();
                            int optionNumberModifyCamper = Integer.parseInt(readString);

                            switch (optionNumberModifyCamper) {

                                case 1: //mod name
                                    break;

                                case 2: //mod date of b
                                    break;

                                case 3: //mod nation
                                    break;

                                case 4: // mod nif
                                    break;

                                case 5: //mod phone
                                    break;

                                case 6: //mod email
                                    break;

                                case 7: //mod pay
                                    break;

                                case 8: //mod transp	
                                    break;

                                case 9: //mod acc
                                    break;

                                case 10: //mod act
                                    break;
                            }

                        }
                        break;

                        case 2: //trans
                            break;

                        case 3: //acc
                            break;

                        case 4: //acti
                            break;

                        case 5: //mat
                            break;

                        case 6: //instr
                            break;

                    }
                    break;

                case 4: //delete
                {
                    System.out.println("WHAT WOULD YOU LIKE TO DELETE:\n "
                            + "1) Campers\n"
                            + "2) Transport\n" 
                            + "3) Accomodation\n"
                            + "4) Activities\n"
                            + "5) Material\n"
                            + "6) Instructor\n"
                            + "Option:");

                    readString = console.readLine();
                    optionNumberModify = Integer.parseInt(readString);

                    switch (optionNumberModify) {

                        case 1: {
                        System.out.println("Insert the campers name and surname");
                        List<Camper> list=sel.selectCamperbyName(console.readLine());
                        for (int i = 0; i < list.size(); i++) {
							System.out.println(list.get(i).showNamePhone());
						}
                        System.out.println("Select the id from the camper to be deleted:");
                        int num=Integer.parseInt(console.readLine());
                        del.deleteCamperIdfromA(num);
                        del.deleteCamperIdfromM(num);
                        del.deleteCamperId(num);
                        }
                        break;

                        case 2: {
                        	//no funciona, tengo que pensarlo
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
                        	List<Accomodation> accomodation = sel.selectAccomodation();
                        	if(accomodation.isEmpty()) {
                        	System.out.println("There is any accomodations available to delete. Sorry");
                        	}else {
                        		for(Accomodation accom: accomodation) {
                        			System.out.println(accom);
                        		}
                        	}
                        	System.out.println("Insert the id of the transport that you want to delete:");
                        	int num=Integer.parseInt(console.readLine());
                        	//sel.selectTnsC(num);
                        	del.deleteAccomodationID(num);
                        	}
                            break;

                        case 4: //activity funciona
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
                        	//material funciona
                        {
                        	List<Material> material = sel.selectMaterial();
                        	if(material.isEmpty()) {
                        	System.out.println("There is any material available to delete. Sorry");
                        	}else {
                        		for(Material mat: material) {
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

                        case 6: //delete instructor funciona
                        {
                        instructors = sel.selectInstructor();
                        	
                        	if(instructors.isEmpty()) {
                        	System.out.println("There is any instructor available to delete. Sorry");
                        	}else {
                        		for(Instructor inst:instructors) {
                        			System.out.println(inst);
                        		}
                        	}
                        	System.out.println("Insert the id of the instructor that you want to delete:");
                        	int num=Integer.parseInt(console.readLine());
                        	del.deleteInstructorID(num);
                        	// HAY QUE ELIMINAR TB EL 

                        }
                            break;

                    }
                    break;

                }

            
        }//switch todas las opciones: view, insert,.....
                
            }catch(IOException ex) {
            	ex.printStackTrace();
            }
        
	
    	
			}while(optionNumber!=5);
			
	}//LLAVE DEL MAIN!!!!!!!!!!!!!!!!!!!!!!!!!!!

	private static LocalDate checkDate(String readString) {
		// TODO Auto-generated method stub
		return null;
		}
	
	
	}

