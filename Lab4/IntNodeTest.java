package Lab4;

public class IntNodeTest {

	public static void main(String[] args) {
		
		//IntNode instance
		IntNode test = new IntNode();
		System.out.println(test.getData());
		System.out.println(test.getLink());
		test.addNodeAfterThis(3);
		test.addNodeAfterThis(5);
		test.listLength();
		System.out.println(test.toString());
/*
		//addNodeAfterThis() method
		test.addNodeAfterThis(3);
		test.toString();
		test.addNodeAfterThis(5);
		test.toString();
		
		//removeNodeAfterThis() method
		test.removeNodeAfterThis();	
		test.toString();
		
		//listLength() method
		System.out.println(IntNode.listLength(test));
		
		//search() method
		System.out.println(IntNode.search(test, 3));
*/
		
		
	}//end of main method

}//end of IntNodeTest class
