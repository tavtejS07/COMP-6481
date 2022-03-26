//----------------------------------------------
//
// Assignment 2
// Tavtej Singh Lehri
// Written by: Tavtej Singh Lehri 40121745
//----------------------------------------------
/**
 * 
 * @author tavtejsingh
 *
 */
public class InvalidFileException extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = -7217218531676225849L;
	
	
	/**
	 * constructor class with String argument
	 * @param message
	 */
	public InvalidFileException(String message) {
		super(message);
	}
	
	/**
	 * default constructor for the class
	 */
	public InvalidFileException() {
		super("Error: Input file named XXX cannot be found.");
	}

}
