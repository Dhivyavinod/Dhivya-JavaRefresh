package com.java.textFileSort;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;

/**
 * Unit test for simple App.Java which read input text file,process 
 * and generate output text file
 */
public class AppTest     
{
        
	@Test
	public void processingTextFile() throws IOException {
			
		String filename="D:\\namesFL.txt";
    	String result=App.processingTextFile(filename); 
    	System.out.println(System.out);
    	String expected = "Copied Successfuly to Filename :created names-sorted.txt";
    	assertEquals(result,expected);
		
	}
	
		
}
