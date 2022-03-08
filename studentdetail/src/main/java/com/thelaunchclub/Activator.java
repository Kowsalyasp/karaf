package com.thelaunchclub;

import com.thelaunchclub.view.StudentMain;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.util.Scanner;

public class Activator implements BundleActivator {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static Bundle bundle;

    public void start(BundleContext context) {
        System.out.println("Starting the bundle view");
        bundle = context.getBundle();

        StudentMain.studentMain();
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }
}