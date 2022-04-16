/**
 * Tavtej Singh Lehri
 * StudentID - 40121745
 * Assignment3
 * 
 * @author tavtejsingh
 */
package comp6481_assignment3;
import java.util.*;
import java.io.*;

/**
 * Driver file of the program
 *
 */
public class ProcessWhishList {
	
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Main method
	 * @param args
	 * @throws DuplicateRecordException
	 */
	public static void main(String[] args) throws DuplicateRecordException {
		System.out.println("WELCOME TO THE TV SHOW LIST PROGRAM");
		System.out.println("===================================\n");
		Scanner show1 = null;
		BufferedReader reader;
		
		/**
		 * Use to open TVGuide.txt file. FileNotFoundException is Handeled here
		 */
		try {
			show1 = new Scanner(new FileInputStream("TVGuide.txt"));
		}catch(FileNotFoundException e) {
			String error = e.getMessage();
			System.out.println(error + "\nTerminating the program");
			System.exit(0);
		}
		
		/**
		 * 2 empty showList lists sList1 and sList2
		 */
		ShowList sList1 = new ShowList();
		ShowList sList2 = null;
		Show show = null;
		
		/**
		 * the records in the TVGuide.txt file are read and stored in the sList1
		 * first the first 3 letters of the channel is read as format of all the channels is XXX123
		 * the string is split on white space and lines
		 * duplicateRecordException is handeled here
		 */
		while(show1.hasNextLine()) {
			String sRead = show1.nextLine();
			if(sRead.contains("CBS")||sRead.contains("PBS")
					||sRead.contains("ABC")||sRead.contains("NBC")
					||sRead.contains("FOX")) {
				String[] s1 = sRead.split("\\s+");
				String showID = s1[0];
				String showName = s1[1];
				
				sRead = show1.nextLine();
				String[] s2 = sRead.split("\\s+");
				String startTime = s2[1];
				double sTime = Double.parseDouble(startTime);
				
				sRead = show1.nextLine();
				String[] s3 = sRead.split("\\s+");
				String endTime = s3[1];
				double eTime = Double.parseDouble(endTime);
				
				show = new Show(showID, showName, sTime, eTime);
				if(!sList1.contains(show.getShowID())) {
					sList1.addToStart(show);
				}
			}
		}
		show1.close();
		
		/**
		 * Part c
		 * ArrayLists watched and Scheduled are used.
		 * watched is used to store the shows mentioned under the Watching category in Interesr.txt file
		 * scheduled is used to store the Wishlist content
		 * 
		 * nested if loop is used to read the Wishlist content and present the output accordingly in console
		 */
		try {
			File showInterest = new File("Interest.txt");
			reader = new BufferedReader(new FileReader(showInterest));
			
			ArrayList<String> watched = new ArrayList<String>();
			ArrayList<String> scheduled = new ArrayList<String>();
			
			String inputString = reader.readLine();
			
			while(inputString != null && !inputString.equals("Wishlist")) {
				inputString = reader.readLine();
				if(inputString != null && !inputString.equals("Wishlist"))
					watched.add(inputString);
			}
			
			while(inputString != null) {
				if(inputString.equals("Wishlist")) {
					inputString = reader.readLine();
				}
				if(inputString != null) {
					scheduled.add(inputString);
					inputString = reader.readLine();
				}
				
			}
			
			Show seen = null;
			Show planned = null;
			int count = 0;
			
			for(int i = 0; i< scheduled.size(); i++) {
				planned = sList1.find(scheduled.get(i)).getShow();
				for(int j=0; j<watched.size(); j++) {
					seen = sList1.find(watched.get(j)).getShow();
					
					if(planned.isOnSameTime(seen).equals("Time Clash")) {
						System.out.println("User cannot watch the show " + planned.getShowID() + " as he/she will begin another show at the same time.");
						break;
					}else if(planned.isOnSameTime(seen).equals("Time Overlap")) {
						System.out.println("User can't watch show " + planned.getShowID() + " as he/she is not finished with a show he/she is watching.");
						break;
					}else {
						count++;
						if(count == 2) {
							System.out.println("User can watch the show " + planned.getShowID() + " as he/she is not watching anything else during that time.");
						}
					}
				}
			}
			reader.close();	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * User will be prompted to enter the showIDs until they press an extra enter
		 * The space will be read as empty and program will be exited.
		 * Console will print all the details of the show using toString method from the Show class
		 */
		System.out.println("\n===================================");
		System.out.println("Please enter the showID: ");
		String showId = null;
		while(!(showId = sc.nextLine()).isEmpty()) {
			
			if(sList1.find(showId) != null) {
				
				System.out.println(sList1.find(showId).getShow().toString());
				System.out.println("Iterations performed to find the show: " + sList1.count);
			}else {
				System.out.println("The showID you have entered is inValid");
			}
			//System.out.println();
			System.out.println("------------------------------------------------------------");
			System.out.println("Please enter the showID or press Enter and move to testing: ");	
		}
		
		
		/**
		 * Part e -- testing the methods and constructors
		 */
		System.out.println("\n===================================");
		System.out.println("Testing the constructors and methods");
		
		/**
		 * Testing all the methods and constructors
		 * Create 3 Shows
		 */
		System.out.println("Enter first show ID: ");
		String showID01 = sc.next();
		ShowList.ShowNode sNode1 = sList1.find(showID01);
		
		System.out.println("Enter second show ID: ");
		String showID02 = sc.next();
		ShowList.ShowNode sNode2 = sList1.find(showID02);
		
		System.out.println("Enter third show ID: ");
		String showID03 = sc.next();
		ShowList.ShowNode sNode3 = sList1.find(showID03);
		
		Show show01 = sNode1.getShow();
		Show show02 = sNode2.getShow();
		Show show03 = sNode3.getShow();
		
		System.out.println("\nisOnSameTime Test:");
		System.out.println("===================================");
		System.out.println("timeTest1: To test showtime of " + show01.getShowID() + " and " + show02.getShowID());
		System.out.println(show01.isOnSameTime(show02));
		System.out.println();
		System.out.println("timeTest2: To test showtime of " + show01.getShowID() + " and " + show03.getShowID());
		System.out.println(show01.isOnSameTime(show03));
		System.out.println();
		System.out.println("timeTest3: To test showtime of " + show03.getShowID() + " and " + show02.getShowID());
		System.out.println(show03.isOnSameTime(show02));
		
//		System.out.println("===================================\n");
		System.out.println("\nTesting the Course List class and it's constructors and methods:");
		System.out.println("===================================");
		
		sList2 = new ShowList();
		System.out.println("toString() test on the sList2: ");
		System.out.println(sList2.toString());
		
		System.out.println("\nInsert at index test on sList2: ");
		sList2.insertAtIndex(show01, 0);
		System.out.println(sList2.toString());
//		sList2.insertAtIndex(show01, 1);
//		System.out.println(sList2.toString());
		
		System.out.println("Contains method test for sList2: ");
		System.out.println("Does list sList2 contain showId for show01?: " + sList2.contains(show01.getShowID()));
		System.out.println("Does list sList2 contain showId for show02?: " + sList2.contains(show02.getShowID()));
		
		System.out.println("\ndeleteFromStart method test for sList2: ");
		System.out.println("List Before:");
		System.out.println(sList2.toString());
		sList2.deleteFromStart();
		System.out.println("List After:\n" + sList2.toString());
		
		System.out.println("\nTesting addToStart method: ");
		sList2.addToStart(show01);
		System.out.println(sList2.toString());
		sList2.addToStart(show02);
		System.out.println(sList2.toString());
		
		System.out.println("Copy constructor test: ");
		ShowList sList3 = new ShowList(sList2);
		System.out.println(sList3.toString());
		
		System.out.println("Equals method test: ");
		System.out.println(sList2.equals(sList2));
		
		System.out.println("\nreplaceAtIndex method test and equals method test again: ");
		sList3.replaceAtIndex(show03, 1);
		System.out.println(sList3.toString());
		System.out.println(sList3.equals(sList2));
		
		System.out.println("deleteAtIndex method test: ");
		sList3.deleteFromIndex(0);
		System.out.println(sList3.toString());
		
		System.out.println("Thank you for using the program!!!!");
		
		sc.close();

	}

}
