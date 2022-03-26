package com.thelaunchclub.studentdetail;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.thelaunchclub.studentdetail.controller.ApiServiceImpl;
import com.thelaunchclub.studentdetail.view.StudentDetails;
import com.thelaunchclub.studentdetail.view.StudentView;
import com.thelaunchclub.userinput.CommonInput;
import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * Starts with the Activator class to run whole program.
 */
@Component(immediate = true)
public class Activator {

    private Server server;

    /**
     * Activates the server and also activate the connection.
     */
    @Activate
    public void activate() {

        try {
            final JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();
            bean.setAddress("/studentfile");
            bean.setBus(BusFactory.getDefaultBus());
            bean.setProvider(new JacksonJsonProvider());
            bean.setServiceBean(new ApiServiceImpl());
            server = bean.create();
           // Activator.studentMain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Deactivate the server and it destroys the connection.
     *
     * @throws Exception
     */
    @Deactivate
    public void deactivate() throws Exception {

        if (server != null) {
            server.destroy();
        }
    }

    /**
     * To activate the Code.
     */
    public static void studentMain(){
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
            }
        } while (choice < 6);
    }
}