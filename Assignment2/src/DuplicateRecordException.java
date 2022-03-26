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
public class DuplicateRecordException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * constructor class with String argument
	 * @param message
	 */
	public DuplicateRecordException(String message) {
		super(message);
	}
	
	/**
	 * default constructor for the class
	 */
	public DuplicateRecordException() {
		super("Error: This record already exists.");
	}

}
