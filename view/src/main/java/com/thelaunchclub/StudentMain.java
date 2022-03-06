package com.thelaunchclub;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.Scanner;

/**
 * Manages all data from the student and provides an access to add, search,
 * remove and update operations.
 * 
 * @author KowsalyaSP
 */
public class StudentMain {
	public static final Scanner SCANNER = new Scanner(System.in);
	/*public static final Scanner SCANNER = new Scanner(System.in);
	private static final Logger LOGGER = Logger.getLogger(StudentMain.class);
	private static final String LOG_FILE = "log4j.properties";
	private static final Properties PROPERTIES = new Properties();*/

	/**
	 * Method which makes use of all services such as adding, searching, removing,
	 * updating the student details.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	/*public static void main(String[] args) throws FileNotFoundException, IOException {
		BasicConfigurator.configure();
		PROPERTIES.load(new FileInputStream(LOG_FILE));
		PropertyConfigurator.configure(PROPERTIES);
		LOGGER.info("\n ---------------------------------------------------- \n     STUDENT MANAGEMENT SYSTEM     \n ----------------------------------------------------");
		StudentMain.studentMain();
	}*/

	public static void studentMain()  {
		int choice;


		do {
			System.out.println(" \n 1.Add Student \n 2.Search Student \n 3.Remove Student \n 4.Update student \n 5.ShowAll Students \n ");
			choice = StudentView.validateChoice();

			switch (choice) {
			case 1:
				StudentDetails.addStudent();
				break;
			case 2:
				StudentDetails.searchStudent();
				break;
			case 3:
				StudentDetails.removeStudent();
				break;
			case 4:
				StudentDetails.updateStudent();
				break;
			case 5:
				StudentDetails.showAllStudents();
				break;
				case 6:
				SCANNER.close();

				try {
					Activator.bundle.stop();
				} catch(BundleException e){
					System.out.println(e);
				  } catch(Exception e){
					System.out.println(e);
				    }
			}
		} while (choice <6);
	}
}
