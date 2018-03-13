package database.menu;

import java.io.*;
import java.util.*;

public class Menu {

	public static void main (String [] args) {
	try{
		
		
		System.out.println("SELECT AN OPTION: "
				+ "1) VIEW"
				+ "2) INSERT" // a partir de aqui hay q comprobar si hay algo
				+ "3) MODIFY"
				+ "4) DELETE"
				+ ""
				+ "Option number: ");
		
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String readString = console.readLine();
		int optionNumber=Integer.parseInt(readString);
		
		/*List strings = new ArrayList(String);
		strings.add("VIEW");
		strings.add("INSERT");
		int choice = printMenu(strings)*/ //CONSIDER
		
		switch (optionNumber) {
		
		case 1 : {// VIEW
			System.out.println("WHAT WOULD YOU LIKE TO SEE: "
					+ "1) Campers"
					+ "2) Transport" // a partir de aqui hay q comprobar si hay algo
					+ "3) Accomodation"
					+ "4) Activities"
					+ "5) Material"
					+ "6) Instructor"
					+ ""
					+ "Option number: ");
			
			String readString2 = console.readLine();
			int optionNumberView=Integer.parseInt(readString2);
			
			switch (optionNumberView) {
			case 1 : //Mostrar campers
				break;
			case 2 : //Mostrar transporte
				break;
				
			case 3 : //Mostrar acomodation
				break;
				
			case 4 : //mostrar activities
				break;
				
			case 5 : //mostrar material;
				break;
				
			case 6 : //mostrar instructors
				break;
			}
			
		}break;
		
		case 2 :{//INSERT
			
			System.out.println("WHERE WOULD YOU LIKE TO INSERT: "
					+ "1) Campers"
					+ "2) Transport" //DUDA 
					+ "3) Accomodation"//DUDA
					+ "4) Activities"//DUDA
					+ "5) Material"//DUDA
					+ "6) Instructor"//DUDA
					+ ""
					+ "Option number: ");
			
			String readString3 = console.readLine();
			int optionNumberInsert=Integer.parseInt(readString3);
//********************************************************************************************			
			switch (optionNumberInsert) {
			case 1 : {//ins campers
				
				System.out.println("WHAT WOULD YOU LIKE TO INSERT: "
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
				
				String readString4 = console.readLine();
				int optionNumberInsert2=Integer.parseInt(readString4);
				
				switch (optionNumberInsert2) {
				
				case 1 : //ins name
					break;
				
				case 2: // ins date of birth
					break;
					
				case 3 : // ins nationality
					break;
					
				case 4 : //ins NIF
					break;
					
				case 5 : //ins phone
					break;
					
				case 6 : //ins email
					break;
					
				case 7 : //ins payment method
					break;
					
				case 8 : // transport
					break;
					
				case 9 : //ins accomodation
					break;
					
				case 10 : //ins activity
					break;
					
				} break;
							
				}break;
			}
//**********************************************************************************************				

			case 2 : //ins transporte
				break;
				
			case 3 : //ins acomodation
				break;
				
			case 4 : //ins activities
				break;
				
			case 5 : //ins material;
				break;
				
			case 6 : //ins instructors
				break;
			}
			
		}break;
			
	}	
			
		
		
		

	}catch(IOException ex)
	{}

}}
