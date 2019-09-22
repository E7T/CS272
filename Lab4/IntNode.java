package Lab4;

public class IntNode {
	
	//instance variables
	private int data;
	private IntNode link;
	
	/*
	 * Default Constructor
	 * function: Set instance variables to a default value
	 */
	public IntNode() {
		data = 0;
		link = null;
	}//end of default constructor
	
	/*
	 * constructor method used for referencing 
	 * function: Used for referencing a certain node
	 * @param _data
	 * 		int value to assign data instance variable
	 * @param _node
	 * 		IntNode reference for the next node, assigns to the current nodes link
	 */
	public IntNode(int _data, IntNode _node) {
		data = _data;
		link = _node;
	}//end of IntNode() constructor method
	
	
	/*
	 * getData() method
	 * 		Used for retrieving the node's data
	 * @return
	 * 		the return is the current nodes data
	 */
	public int getData() {
		return data;
	}//end of getData()
	
	/*
	 * setData() method
	 * 		Used for assigning the node's data
	 * @return
	 * 		the return is the current nodes data
	 * @param _data
	 * 		The value that will be used to assign the node's data
	 */
	public void setData(int _data) {
		data = _data;
	}//end of setData()
	
	/*
	 * getLink() method
	 * 		Used for retrieving the node's reference to the next node
	 * @return
	 * 		the return is the reference to the next node, if it is the end of the list it will be null
	 */
	public IntNode getLink() {
		return link;
	}//end of getLink()
	
	/*
	 * setLink() method
	 * 		Used for assigning the reference for the next node
	 * @param _link
	 * 		The value that will be used to reference the next node, if it is the end of the list it will be null
	 */
	public void setLink(IntNode _link) {
		link = _link;
	}//end of setLink()
	
	/*
	 * toString() 
	 * function: return a String of the linked list based on the head
	 * @return 
	 * 		A string containing a visual representation of the link between nodes
	 */
	public String toString() {
		String answer = data + "";
		IntNode cursor = link;
		while(cursor != null) {
			answer = answer +  "->" + cursor.data;
			cursor = cursor.link;
		}//end of head
		return answer;
	}//end of toString() method
	
	/*
	 * addNodeAfterThis()
	 * function: add a new IntNode to the list in front of the given node
	 * @param newdata 
	 * 		int value that will be used to set the data for the new node
	 */
	public void addNodeAfterThis(int newdata) {
		link = new IntNode(newdata, link);
	}//end of addNodeAfterThis() method
	
	/*
	 * removeNodeAfterThis()
	 * function: remove the node in front of the given node
	 * @precondition
	 * 		node's link must not equal null
	 */
	public void removeNodeAfterThis() {
		if(link != null) {
			link = link.link;
		}//end of if
	}//end of addNodeAfterThis() method
	
	/*
	 * listLength()
	 * function: goes through the list to determine the length
	 * @param head
	 * 		reference to the beginning of a list of nodes
	 * @precondition
	 * 		link must not equal null
	 */
	public static int listLength(IntNode head) {
		int listCount = 0;
		IntNode cursor = head;
		while(cursor != null) {
			listCount++;
			cursor = cursor.link;
		}//end of while
		return listCount;
	}//end of listLength() method
	
	/*
	 * search()
	 * function: goes through the list to determine if a given value is present
	 * @param head
	 * 		reference to the beginning of a list of nodes
	 * @param data
	 * 		int value that will be searched for in the list
	 * @precondition: link must not equal null
	 */
	public static boolean search(IntNode head, int data) {
		boolean found = false;
		IntNode cursor = head;
		while(cursor != null) {
			if(cursor.data == data) {
				found = true;
			}//end of if
			cursor = cursor.link;
		}//end of while
		return found;
	}//end of search() method
	
}//end of IntNode class
