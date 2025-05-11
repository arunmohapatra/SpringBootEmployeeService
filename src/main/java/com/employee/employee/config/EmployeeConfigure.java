package com.employee.employee.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Setter
@Getter
public class EmployeeConfigure {

    @Value("${employee.host}")
    String host;

    @Value("${employee.port}")
    String port;

    @Value("${employee.url}")
    String url;

    @Bean
    public ConfigureObj configureObj() {
        return new ConfigureObj(host,port,url);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
