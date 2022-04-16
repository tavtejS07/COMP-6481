/**
 * Tavtej Singh Lehri
 * StudentID - 40121745 
 * COMP 6481 Assignment3
 * 
 * @author tavtejsingh
 */

package comp6481_assignment3;
import java.util.*;

public class Show implements Watchable {
	
	private String showID;
	private String showName;
	private double startTime;
	private double endTime;
	
	/**
	 * Default Constructor
	 */
	public Show() {
		
	}
	
	/**
	 * Parameterized Constructor
	 * @param showID -- Unique ID of the Show
	 * @param showName -- Name of the Show
	 * @param startTime -- Show start time
	 * @param endTime -- Show end time
	 */
	public Show(String showID, String showName, double startTime, double endTime) {
		this.showID = showID;
		this.showName = showName;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	/**
	 * Copy constructor
	 * @param show -- show object
	 * @param showID -- unique show ID
	 */
	public Show(Show show, String showID) {
		this.showID = showID;
		this.showName = show.showName;
		this.startTime = show.startTime;
		this.endTime = show.endTime;
	}
	
	/**
	 * This method will prompt the user to enter a new showID, then creates and
	 * returns a clone of the calling object with the exception of the showID, which is assigned the
	 * value entered by the user
	 * @param enter
	 * @return
	 */
	public Show clone(Scanner enter) {
		System.out.println("Enter the clone Show ID:");
		String ID = enter.next();
		return new Show(this, ID);
	}
	
	
	/**
	 * to String method
	 */
	@Override
	public String toString() {
		return "showID: " + showID +
				"\nshowName: " + showName + 
				"\nstartTime: " + startTime + 
				"\nendTime: " + endTime + "\n";
	}
	
	/**
	 * Equals() method.
	 * Two shows are equal if they have the same attributes, with the exception of the showID
	 */
	public boolean equals(Object o) {
		if(o == null || this.getClass()!=o.getClass()) {
			return false;
		}else {
			Show s = (Show)o;
			return(this.showName == s.showName 
					&& this.endTime == s.endTime 
					&& this.startTime == s.startTime);
		}
	}

	@Override
	public String isOnSameTime(Show S) {
		if(this.startTime == S.startTime && this.endTime == S.endTime) {
			return "Time Clash";
		}else if(this.startTime >= S.startTime && this.endTime <= S.endTime) {
			return "Time Overlap";
		}else {
			return "Separate Timings";
		}
	}

	/**
	 * @return the showID
	 */
	public String getShowID() {
		return showID;
	}

	/**
	 * @param showID the showID to set
	 */
	public void setShowID(String showID) {
		this.showID = showID;
	}

	/**
	 * @return the showName
	 */
	public String getShowName() {
		return showName;
	}

	/**
	 * @param showName the showName to set
	 */
	public void setShowName(String showName) {
		this.showName = showName;
	}

	/**
	 * @return the startTime
	 */
	public double getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public double getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}
	
	

}
