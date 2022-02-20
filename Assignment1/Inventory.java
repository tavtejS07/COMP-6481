//------------------------------------------
//Assignment 1
//@Tavtej Singh Lehri
//Written by: Tavtej Singh Lehri 40121745
//------------------------------------------

package comp6481_assignment1;

public class Inventory {
	private int inv_Size;
	private Vaccine inventory[];
	
	/**
	 * Inventory constructor
	 * 
	 * @param inv_Size
	 */
	public Inventory(int inv_Size) {
		this.inv_Size = inv_Size;
		inventory = new Vaccine[inv_Size];
	}
	
	/**
	 * This method is to add a vaccine in the array
	 */
	public void addVaccine() {
		if(!Display.checkPassword()) {
			return;
		}
		
		int currentInventory = Vaccine.findNumberOfCreatedVaccined();
		int availability = inv_Size - currentInventory;
		
		if(availability <= 0) {
			System.out.println("Not enough space!!");
			return;
		}
		
		int toBeAdded = Display.numberOfVaccineToBeAdded(availability);
		
		while(toBeAdded > 0) {
			System.out.println("You can add " + toBeAdded + " more Vaccines.");
			inventory[Vaccine.findNumberOfCreatedVaccined()] = Display.addNewVaccine();
			toBeAdded--;
		}
	}
	
	/**
	 * This method will be used to edit the vaccine
	 */
	public void editVaccines() {
		if(!Display.checkPassword()) {
			return;
		}
		int vaccineCount = Display.getVaccineNumber();
		int currentVaccineCount = Vaccine.findNumberOfCreatedVaccined();
		
		if(vaccineCount >= 0 && vaccineCount < currentVaccineCount) {
			System.out.println("Vaccine #" + vaccineCount);
			System.out.println(inventory[vaccineCount]);
			Display.updateVaccineInfo(inventory[vaccineCount]);
		}
		else {
			if(Display.updateVaccineNotFound().equals("1")) {
				addVaccine();
			}
		}
	}
	
	/**
	 * This method is used to find the vaccines by brand
	 * @param brand
	 */
	public void findVaccineByBrand(Brand brand) {
		//System.out.println(Vaccine.findNumberOfCreatedVaccined());
		for(int i = 0; i < Vaccine.findNumberOfCreatedVaccined(); i++) {
			System.out.println("Inside findvaccine");
			if(inventory[i].getBrand().equals(brand)) {
				System.out.println("Vaccine#" + i);
				System.out.println("\n");
				System.out.println(inventory[i]);
				System.out.println("\n");
			}
		}
	}
	
	/**
	 * This method is used to find vaccine by price
	 * @param price
	 */
	public void findVaccineByPrice(double price) {
		for(int i = 0; i < Vaccine.findNumberOfCreatedVaccined(); i++) {
			if(inventory[i].getPrice_tag() < price) {
				System.out.println("Vaccine#" + i);
				System.out.println("\n");
				System.out.println(inventory[i]);
				System.out.println("\n");
			}
		}

	}

}
