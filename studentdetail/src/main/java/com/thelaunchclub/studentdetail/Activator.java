package com.thelaunchclub.studentdetail;

import com.thelaunchclub.studentdetail.view.StudentDetails;
import com.thelaunchclub.studentdetail.view.StudentView;
import com.thelaunchclub.userinput.CommonInput;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

import java.util.Scanner;

public class Activator implements BundleActivator {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static Bundle bundle;

    public void start(BundleContext context) {
        System.out.println("Starting the bundle view");
        bundle = context.getBundle();
        //Activator.studentMain();
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }

    public static void studentMain() {
        int choice;

        do {
            System.out.println(" \n 1.Add Student \n 2.Search Student \n 3.Remove Student \n 4.Update student \n 5.ShowAll Students \n 6. Exit");
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
                    CommonInput.SCANNER.close();

                    try {
                        Activator.bundle.stop();
                    } catch (BundleException e) {
                        System.out.println(e);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
            }
        } while (choice < 6);
    }
}