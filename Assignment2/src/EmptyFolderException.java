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
public class EmptyFolderException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -708777175476411118L;
	

	/**
	 * constructor class with String argument
	 * @param message
	 */
	public EmptyFolderException(String message) {
		super(message);
	}
	
	/**
	 * default constructor for the class
	 */
	public EmptyFolderException() {
		super("Error: Input directory named XXX cannot be found.");
	}

}
