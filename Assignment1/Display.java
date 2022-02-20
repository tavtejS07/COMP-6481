//------------------------------------------
//Assignment 1
//@Tavtej Singh Lehri
//Written by: Tavtej Singh Lehri 40121745
//------------------------------------------

package comp6481_assignment1;
//import java.util.ArrayList;
import java.util.Scanner;

public class Display {
	public static Scanner sc = new Scanner(System.in);
	private static String password = "password";
	
	/**
	 * Inventory Size
	 * @return
	 */
	public static int getInventorySize() {
		System.out.println("Welcome to Vaccine Inventory!!");
		System.out.println("Please enter the inventory size: ");
		return Integer.parseInt(sc.next());
	}
	
	/**
	 * Verify password
	 * @return
	 */
	public static boolean checkPassword() {
		
		/*
		 * int exitNum = 0;
		
		while(exitNum!=12) {
			int entry = 0;
			while(entry!=3) {
				System.out.println("Please enter the password: ");
				String input_pwd = sc.next();
				if(input_pwd.equals(password))
					return true;
				System.out.println("Incorrect Password. Try Again!!!!!");
				entry++;
				exitNum++;
			}
			if(exitNum == 12) {
				System.out.println("Program detected suspicious activities and will terminate immediately!");
				System.exit(0);
			}
			System.out.println("You've reached maximum tries. Redirecting to main menu.....");
		}
		
		return false;
		 */
		int entry = 0;
		while(entry!=3) {
			System.out.println("Please enter the password: ");
			String input_pwd = sc.next();
			if(input_pwd.equals(password))
				return true;
			System.out.println("Incorrect Password. Try Again!!!!!");
			entry++;
		}
		System.out.println("You've reached maximum tries. Redirecting to main menu.....");
		return false;
	}
	
	/**
	 * main menu display
	 * @return
	 */
	public static String getMainMenu() {
		System.out.println("What  do  you  want  to  do?"
				+ "\n\t 1.  Enter  new  vaccines  (password  required)"
				+ "\n\t 2.  Change  information  of  a  vaccine  (password  required)"
				+ "\n\t 3.  Display  all  vaccines  by  a  specific  brand"
				+ "\n\t 4.  Display  all  vaccines  under  a  certain  a  price."
				+ "\n\t 5.  Quit"
				+ "\n\t Please  enter  your  choice  >");
		return sc.next();
	}
	
	/**
	 * get the number of vaccines user wants to add.
	 * 
	 * @param space
	 * @return
	 */
	public static int numberOfVaccineToBeAdded(int space) {
		System.out.println("How many vaccines do you want to enter?");
		int countWanted = Integer.parseInt(sc.next());
		int countAllowed = 0;
		
		if(countWanted <= space) {
			countAllowed = countWanted;
		}
		else {
			countAllowed = space;
			System.out.println("You can only enter " + countAllowed + " vaccines.");
		}
		return countAllowed;
	}
	
	/**
	 * enter new vaccine info into the inventory.
	 * 
	 * @return
	 */
	public static Vaccine addNewVaccine() {
//		check this
		//System.out.println("Enter brand name: ");
		//Enum brand = Enum.valueOf(null, password);
		
		Vaccine vaccine = new Vaccine();
		int choice = -1;
		while(choice == -1) {
			System.out.println("Select the brand"
					+ "\n\t 1.Pfizer"
					+ "\n\t 2.Moderna"
					+ "\n\t 3.Johnson"
					+ "\n\t 4.Covishield"
					+ "\nEnter brand choice:");
			choice = sc.nextInt();
		}
		
		switch(choice) {
			case 1:
				vaccine.setBrand(Brand.pfizer);
				break;
			case 2:
				vaccine.setBrand(Brand.moderna);
				break;
			case 3:
				vaccine.setBrand(Brand.johnson);
				break;
			case 4:
				vaccine.setBrand(Brand.covishield);
				break;
		}
		
		System.out.println("Enter dosage: ");
		//String dose_value = sc.next();
		double dose = Double.parseDouble(sc.next());
		//double dose = sc.nextDouble();
		
		System.out.println("Enter the expiry date: ");
		String expiry_date = sc.next();
		
		System.out.println("Enter vaccine id: ");
		long id = Long.parseLong(sc.next());
		
		System.out.println("Enter the vaccine price: ");
		double price_tag = Double.parseDouble(sc.next());
		
		vaccine.setDose(dose);
		vaccine.setExpiry_date(expiry_date);
		vaccine.setId(id);
		vaccine.setPrice_tag(price_tag);
		return vaccine;
	}
	
	/**
	 * get vaccine number for updation
	 * @return
	 */
	public static int getVaccineNumber() {
		System.out.println("Enter the vaccine number: ");
		int vaccineNumber = Integer.parseInt(sc.next());
		return vaccineNumber;
	}
		
	/**
	 * 
	 * @param vac
	 * @return
	 */
	public static Vaccine updateVaccineInfo(Vaccine vac) {
		String option = "0";
		
		while(!option.equals("5")) {
			System.out.println("What information would you like to change?"
					+ "\n\t 1. Brand"
					+ "\n\t 2. Dose"
					+ "\n\t 3. Expiry"
					+ "\n\t 4. Price"
					+ "\n\t 5. Quit"
					+ "\n\t Enter your choice >");
			option = sc.next();
			
			switch(option) {
			case "1":
				/*
				 * check this piece
				 */
				System.out.println("Select the new brand"
						+ "\n\t 1.Pfizer"
						+ "\n\t 2.Moderna"
						+ "\n\t 3.Johnson"
						+ "\n\t 4.Covishield"
						+ "\nEnter brand choice:");
				int choice = sc.nextInt();
				switch(choice) {
					case 1:
						vac.setBrand(Brand.pfizer);
						break;
						
					case 2:
						vac.setBrand(Brand.moderna);
						break;
					
					case 3:
						vac.setBrand(Brand.johnson);
						break;
						
					case 4:
						vac.setBrand(Brand.covishield);
						break;
				
				}
				break;
			
			case "2":
				System.out.println("Enter the new dosage: ");
				vac.setDose(Double.parseDouble(sc.next()));
				break;
				
			case "3":
				System.out.println("Enter new Expiry date: ");
				vac.setExpiry_date(sc.next());
				break;
				
			case "4":
				System.out.println("Enter new Price: ");
				vac.setPrice_tag(Double.parseDouble(sc.next()));
				break;
				
			default:
				break;		
			}
		}
		
		return vac;
	}
	
	/**
	 * alternatives for user incase they enter wrong vaccine #
	 * @return
	 */
	public static String updateVaccineNotFound() {
		String selection = "0";
		
		while(!selection.equals("2")) {
			System.out.println("The entered vaccine number does not exist."
					+ "\nWhat do you want to do?"
					+ "\n\t 1. Enter another vaccine number?"
					+ "\n\t 2. Quit and return to main menu");
			selection = sc.next();
			if(selection.equals("1")) {
				return "1";
			}
		}
		return "2";
	}
	
	/**
	 * get vaccine brand for which user want to search the inventory
	 * 
	 * @return
	 */
	
	public static Brand getVaccineBrand() {
		System.out.println("Select the brand"
				+ "\n\t 1.Pfizer"
				+ "\n\t 2.Moderna"
				+ "\n\t 3.Johnson"
				+ "\n\t 4.Covishield"
				+ "\nEnter brand choice:");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			return Brand.pfizer;
			
		case 2:
			return Brand.moderna;
		
		case 3:
			return Brand.johnson;
			
		case 4:
			return Brand.covishield;
		
	  }
		return Brand.pfizer;
		
	}
	
	/**
	 * get vaccine price for which user want to search the inventory
	 * @return
	 */
	public static double getVaccinePrice() {
		System.out.println("Enter the price: ");
		return Double.parseDouble(sc.next());
	}
	
}

 
