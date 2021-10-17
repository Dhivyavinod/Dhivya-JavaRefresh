package com.Java.TextFileSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	String filename=readFilePath();
    	String msg=processingTextFile(filename);   
    	System.out.println("filename" +msg);
    	
    }
    
    public static String readFilePath() {
    	String inputfile =null;
    	try {
    	BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    	inputfile=reader.readLine();
    	
    	    	
    	}catch(IOException ioe) {
    		ioe.printStackTrace();
    	}
    	return inputfile;
    }
    
    public static String processingTextFile(String fileName) {
    	
    	String msg=null;
    	try {
    		System.out.println("inputfile:"+fileName);
    		
    	BufferedReader reader=new BufferedReader(new FileReader(fileName));
    	BufferedWriter writer=new BufferedWriter(new FileWriter("output.txt"));
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
				
				//System.out.println("Copied Successfuly to namesSorted.txt");
				
    	}catch(IOException io) {
    		io.printStackTrace();
    		msg ="Exception during processing output.txt";
    	}
    	msg ="Copied Successfuly to output.txt";
		return msg;
    }
    
   
}
