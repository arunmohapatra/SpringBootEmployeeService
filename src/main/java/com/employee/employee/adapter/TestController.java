package com.employee.employee.adapter;

import com.employee.employee.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/source")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/test1")
    public String remote() {
        return "Hello World";
    }

    @GetMapping("/test")
    public String message() {
        return testService.callApiEndpoint();
    }
}




