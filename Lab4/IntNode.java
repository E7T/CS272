package Lab4;

public class IntNode {
	
	//instance variables
	private int data;
	private IntNode link;
	
	/*
	 * Default Constructor
	 * function: Set instance variables to a default value
	 * @parameters: none
	 * @precondition: none
	 */
	public IntNode() {
		data = 0;
		link = null;
	}//end of default constructor
	
	/*
	 * constructor method used for referencing 
	 * function: Used for referencing a certain node
	 * @parameters: int _data, IntNode _node
	 * @precondition: none
	 */
	public IntNode(int _data, IntNode _node) {
		
	}//end of IntNode() constructor method
	
	public int getData() {
		return data;
	}//end of getData()
	
	public void setData(int _data) {
		data = _data;
	}//end of setData()
	
	public IntNode getLink() {
		return link;
	}//end of getLink()
	
	public void setLink(IntNode _link) {
		link = _link;
	}//end of setLink()
	
	/*
	 * toString() 
	 * function: return a String of the linked list based on the head
	 * @parameters: none
	 * @precondition: none
	 */
	public String toString() {
		while(this.getLink() != null) {
			return "" + this.getData() + "->";
		}//end of head
		return "\n";
	}//end of toString() method
	
	/*
	 * addNodeAfterThis()
	 * function: add a new IntNode to the list in front of the given node
	 * @parameters: int newdata that hold the value for the new node
	 * @precondition: none
	 */
	public void addNodeAfterThis(int newdata) {
		this.link = new IntNode(newdata, this.link);
	}//end of addNodeAfterThis() method
	
	/*
	 * removeNodeAfterThis()
	 * function: remove the node in front of the given node
	 * @parameters: none
	 * @precondition: link must not equal null
	 */
	public void removeNodeAfterThis() {
		IntNode sel = new IntNode(this.getLink().getData(), this.getLink());
		if(sel.getLink() != null)
			this.setLink(sel.getLink().getLink());
	}//end of addNodeAfterThis() method
	
	/*
	 * listLength()
	 * function: goes through the list to determine the length
	 * @parameters: the head to determine where to start
	 * @precondition: link must not equal null
	 */
	public static int listLength(IntNode head) {
		int listCount = 0;
		while(head.getLink() != null) {
			listCount++;
			head.setLink(head.getLink().getLink());
		}//end of while
		return listCount;
	}//end of listLength() method
	
	/*
	 * search()
	 * function: goes through the list to determine if a given value is present
	 * @parameters: IntNode head to know where to start, int for the data to look for
	 * @precondition: link must not equal null
	 */
	public static boolean search(IntNode head, int data) {
		boolean found = false;
		if(head.getLink() != null) {
			while(head.getLink() != null) {
				if(head.getData() == data) {
					found = true;
				}//end of if
				head.setLink(head.getLink());
			}//end of while
		}//end of if
		return found;
	}//end of search() method
	
}//end of IntNode class
