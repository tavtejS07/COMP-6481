//----------------------------------------------
//
// Assignment 2
// Tavtej Singh Lehri
// Written by: Tavtej Singh Lehri 40121745
//----------------------------------------------
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
//import java.text.DateFormat;
import java.text.ParseException;

/**
 * 
 * @author tavtejsingh
 *
 */
public class SalesDatabase {
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Sales> salesArray = new ArrayList<>();
	//private static int index = 0;
	
	/**
	 * Display main menu to choose from
	 * @return
	 */
	public static String getMainMenu() {
		System.out.println("What  do  you  want  to  do?"
				+ "\n\t 1.  List all files."
				+ "\n\t 2.  Process the files"
				+ "\n\t 3.  Exit"
				+ "\n\t Please  enter  your  choice  >");
		return sc.next();
	}
	
	/**
	 * method to add record to salesArray
	 * @param sales
	 * @throws DuplicateRecordException
	 */
	public static void addRecord(Sales sales) throws DuplicateRecordException {
		salesArray.add(sales);	
	}
	
	/**
	 * this method is used to display the contents of the output file and display any duplicate record if we try to add the new record.
	 * 
	 * @param fis
	 * @throws InvalidFileException
	 * @throws ParseException
	 * @throws DuplicateRecordException
	 */
	public static void displayFileContents(FileReader fis) throws InvalidFileException, ParseException, DuplicateRecordException {
		BufferedReader bf = new BufferedReader(fis);
		
		String line;
		try {
			while((line = bf.readLine()) != null) {
				String[] info = line.split("\\s+");
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

				String dateInString = info[3];
				String shipDate = info[5];
				//System.out.println(dateInString);
				Date date = formatter.parse(dateInString);
				Date shipDate1 = formatter.parse(shipDate);
				
				Sales sales_input = new Sales(info[0], info[1], info[2].charAt(0), date, Long.parseLong(info[4]), shipDate1, 
						Integer.parseInt(info[6]), Float.parseFloat(info[7]), Float.parseFloat(info[8]), Double.parseDouble(info[9]), 
						Double.parseDouble(info[10]), Double.parseDouble(info[11]));
				
				Sales record = sequentialSearch(Long.parseLong(info[4]));
				//System.out.println("check" );
				
				if(record == null) {
					record = new Sales(sales_input);
					addRecord(record);
					
				}else {
					System.out.println("The record that you have entered below already exists:\n" + record.toString());
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * sequential search to search using the orderID and counting the iterations to get that orderID
	 * @param order_ID
	 * @return
	 */
	public static Sales sequentialSearch(long order_ID) {
		//long order = order_ID;
		for(int i = 0; i<salesArray.size(); i++) {
			if(salesArray.get(i).getOrder_ID() == order_ID) {
				System.out.println((i+1) + " steps are used to find order_ID " + order_ID);
				return salesArray.get(i);
			}
		}
		return null;
	}
	
	/**
	 * this method helps to create file structure log using recursion
	 * @param inFile
	 * @param inFolder
	 * @throws EmptyFolderException
	 * @throws InvalidFileException
	 */
	public static void structureLog(PrintWriter inFile, File inFolder) throws EmptyFolderException, InvalidFileException {
		
		File[] file_set = inFolder.listFiles((dir, name) -> !name.equals(".DS_Store"));

		
		if (file_set.length == 0) {
			throw new EmptyFolderException("Empty Folder.");
		}
		else {
			for (int i = 0; i < file_set.length; i++) { 
				
				File files = file_set[i];

				if (files.isDirectory() && files.exists()) {
					inFile.println("Directory: " + files.getAbsolutePath());
					structureLog(inFile, files);
				}

				else {
					if (files.isFile() && files.exists()) {	
						inFile.println("File: " + files.getAbsolutePath());
					} else {
						throw new InvalidFileException("Error: Input file named" + files.getName() + " cannot be found");
					}

				}

			}

			inFile.println("");

		}

	}
	
	public static void main(String[] args) throws InvalidFileException {
		
		String option = getMainMenu();
		
		PrintWriter log = null;
		Scanner logReader = null, fileReader = null;
		
		while(!option.equals("3")) {
			
			switch(option) {
			case "1":
				
				try { 
					
					log = new PrintWriter("log.txt"); 
					File dataFolder = new File("src/Data"); 
					
					if (dataFolder.listFiles() == null)
						throw new EmptyFolderException("Folder is empty."); 	
					
					structureLog(log, dataFolder);
					
				}

				catch (FileNotFoundException e) { 
					System.err.println(e.getMessage());
				}

				catch (EmptyFolderException e) {
					System.err.println(e.getMessage());
				}

				catch (InvalidFileException e) {
					System.err.println(e.getMessage());
				}

				finally {
					System.out.println("Content Written to Log File.\n");
					if (log != null)
						log.close();
				}
				
				break;

				
			case "2":
				//System.out.println("check");
				File file = new File("log.txt");
				if(!file.exists() || !file.isFile()) {
					throw new InvalidFileException("log.txt file does not exist");
				}
				//System.out.println("check");
				
				try(BufferedReader br = new BufferedReader(new FileReader(file))) {
					
					logReader = new Scanner(new FileInputStream("log.txt"));
					//System.out.println("check");
					//|| line.substring(0, 9).equals("Directory")
					//int lines = 0; 
					String line = br.readLine();
					while(line != null) {
						
						//line = logReader.nextLine();
						//System.out.println("HERE");
						if(line.length()>0) {
							//System.out.println(line.substring(0, 4));
							//if(line.substring(0,4).equals("File")) {
								String[] parts =  line.split(":");
								File fs = new File(parts[1].trim());
								if(!fs.exists()) {
									throw new InvalidFileException("File " + line + " cannot be found");
								}
								//System.out.println("HERE 1");
								if(fs.isFile()) {
									//System.out.print("HERE");
									System.out.println(fs.getAbsolutePath());
									FileReader br1 = new FileReader(fs);
									displayFileContents(br1);
									//addRecord(br1);
								}
								
								//System.out.print(displayFileContents(fs));
							//}
							
						}
						
						
						
						if(salesArray.size() > 0) {
							try(FileWriter fWriter = new FileWriter("src/output1.txt")){
								salesArray.forEach(s -> {
									try {
										fWriter.write(s.toString() + "\n");
									} catch(IOException e) {
										e.printStackTrace();									}
								});
							} catch(IOException e) {
								e.printStackTrace();
							}
						}
						
						line = br.readLine();
					}
					
					
				}
				
				catch (FileNotFoundException e) {
					e.printStackTrace();
					System.err.println("log file not found!");
				}

				catch (Exception e) {
					e.printStackTrace();
					System.err.println("Issue with output file");
				}

				break;
				
			case "3":
				break;
				
			default:
				System.out.println("incorrect option selected!!");
				break;
			}
			
			option = getMainMenu();
		}
		
		System.out.println("See Ya!!!!!");
	}

}
