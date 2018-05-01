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
    	
    
    	List<Transport> transports = new ArrayList();
    	List<Accomodation> accomodations = new ArrayList();
    	Integer optionNumber  = 0;
    	JPAconnect em=new JPAconnect();
    	em.connectiondb();
   
    	Boolean h;
    	DbManager d =new DbManager();

    	Connect c=new Connect();
    	c.connectiondb();

    	Insertion in=new Insertion(c.getConnectiondb());
    	Update up = new Update(c.getConnectiondb());
    	Delete del=new Delete(c.getConnectiondb());
    	Selection sel = new Selection(c.getConnectiondb());
    	Search ser = new Search(c.getConnectiondb());
    	
    	JPACreate create = new JPACreate(em.getEntityManager());
   
    	
    
    	do {
    		Camper camper1 = new Camper();
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

            /*List strings = new ArrayList(String);
		strings.add("VIEW");
		strings.add("INSERT");
		int choice = printMenu(strings)*/ //CONSIDER
            switch (optionNumber) {
//***********************************view*****************************************************		
                case 1: {// VIEW
                    System.out.println("WHAT WOULD YOU LIKE TO SEE: "
                            + "1) Campers"
                            + "2) Transport" // a partir de aqui hay q comprobar si hay algo
                            + "3) Accomodation"
                            + "4) Activities"
                            + "5) Material"
                            + "6) Instructor"
                            + ""
                            + "Option number: ");

                    readString = console.readLine();
                    int optionNumberView = Integer.parseInt(readString);

                    switch (optionNumberView) {
                        case 1: //Mostrar campers
                            break;
                        case 2: //Mostrar transporte
                            break;

                        case 3: //Mostrar acomodation
                            break;

                        case 4: //mostrar activities
                            break;

                        case 5: //mostrar material;
                            break;

                        case 6: //mostrar instructors
                            break;
                    }

                }
                break;
//*******************************insert**************************************************		
                case 2: { //INSERT

                    System.out.println("WHAT WOULD YOU LIKE TO INSERT: "
                            + "1) Campers"
                            + "2) Transport" 
                            + "3) Accomodation"
                            + "4) Activities"
                            + "5) Material"
                            + "6) Instructor"
                            + ""
                            + "Option number: ");

                    readString = console.readLine();
                    int optionNumberInsert = Integer.parseInt(readString);
//+++++++++++++++++++++++++++++++++++++++ins camper+++++++++++++++++++++++++++++++++++++++++++			
                    switch (optionNumberInsert) {
                        case 1: {//ins campers
                          
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
        				
                    System.out.println("Does the camper wants a transport? (Y/N)");  
                    readString= console.readLine();
                    if(readString.equals("Y")) {
                    	transports = sel.selectTransport();
                    	if(transports.isEmpty()) {
                    	System.out.println("There is any transport abailable. Sorry");
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
                    
                    System.out.println("Does the camper wants an accomodation? (Y/N)");  
                    readString= console.readLine();
                    if(readString.equals("Y")) {
                    	accomodations = sel.selectAccomodation();
                    	if(accomodations.isEmpty()) {
                    	System.out.println("There is any accomodation abailable. Sorry");
                    	}else {
                    		for(Accomodation acom: accomodations) {
                    			System.out.println(acom);
                    		}
                    		// TERMINAR
                    		System.out.println("Introduce the id of the one you want.");
                    		readString = console.readLine();
                    	    Integer accomid = Integer.parseInt(readString);
                    		Accomodation accomodation = ser.SearchAccomodation(accomid);
                    		in.insertAccomInC(camper1, accomodation);
                    	}
                    }
                    
                    break;
              
                        }
                   // Aqui queda lo delmmaterial y actividad pq nos faltan los selects y esas cosa
                  
                    
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
                        	create.createAccomodation(accomodation);
                            break;

                        case 4: //ins activities
                            //IGUAL
                            break;

                        case 5: //ins material;
                            //IGUAL
                            break;

                        
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

                        case 1: {//campers funciona
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

                        case 2: {//delete trans
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
                        		for(Accomodation accomodation1: accomodation) {
                        			System.out.println(accomodation1);
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
                        	List<Activity> activities = sel.selectActivity();
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
                        		for(Material materials: material) {
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
                        	List<Instructor> instructor = sel.selectInstructor();
                        	if(instructor.isEmpty()) {
                        	System.out.println("There is any instructor available to delete. Sorry");
                        	}else {
                        		for(Instructor instructors:instructor) {
                        			System.out.println(instructors);
                        		}
                        	}
                        	System.out.println("Insert the id of the instructor that you want to delete:");
                        	int num=Integer.parseInt(console.readLine());
                        	del.deleteInstructorID(num);

                        }
                            break;

                    }
                    break;

                }

            }
        } 
        catch(IOException ex) {
            	ex.printStackTrace();
            }
	
    	}while(optionNumber!=5);
        }

private static LocalDate checkDate(String readString) {
	// TODO Auto-generated method stub
	return null;
}
    }

