package com.java.textFileSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App {
	public static void main(String[] args) throws Exception {
		String msg = null;
		String inputfile = null;
		BufferedReader readerInputfile = null;
		try {
			System.out.println("please enter the Inputfile name :");
			readerInputfile = new BufferedReader(new InputStreamReader(System.in));
			inputfile = readerInputfile.readLine();

			// Processing File
			msg = processingTextFile(inputfile);
			System.out.println(msg);

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			readerInputfile.close();
		}

	}

	public static String processingTextFile(String fileName) throws IOException {

		BufferedReader reader = null;
		BufferedWriter writer = null;
		String fullName;
		String firstName;
		String lastName;
		String fileProcResult = null;

		try {

			reader = new BufferedReader(new FileReader(fileName));
			writer = new BufferedWriter(new FileWriter("created names-sorted.txt"));
			ArrayList<Person> nameList = new ArrayList<Person>();

			// reading the names from test file
			while ((fullName = reader.readLine()) != null) {
				String[] values = fullName.split(",");
				lastName = (String) values[0];
				firstName = (String) values[1];
				Person p = new Person();
				p.setLname(lastName);
				p.setfName(firstName);
				nameList.add(p);

			}

			// sorting the names
			Collections.sort(nameList, new Comparator<Person>() {
				public int compare(Person s1, Person s2) {
					int compareValue = s1.getfName().compareTo(s2.getfName());
					if (compareValue == 0) {
						return compareValue;
					}

					return s1.getLname().compareToIgnoreCase(s2.getLname());
				}
			});

			// copying the name to output text file

			for (Person str : nameList) {
				writer.write(str.getLname() + "," + str.getfName() + System.lineSeparator());
				System.out.println("Copying....");
				fileProcResult = "Copied Successfuly to Filename :created names-sorted.txt";
			}
		} catch (Exception exe) {
			exe.printStackTrace();
			fileProcResult = "Exception during processing output.txt";
		} finally {
			reader.close();
			writer.close();
		}
		return fileProcResult;

	}

}
