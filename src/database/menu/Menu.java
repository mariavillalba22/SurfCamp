package database.menu;

import java.io.*;

public class Menu {
//
    public static void main(String[] args) {
        try {

            System.out.println("SELECT AN OPTION: "
                    + "1) VIEW"
                    + "2) INSERT" // a partir de aqui hay q comprobar si hay algo
                    + "3) MODIFY"
                    + "4) DELETE"
                    + ""
                    + "Option number: ");

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String readString = console.readLine();
            int optionNumber = Integer.parseInt(readString);

            /*List strings = new ArrayList(String);
		strings.add("VIEW");
		strings.add("INSERT");
		int choice = printMenu(strings)*/ //CONSIDER
<<<<<<< HEAD
		
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
=======
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
>>>>>>> branch 'master' of https://github.com/mariavillalba22/SurfCamp

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

                    System.out.println("WHERE WOULD YOU LIKE TO INSERT: "
                            + "1) Campers"
                            + "2) Transport" //DUDA 
                            + "3) Accomodation"//DUDA
                            + "4) Activities"//DUDA
                            + "5) Material"//DUDA
                            + "6) Instructor"//DUDA
                            + ""
                            + "Option number: ");

                    readString = console.readLine();
                    int optionNumberInsert = Integer.parseInt(readString);
//+++++++++++++++++++++++++++++++++++++++ins camper+++++++++++++++++++++++++++++++++++++++++++			
                    switch (optionNumberInsert) {
                        case 1: {//ins campers

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

                            readString = console.readLine();
                            optionNumberInsert = Integer.parseInt(readString);

                            switch (optionNumberInsert) {
//-----------------------------ins name-----------------------------------------------				
                                case 1: //ins name
                                    break;

                                case 2: // ins date of birth
                                    break;

                                case 3: // ins nationality
                                    break;

                                case 4: //ins NIF
                                    break;

                                case 5: //ins phone
                                    break;

                                case 6: //ins email
                                    break;

                                case 7: //ins payment method
                                    break;

                                case 8: // transport
                                    break;

                                case 9: //ins accomodation
                                    break;

                                case 10: //ins activity
                                    break;

                            }

                        }
                        break;

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
                    System.out.println("WHERE WOULD YOU LIKE TO DELETE: "
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
                            System.out.println("WHAT WOULD YOU LIKE TO DELETE: "
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

                                case 1: //delete name
                                    break;

                                case 2: //delete date of b
                                    break;

                                case 3: //delete nation
                                    break;

                                case 4: // delete nif
                                    break;

                                case 5: //delete phone
                                    break;

                                case 6: //delete email
                                    break;

                                case 7: //delete pay
                                    break;

                                case 8: //delete transp	
                                    break;

                                case 9: //delete acc
                                    break;

                                case 10: //delete act
                                    break;
                            }

                        }
                        break;

                        case 2: //delete trans
                            break;

                        case 3: //delete acc
                            break;

                        case 4: //delete acti
                            break;

                        case 5: //delete mat
                            break;

                        case 6: //delete instr
                            break;

                    }
                    break;

                }

	}catch(IOException ex)
	{}

<<<<<<< HEAD
}}
=======
    }
}

>>>>>>> branch 'master' of https://github.com/mariavillalba22/SurfCamp
