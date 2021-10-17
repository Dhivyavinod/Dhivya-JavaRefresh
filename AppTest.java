package com.Java.TextFileSort;

import static org.junit.Assert.assertEquals;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.Test;

/**
 * Unit test for simple App.Java
 */
public class AppTest     
{
        
	@Test
	public void processingTextFile() throws IOException {
			
		//String filename="D:\\namesFL.txt";
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));		
		String filename=reader.readLine();
    	String result=App.processingTextFile(filename); 
    	System.out.println(System.out);
    	String expected = "Copied Successfuly to output.txt";
    	assertEquals(result,expected);
		
	}
	
		
}
