package com.employee.employee.service;

import com.employee.employee.config.ConfigureObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;

@Service
public class TestService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ConfigureObj configureObj;

    public String callApiEndpoint() {
        System.out.println("Remote api call..");
        try {
            return restTemplate.getForObject(new URI(configureObj.getUrl()), String.class);
        } catch (Exception exception){
            exception.printStackTrace();
            return "";
        }
    }

}
