package database.menu;

import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import database.Connect;
import database.DbManager;
import database.Delete;
import database.Insertion;
import database.Search;
import database.Selection;
import database.Update;
import database.JPA.JPACreate;
import database.JPA.JPARead;
import database.JPA.JPAconnect;
import database.pojo.*;

public class Menu {
//
    public static void main(String[] args) throws Exception {
    	
    
    	List<Transport> transports = new ArrayList();
    	List<Accomodation> accomodations = new ArrayList();
    	Integer optionNumber  = 0;
    	
    	DbManager d =new DbManager();
    	Connect c=new Connect();
    	Insertion in=new Insertion(c.getConnectiondb());
    	Update up = new Update(c.getConnectiondb());
    	Delete del=new Delete(c.getConnectiondb());
    	Selection sel = new Selection(c.getConnectiondb());
    	Search ser = new Search(c.getConnectiondb());
    	c.connectiondb();
    	
    
    	do {
    		Camper camper1 = new Camper();
        try {

            System.out.println("SELECT AN OPTION: "
                    + "1) VIEW"
                    + "2) INSERT" // a partir de aqui hay q comprobar si hay algo
                    + "3) MODIFY"
                    + "4) DELETE"
                    + "5) EXIT"
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
        			
                        }
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
                    		camper1.setTransports(trans1);
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
                    		Accomodation accomodationid = ser.SearchAccomodation(accomid);
                    		camper1.setAccomodation(accomodationid);
                    	}
                    }
                    
               in.insertCamper(camper1);
                   // Aqui queda lo delmmaterial y actividad pq nos faltan los selects y esas cosa
                  
                    
                    
                    
                    
                    
                     
                        
        					
                        

//+++++++++++++++++++++++++++++++++++++++++ins transport++++++++++++++++++++++++++++++++++++				
                        case 2: //ins transporte
                            //AQUI HACE FALTA CONECTARLO CON UN METODO QUE COMPARE
                            // SI ES UN TRANSPORTE O SI HAY QUE AÑADIRLO

                            break;

                        case 3: //ins acomodation
                            //IGUAL
                            break;

                        case 4: //ins activities
                            //IGUAL
                            break;

                        case 5: //ins material;
                            //IGUAL
                            break;

                        case 6: //ins instructors
                        {
                            System.out.println("What would you like to insert: "
                                    + "1) Name"
                                    + "2) Phone Number"
                                    + "3) Date of Birth"
                                    + "4) Nationality"
                                    + "5) Salary"
                                    + "6) Activity Taught");

                            readString = console.readLine();
                            optionNumberInsert = Integer.parseInt(readString);

                            switch (optionNumberInsert) {

                                case 1: // insertas el nombre
                                    break;

                                case 2: // insertas el numero
                                    break;
                                case 3: //insertas la fecha
                                    break;
                                case 4: //insertas nacionalidad
                                    break;
                                case 5: //insertas salario
                                    break;
                                case 6: //insertas la actividad que enseña
                                    break;

                            }
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
                    System.out.println("WHAT WOULD YOU LIKE TO DELETE: "
                            + "1) Campers"
                            + "2) Transport" //DUDA 
                            + "3) Accomodation"//DUDA
                            + "4) Activities"//DUDA
                            + "5) Material"//DUDA
                            + "6) Instructor"//DUDA
                            + ""
                            + "Option number: ");

                    readString = console.readLine();
                    optionNumberModify = Integer.parseInt(readString);

                    switch (optionNumberModify) {

                        case 1: {//campers
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

                        case 3: //delete acc
                        		
                            break;

                        case 4: {//delete acti
                        }
                            break;

                        case 5: //delete mat
                            break;

                        case 6: //delete instr
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

