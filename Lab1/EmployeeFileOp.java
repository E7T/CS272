//CS 272 - Lab 1
//Program purpose: This is a simply read and write program
//Edwin Torres
//8/29/2019


package myprograms;

import java.io.*;

class employee{
	
	String name;
	String number;
	String state;
	String zip;
	int age;
	String sex;
}

public class EmployeeFileOp{
	
	//array of type employee
	private static employee[] info = null;
	
	public static void read(String fname) {
		//determining the line
		int no = 0;
		String line = "";
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fname);
			
			//wrap FileReader in BufferedReader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			//read till end of file
			while((line = bufferedReader.readLine()) != null) {	
				
				if (no == 0) {
					//at the very first line, make our info array have 302 values
					info = new employee[302];
				}//of if
				else {	
					//array of the values in line
					String[] lineStr = line.split(",");
					if (no > info.length) {
						System.out.println("There are too many employees in the file. ");
						break;
					}					
					//set the employee values for each in the array
					info[no-1] = new employee();
					info[no-1].name = (lineStr[0] + lineStr[1]);
					//System.out.println(lineStr[0] + lineStr[1]);
					info[no-1].number = (lineStr[2]);
					//System.out.println(lineStr[2]);
					info[no-1].state = (lineStr[3]);
					//System.out.println(lineStr[3]);
					info[no-1].zip = (lineStr[4]);
					//System.out.println(lineStr[4]);
					info[no-1].age = Integer.parseInt(lineStr[6]);
					//System.out.println(lineStr[5]);
					info[no-1].sex = (lineStr[7]);
					//System.out.println(no);
				}//of else
				no++;
			}//of while
			bufferedReader.close();
		}catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +  fname + "'");                
        }catch(IOException ex) {
            System.out.println("Error reading file '" + fname + "'");                  
        }
		System.out.println("Finished reading from file "+ fname);
		
	}//of read
	
	public static void write(String fname) {
		try {
			File file = new File(fname);
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			//bw.write(info.length+"\n");
			//System.out.println(info.length);
			for (int i=0; i<info.length-1;i++) {
				if (info[i].age<=30) {
					bw.write(info[i].name+",");
					bw.write(info[i].number+",");
					bw.write(info[i].state+",");
					bw.write(info[i].zip+",");
					bw.write(info[i].age+",");
					bw.write(info[i].sex+"\n");			
				}//of if	
			}//of for
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finish writing pairs to file "+ fname);
	}

	public static void main(String[] args) {
		
		//clears info
		info = null;
		//read from file "core_dataset.csv"
		read("core_dataset.csv");
		//write to file "young_employee.csv"
		write("young_employee.csv");

	}

}
