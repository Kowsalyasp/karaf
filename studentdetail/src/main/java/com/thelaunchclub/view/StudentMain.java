package com.thelaunchclub.view;

import com.thelaunchclub.Activator;
import org.osgi.framework.BundleException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Manages all data from the student and provides an access to add, search,
 * remove and update operations.
 * 
 * @author KowsalyaSP
 */
public class StudentMain {
	public static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * Method which makes use of all services such as adding, searching, removing,
	 * updating the student details.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
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
