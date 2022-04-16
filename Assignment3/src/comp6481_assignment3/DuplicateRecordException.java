/**
 * Tavtej Singh Lehri
 * StudentID - 40121745
 * Assignment3
 * 
 * @author tavtejsingh
 */
package comp6481_assignment3;

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
