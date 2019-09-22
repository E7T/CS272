package Lab4;

public class IntNodeTest {

	public static void main(String[] args) {
		
		//IntNode instance
		IntNode test = new IntNode();
		
		//get and set methods
		System.out.println(test.getData());
		System.out.println(test.getLink());
		
		//addNodeAfterThis() method
		test.addNodeAfterThis(5);
		test.addNodeAfterThis(7);
		test.addNodeAfterThis(3);
		test.addNodeAfterThis(10);
		test.addNodeAfterThis(2);		

		//toString() method
		System.out.println(test.toString());
		
		//removeNodeAfterThis();
		test.removeNodeAfterThis();

		//listLength() method
		System.out.println("What is the list length? " + IntNode.listLength(test));
		
		//search() method
		System.out.println("Is 2 in the list? " + IntNode.search(test, 2));

		//loop to check each node
		IntNode nodeCheck = test;
		int nodeCount = 0;
		while(nodeCheck != null) {
			System.out.printf("Node #%d- Data: %d\t Link: ", nodeCount, nodeCheck.getData());
			System.out.print(nodeCheck.getLink() + "\t");
			System.out.printf("listLength from this node: %d\n", IntNode.listLength(nodeCheck));
			nodeCount++;
			nodeCheck = nodeCheck.getLink();
		}//end of while
		
	}//end of main method

}//end of IntNodeTest class
