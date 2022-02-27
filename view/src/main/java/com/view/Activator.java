/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.view;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Activator implements BundleActivator {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger LOGGER = Logger.getLogger(StudentMain.class);
    private static final String LOG_FILE = "log4j.properties";
    private static final Properties PROPERTIES = new Properties();

    public void start(BundleContext context) {
        System.out.println("Starting the bundle");
        BasicConfigurator.configure();
        try {
            PROPERTIES.load(new FileInputStream(LOG_FILE));
            PropertyConfigurator.configure(PROPERTIES);
        } catch(Exception e) {
            LOGGER.info(e);
        }
        LOGGER.info("\n ---------------------------------------------------- \n     STUDENT MANAGEMENT SYSTEM     \n ----------------------------------------------------");
        StudentMain.studentMain();
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }

}