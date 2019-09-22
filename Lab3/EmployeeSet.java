//CS272 - Lab3
//EmployeeSet.java
//program purpose: Create a data structure with functionality of a collection/bag
//written by Edwin Torres
//date written: September 9, 2019

public class EmployeeSet {

	//instance variables
	private int collectSize;
	private int collectCapacity;
	private Employee[] employeeArray;
	
	//Default constructor
	public EmployeeSet() {
		
		//initialize instance variables
		collectSize = 0;
		collectCapacity = 2;
		employeeArray = new Employee[collectCapacity];
		
	}//end of EmployeeSet() default constructor
	
	/*
	 * Copy Constructor
	 * function: Copy the contents of one EmployeeSet object to another
	 * @parameters: Object of type EmployeeSet
	 * @precondition: obj should not be null and should be an instance of EmployeeSet
	 */
	public EmployeeSet(Object obj) {
		
		if((obj != null) && (obj instanceof EmployeeSet)) {
			EmployeeSet copy = (EmployeeSet) obj;
			this.collectCapacity = copy.collectCapacity;
			this.collectSize = copy.collectSize;
			this.employeeArray = new Employee[this.collectCapacity];
			for(int i=0; i < this.collectCapacity; i++) {
				this.employeeArray[i] = copy.employeeArray[i];
			}//end of for
		}//end of if
		
	}//end of EmployeeSet() copy constructor
	
	/*
	 * size() method
	 * function: returns the actual amount of the collection instance
	 * @parameters: none
	 * @preconditions: none
	 */
	public int size() {
		return collectSize;
	}//end of size() method
	
	/* 
	 * capacity() method
	 * function: returns the capacity of the collection instance
	 * @parameters: none
	 * @preconditions: none
	 */
	public int capacity() {
		return collectCapacity;
	}//end of capacity() method
	
	/*
	 * add() method
	 * function: if there is space, adds the Employee object, if not double the space then add the object
	 * @parameters: Employee object
	 * @preconditions: none, conditions are evaluated in method
	 */
	public void add(Employee a) throws Exception {
		if((a != null) && (this.contains(a) != true)) {
			if(collectSize == collectCapacity) {
				ensureCapacity((collectSize + 1) * 2);
			}//end of if
			employeeArray[collectSize] = a;
			collectSize++;
		}//end of if
	}//end of add() method
	
	/*
	 * contains() method
	 * function: checks whether the EmployeeSet collection has a certain Employee object
	 * @parameters: Employee object to check
	 * @preconditions: Employee object must not be null, and object must be of type Employee
	 */
	public boolean contains(Employee a) {
		int number = a.getEmployeeNo();
		if(a != null) {
			for(int i=0; i < this.collectSize; i++) {
				if(number == this.employeeArray[i].getEmployeeNo()) {
					return true;
				}//end of if
			}//end of for
		}//end of if
		return false;
	}//end of contains() method
	
	/*
	 * remove() method
	 * function: remove Employee object from set, given an employee number
	 * @parameters: int which is an Employee number
	 * @preconditions: Employee object must not be null, and object must be of type Employee
	 */
	public boolean remove(int eno) {
		//check through array
		for(int i=0; i < this.collectSize; i++) {
			if(this.employeeArray[i].getEmployeeNo() == eno) {
				collectSize--;
				employeeArray[i] = employeeArray[collectSize];
				return true;
			}//end of if
		}//end of for
		return false;
	}//end of remove() method
	
	/*
	 * ensureCapacity() method
	 * function: guarantees the capacity of the collection, by setting the capcity to a minimum value
	 * @parameters: int which is the minimum to capacity to set
	 * @preconditions: parameter value must me positive
	 */
	private void ensureCapacity(int minimumCapacity) throws Exception {
		//array for copying
		Employee[] newArray;
		if(minimumCapacity < 0)
			throw new Exception("minimumCapacity must be positive!");
		if(collectCapacity < minimumCapacity) {
			collectCapacity = minimumCapacity;
			newArray = new Employee[collectCapacity];
			for(int i=0; i < this.collectSize; i++) {
				newArray[i] = this.employeeArray[i];
			}//end of for
			this.employeeArray = newArray;
		}//end of if
	}//end of ensureCapacity() method
	
	/*	
	 * addOrdered() method
	 * function: similar to add, this makes all collection objects be in ascending order based on employee number
	 * @parameters: Employee object to be added	
	 * @preconditions: Employee object must not be null, object must be of type Employee, and array must already be in ascending order
	*/
	public void addOrdered(Employee a) throws Exception {
		if((a != null) && (ascendCheck() != false) && (this.contains(a) != true)) {
			if(collectSize == collectCapacity) {
				ensureCapacity((collectSize + 1) * 2);
			}//end of if
			//set in ascending order
			Employee[] shiftEmp = new Employee[collectCapacity];
			int index = 0;
			//now that we have where to insert, we shift and insert the values
			for(int i = 0; i < collectSize; i++) {
				if(this.employeeArray[i].getEmployeeNo() <= a.getEmployeeNo()) {
					index++;
				}
				if(this.employeeArray[i].getEmployeeNo() > a.getEmployeeNo()) {
					shiftEmp[i + 1] = this.employeeArray[i];
				}//end of if
			}//end of for
			employeeArray[index] = a;
			for(int i = index + 1; i < collectSize; i++) {
				this.employeeArray[i] = shiftEmp[i];
			}//end of for
			collectSize++;
		}//end of if
	}//end of addOrdered() method

	/*	
	 * ascendCheck method
	 * function: facilitating method for determining if a elementArray is in ascending order
	 * @parameters: none
	 * @preconditions: none
	*/
	public boolean ascendCheck() {
		boolean answer = true;
		for(int i = 0; i < this.collectSize && ((i + 1) != collectSize); i++) {
			if(this.employeeArray[i].getEmployeeNo() > this.employeeArray[i+1].getEmployeeNo()) {
				answer = false;
			}//end of if
		}//end of for
		return answer;
	}//end of ascendCheck() method
	
	
	public static void main(String [] args) throws Exception {
		//EmployeeSet object and Employee objects for testing
		Employee edwin = new Employee();
		edwin.setEmployeeNo(123);
		Employee torres = new Employee();
		torres.setEmployeeNo(368);
		Employee john = new Employee();
		john.setEmployeeNo(456);
		Employee hector = new Employee();
		hector.setEmployeeNo(987);
		EmployeeSet mySet = new EmployeeSet();
		
		//add Employee objects to array
		System.out.print("size() method: ");
		System.out.println("size: " + mySet.size());
		System.out.print("capacity() method: ");
		System.out.println("capacity: " + mySet.capacity());
		
		//add methods
		mySet.add(edwin);
		mySet.add(torres);
		
		System.out.println("print the array: ");
		for(int i=0; i < mySet.collectSize; i++) {
			System.out.println(mySet.employeeArray[i]);
		}//end of for
		
		mySet.add(john);
		System.out.println("print the array: ");
		for(int i=0; i < mySet.collectSize; i++) {
			System.out.println(mySet.employeeArray[i]);
		}//end of for
		
		//check if an Employee object is in array
		System.out.println("is edwin in the set? " + mySet.contains(edwin));
		System.out.println("is john in the set? " + mySet.contains(john));
		System.out.println("is hector in the set? " + mySet.contains(hector));

		//test copy constructor
		EmployeeSet otherSet = new EmployeeSet(mySet);
		
		System.out.println("otherSet from copy constructor: ");
		
		for(int i=0; i < otherSet.collectSize; i++) {
			System.out.println(otherSet.employeeArray[i]);
		}//end of for
		
		//test for remove method
		mySet.remove(edwin.getEmployeeNo());
		mySet.remove(hector.getEmployeeNo());
		
		System.out.println("mySet with removed value");
		
		for(int i=0; i < mySet.collectSize; i++) {
			System.out.println(mySet.employeeArray[i]);
		}//end of for
		
		//addOrdered method
		mySet.addOrdered(edwin);
		
		System.out.println("mySet (not in ascending order) with addOrdered value");
		
		for(int i=0; i < mySet.collectSize; i++) {
			System.out.println(mySet.employeeArray[i]);
		}//end of for
		
		//above should not have worked because it was not in ascending order
		
		otherSet.addOrdered(hector);
		
		System.out.println("otherSet (ordered) with addOrdered value");
		
		for(int i=0; i < otherSet.collectSize; i++) {
			System.out.println(otherSet.employeeArray[i]);
		}//end of for
		
	}//end of main() method
	
}//end of Employee Set class
