package com.thelaunchclub.studentdetail.controller;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

@Component(immediate = true)
public class RestService {
    private Server server;

    /**
     * Activates the server and creates the connection.
     */
    @Activate
    public void activate() {

        try {
            JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();
            bean.setAddress("/studentfile");
            bean.setBus(BusFactory.getDefaultBus());
            bean.setProvider(new JacksonJsonProvider());
            bean.setServiceBean(new ApiServiceImpl());
            server = bean.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Deactivate the server and it destroys the connection.
     * @throws Exception
     */
    @Deactivate
    public void deactivate() throws Exception {
        if (server != null) {
            server.destroy();
            System.out.println("fail");
        }
    }
}

