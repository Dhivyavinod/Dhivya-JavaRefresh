package com.refresh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortFirstLastName {

	public static void main(String[] args) throws Exception {
		
		File inputfile =new File("C:\\Users\\Dhivya Vinod\\GitHubRepository\\Dhivya-JavaRefresh\\InputOutputFiles\\namesFL.txt");
		File outputfile =new File("C:\\Users\\Dhivya Vinod\\GitHubRepository\\Dhivya-JavaRefresh\\InputOutputFiles\\namesFLSorted.txt");
		
		BufferedReader reader=new BufferedReader(new FileReader(inputfile));
		BufferedWriter writer=new BufferedWriter(new FileWriter(outputfile));
		
		String fullName;
		String firstName;
		String lastName;
		
		ArrayList<Person> nameList=new ArrayList<Person>();		
		
		//reading the names from test file 
		while((fullName=reader.readLine())!=null) {
			//names=names.toLowerCase();
			String[] values=fullName.split(",");
			lastName=(String) values[0];
			firstName=(String) values[1];
			Person p =new Person();
			p.setLname(lastName);
			p.setfName(firstName);
			nameList.add(p);
		}
		reader.close();
		
		//sorting the names
		Collections.sort(nameList,new Comparator<Person>() {
			public int compare(Person s1, Person s2) {
	                return s1.getLname().compareToIgnoreCase(s2.getLname());
	        
		}
		});	
		
		
		//copying the name to output text file
		
		for(Person str:nameList) {
			writer.write(str.getLname()+","+str.getfName() + System.lineSeparator());
			System.out.println("Copying....");
		}
		writer.close();
		
		System.out.println("Copied Successfuly to namesSorted.txt");
	}

}
