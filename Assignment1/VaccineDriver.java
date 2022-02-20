//------------------------------------------
//Assignment 1
//@Tavtej Singh Lehri
//Written by: Tavtej Singh Lehri 40121745
//------------------------------------------

package comp6481_assignment1;

/**
 * This is driver file of the program
 * @author tavtejsingh
 *
 */
public class VaccineDriver {

	public static void main(String[] args) {
		Inventory inv = new Inventory(Display.getInventorySize());
		
		String option = Display.getMainMenu();
		int exitNum = 0;
		int exitNum2 = 0;
		
		while(!option.equals("5")) {
			
			switch(option) {
			case "1":
				/**
				 * Method to detect malicious activity. 12 tries of password.
				 */
				exitNum++;
				inv.addVaccine();
				if(exitNum == 4) {
					System.out.println("Program detected suspicious activities and will terminate immediately!");
					System.exit(0);
				}
				break;
				
			case "2":
				exitNum2++;
				inv.editVaccines();
				if(exitNum2 == 4) {
					System.out.println("Program detected suspicious activities and will terminate immediately!");
					System.exit(0);
				}
				break;
				
			case "3":
				inv.findVaccineByBrand(Display.getVaccineBrand());
				break;
				
			case "4":
				inv.findVaccineByPrice(Display.getVaccinePrice());
				break;
				
			default:
				break;
			}
			
			option = Display.getMainMenu();
		}
		
		System.out.println("See Ya!!!!!");

	}

}
