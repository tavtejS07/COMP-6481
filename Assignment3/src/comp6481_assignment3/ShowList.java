/**
 * Tavtej Singh Lehri
 * StudentID - 40121745
 * Assignment3
 * 
 * @author tavtejsingh
 */
package comp6481_assignment3;
import java.util.*;

public class ShowList {
	
	/**
	 * Inner Class Show Node
	 * @author tavtejsingh
	 *
	 */
	class ShowNode{
		private Show show;
		private ShowNode nextPointer;
		
		/**
		 * Default Constructor of Show Node class
		 */
		public ShowNode() {
			show = null;
			nextPointer = null;
		}
		
		/**
		 * Parameterized constructor of Show Node class
		 * @param show -- object of Show
		 * @param nxtPtr -- object of ShowNode
		 */
		public ShowNode(Show show, ShowNode nxtPtr) {
			this.show = show;
			this.nextPointer = nxtPtr;
		}
		
		/**
		 * Copy Constructor of ShowNode class
		 * @param SN -- object of Show Node
		 */
		public ShowNode(ShowNode SN) {
			this.show = SN.show;
			this.nextPointer = SN.nextPointer;
		}
		
		/**
		 * clone method
		 * @return Object of type ShowNode
		 */
		public Object clone() {
			return new ShowNode(this);
		}

		/**
		 * @return the show
		 */
		public Show getShow() {
			return show;
		}

		/**
		 * @param show the show to set
		 */
		public void setShow(Show show) {
			this.show = show;
		}

		/**
		 * @return the nextPointer
		 */
		public ShowNode getNextPointer() {
			return nextPointer;
		}

		/**
		 * @param nextPointer the nextPointer to set
		 */
		public void setNextPointer(ShowNode nextPointer) {
			this.nextPointer = nextPointer;
		}
	}
	
	private ShowNode head;
	private int size = 0;
	int count;
	
	/**
	 * Default Constructor for ShowList to create a list of size 0 and null head pointer
	 */
	public ShowList() {
		head = null;
		size = 0;
	}
	
	/**
	 * Copy Constructor of ShowList class which accepts object of ShowList and creates it's copies
	 * @param sList -- object of ShowList
	 */
	public ShowList(ShowList sList) {
		if(sList.head == null) {
			head = null;
		}else {
			ShowNode sNode1 = sList.head;
			ShowNode sNode2 = null;
			ShowNode sNode3 = null;
			
			while(sNode1 != null) {
				sNode3 = new ShowNode(sNode1.show, null);
				if(sNode2 == null) {
					head = sNode2 = sNode3;
				}else {
					sNode2.nextPointer = sNode3;
					sNode2 = sNode2.nextPointer;
				}
				sNode1 = sNode1.nextPointer;
			}
			sNode2 = sNode3 = null;
		}
		size = sList.size;
	}
	
	/**
	 * addToStart method creates a node that passes object of Show class and insert it at the head
	 * @param show -- object of Show class
	 */
	public void addToStart(Show show) throws DuplicateRecordException{
		head = new ShowNode(show, head);
		size++;
	}
	
	/**
	 * insertAtIndex method inserts a ShowNode with show object at index i
	 * @param show -- object of Show
	 * @param i -- index, starts at 0 and throws exception if it is OutOfBo
     * @throws DuplicateRecordException
	 */
	public void insertAtIndex(Show show, int i) throws DuplicateRecordException {
		if(i == 0) {
			addToStart(show);
		}else {
			try {
				if(i<0 || i>size-1) {
					throw new NoSuchElementException();
				}else {
					ShowNode sNode = head;
					for(int j=0; j<i-1; j++) {
						sNode = sNode.nextPointer;
					}
					sNode.nextPointer = new ShowNode(show, sNode.nextPointer);
				}
				size++;
			}
			catch(NoSuchElementException e) {
				String error = e.getMessage();
				System.out.println(error + "\nExiting the program");
				System.exit(0);
			}
		}
		
	}
	
	/**
	 * deletes the Show from the given index
	 * @param i -- index, if it does not exist then method throws NoSuchElementExist exception
	 */
	public void deleteFromIndex(int i) {
		if(head == null) {
			System.out.println("Empty List. Delete not possible");
			return;
		}else {
			try {
				if(i <0 || i>size-1) {
					throw new NoSuchElementException();
				}else {
					if(i == 0) {
						deleteFromStart();
					}else {
						ShowNode sNode = head;
						for(int j=0; j<i-1; j++) {
							sNode = sNode.nextPointer;
						}
						sNode.nextPointer = sNode.nextPointer.nextPointer;
					}
					size--;
				}
			}
			catch(NoSuchElementException e) {
				String error = e.getMessage();
				System.out.println(error + "\nExiting the program");
				System.exit(0);
			}
			
		}
	}
	
	/**
	 * deletes the head of the list
	 * @return true if deleted and false if the list is empty
	 */
	public boolean deleteFromStart() {
		if(head == null) {
			return false;
		}
		head = head.nextPointer;
		size--;
		return true;
	}
	
	/**
	 * replaces the current show at the given index i
	 * @param show -- object of Show class
	 * @param i -- index at which the insertion is to be made
	 */
	public void replaceAtIndex(Show show, int i) {
		if(head == null) {
			System.out.println("List is empty. Replacement is not possible");
			return;
		}
		if(i<0 || i>size-1) {
			System.out.println("IndexOutOfBounds");
			return;
		}else {
			ShowNode sNode = head;
			if(i == 0) {
				head = new ShowNode(show, head.nextPointer);
			}else {
				for(int j=0; j<i-1; j++) {
					sNode = sNode.nextPointer;
				}
				sNode.nextPointer = new ShowNode(show, sNode.nextPointer.nextPointer);
			}
		}
		
	}
	
	/**
	 * find the show corresponding to the shoID after searching from the whole list
	 * 
	 * @param showID -- unique ID of the show used to find the show
	 * @return If such an object is found,then the method returns a pointer to that ShowNode; otherwise, method returns null
	 */
	public ShowNode find(String showID) {
		ShowNode sNode = head;
		count = 0;
		
		while(sNode != null) {
			//System.out.println(showID);
			//System.out.println(sNode.show.getShowID());
			if(sNode.show.getShowID().equals(showID)) {
				//System.out.println("The number of iteration it took to find the show are: " + count);
				return sNode;
			}
			sNode = sNode.nextPointer;
			count++;
		}
		return null;
	}
	
	/**
	 * uses find() method to check whether the list contains that show or not
	 * @param showID -- unique id of the show
	 * @return true if the show with  that showID exists in the list else false
	 */
	public boolean contains(String showID) {
		ShowNode sNode = find(showID);
		if(sNode == null) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * checks the similarity of the lists, only uniqueness being the showID
	 * @param sList list use to compare
	 * @return true if the lsits are similar else false
	 */
	public boolean equals(ShowList sList) {
		if(this.size != sList.size) {
			return false;
		}
		else {
			boolean flag = true;
			ShowNode sNode1 = sList.head;
			ShowNode sNode2 = this.head;
			
			while(sNode1 != null && sNode2 != null) {
				if(!!sNode1.show.equals(sNode2.show)) {
					flag = false;
				}
				sNode1 = sNode1.nextPointer;
				sNode2 = sNode2.nextPointer;
			}
			return flag;
		}
	}
	
	/**
	 * Method to print the list contents
	 * @return list info in string format
	 */
	public String toString() {
		if(head == null) {
			return "empty list";
		}else {
			ShowNode sNode = head;
			
			while(sNode != null) {
				System.out.println(sNode.show.toString());
				sNode = sNode.nextPointer;
			}
			return "";
		}
	}

}
