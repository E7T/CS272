//CS272 - Lab2
//Employee.java
//program purpose: Create class object with constructors
//written by Edwin Torres
//date written: September 4, 2019


public class Employee {
		
	//Instance variables
	private String employeeName;
	private int employeeNo;
	private int employeeAge;
	private String employeeState;
	private int employeeZip;
	private int[] advisors;
	
	//Default constructor
	public Employee() {
		
		//initialize instance variables		
		employeeName = null;
		employeeNo = 0;
		employeeAge = 0;
		employeeState = null;
		employeeZip = 0;
		advisors = null;
		
	}//end of Employee default constructor
	
	//Copy Constructor
	public Employee(Object obj) {
		
		//precondition
		if((obj != null) && (obj instanceof Employee)) {
			Employee W = (Employee) obj;
			
			//copy primitive values
			employeeNo = W.employeeNo;
			employeeAge = W.employeeAge;
			employeeZip = W.employeeZip;
			
			//copy strings
			employeeName = new String(W.employeeName);
			employeeState = new String(W.employeeState);
			
			//copy int array using new int array
            advisors = new int[3];
			for(int i=0; i < W.advisors.length; i++) {
				advisors[i] = W.advisors[i];	
			}//end of for
			
		}//end of if
		else {
			return;
		}//end of else
		
	}//end of Employee copy constructor
	
	//Getters and Setters
	//Allow the assignment of instance variables, and the retrieval of them
	//parameters: none
	//preconditions: none
	
	public String getEmployeeName() {		
		return employeeName;	
	}//end of getEmployee
	
	public void setEmployeeName(String name) {		
		employeeName = name;	
	}//end of setEmployee
	
	public int getEmployeeNo() {	
		return employeeNo;		
	}//end of getEmployee
	
	public void setEmployeeNo(int number) {		
		employeeNo = number;	
	}//end of setEmployeeNo
	
	public int getEmployeeAge() {	
		return employeeAge;	
	}//end of getEmployee
	
	public void setEmployeeAge(int age) {		
		employeeAge = age;	
	}//end of setEmployeeAge
	
	public String getEmployeeState() {	
		return employeeState;	
	}//end of getEmployee
	
	public void setEmployeeState(String state) {		
		employeeState = state;	
	}//end of setEmployeeState
	
	public int getEmployeeZip() {	
		return employeeZip;	
	}//end of getEmployee
	
	public void setEmployeeZip(int zip) {		
		employeeZip = zip;	
	}//end of setEmployeeZip
	
	public int[] getAdvisors() {
      int[] retAdv = advisors;
		return retAdv;
	}//end of getAdvisors
	
	public void setAdvisors(int[] adv) {
		//if there are too many advisors
      advisors = new int[3];
		if(adv.length > 3) {
			System.out.println("Too many advisors.");
		}//end of if
		else {
			//set each index with an advisor
			for(int i=0; i < advisors.length; i++) {
				advisors[i] = adv[i];
			}//end of for
		}//end of else
	}//end of getAdvisors
 
	//toString() method 
	//for displaying contents of Employee instance
	//parameters: none
	//preconditions: none
	public String toString() {
		return "(Employee Name: "+employeeName+" Employee No: "+employeeNo+" Employee Age: "+employeeAge+" Employee State: "+employeeState+" Employee Zip: "+employeeZip+" Employee Advisors "+advisors+")";
	}
	
	//equals() method
	//returns true or false depending if two Employee instances are the same
	//parameters: object of type Employee
	//precondition: obj must not be null, and must be instanceof Employee
	public boolean equals(Object obj) {
		//overall test variable
		boolean test = false;
		//precondition
		if((obj != null) && (obj instanceof Employee)) {
			Employee W = (Employee) obj;
			//check
			if(employeeNo == W.employeeNo) test = true;
		}//end of if
		return test;					
		
	}//end of equals method
	
	//getAllAdvisors() method
	//gets all the distinct advisors of two employees
	//parameters: two employees, e1 and e2
	//preconditions: neither e1 nor e2 can be null
	public static int[] getAllAdvisors(Employee e1, Employee e2) {
		int[] compAdv = new int[6];
		if((e1 != null || e2 != null) && (e1 instanceof Employee && e2 instanceof Employee)) {
            int[] check = e1.advisors;
			for(int i=0; i < compAdv.length; i++) {
				compAdv[i] = check[i];
				//check for duplicates
				if(compAdv[i] == e2.advisors[i]) {
				}//end of if
				else {
					compAdv[i] = e2.advisors[i - compAdv.length];
				}//else
			}//end of for
		}//end of if
		return compAdv;
	}//end of getAllAdvisors() method
	
	//main() method
	//for testing
   
   //arrayprint method
   //allows to print the int arrays returned by getAdvisors() and getAllAdvisors()
   //parameters: 
   //precondition: none
   public static void printIntArr(int[] arrToPrint) {
      int[] printAdv = arrToPrint;
      for(int i=0; i < printAdv.length; i++) {
		   System.out.print(printAdv[i]);
      }//end of for
      System.out.println();
   }//end of printIntArr
	
	public static void main(String [] args) {
		
		//test for each method
		
		Employee edwin = new Employee();
		System.out.println("Employee Object Default Constructor: ");
		System.out.println(edwin.toString());
		
		Employee steve = new Employee();
		
		//setter and getter methods
		
		steve.setEmployeeName("Steve");
		steve.setEmployeeAge(23);
		steve.setEmployeeNo(1234);
		steve.setEmployeeState("CA");
		steve.setEmployeeZip(13579);
		int[] steveAdvisors = new int[] {1, 2, 3};
		steve.setAdvisors(steveAdvisors);

		
		System.out.println("Employee get method values: ");
		
		System.out.println(steve.getEmployeeName());
		System.out.println(steve.getEmployeeAge());
		System.out.println(steve.getEmployeeNo());
		System.out.println(steve.getEmployeeState());
		System.out.println(steve.getEmployeeZip());
        printIntArr(steve.getAdvisors());
		
		//copying method
		
		Employee alex = new Employee(steve);
				
		System.out.println("Successful copy of steve to alex: ");
		steve.toString();
		alex.toString();

		//equals method
		
		System.out.println("Is Employee edwin equal to Employee steve?");
		System.out.println(edwin.equals(steve));
		System.out.println("Is Employee steve equal to Employee alex?");
		System.out.println(steve.equals(alex));
		
		//getAllAdvisors
		
		System.out.println("Advisors for edwin and alex");
		
		printIntArr(Employee.getAllAdvisors(steve, alex));
		

	}//end of main method
	
}//end of Employee class