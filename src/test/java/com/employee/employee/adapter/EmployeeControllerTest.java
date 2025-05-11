package com.employee.employee.adapter;

import com.employee.employee.adapter.request.UpdateEmployeeRequest;
import com.employee.employee.adapter.response.DeleteEmployeeResponse;
import com.employee.employee.adapter.response.GetEmployeeResponse;
import com.employee.employee.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    EmployeeService employeeService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createEmployee() {
    }

    @Test
    void getEmployee() {
        Employee employee = new Employee();
        employee.setEmployee_id("001");
        employee.setEmployee_first_name("Arun");
        employee.setEmployee_middle_name("Kumar");
        employee.setEmployee_last_name("Mohapatra");
        employee.setEmployee_code("001");

        when(employeeService.getEmployee("001")).thenReturn(employee);
        ResponseEntity<GetEmployeeResponse> response =
                employeeController.getEmployee("001");

        assertEquals(HttpStatus.OK, response.getStatusCode());

        response = employeeController.getEmployee("003");
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void updateEmployee() {
        Employee employee = new Employee();
        when(employeeService.updateEmployee(any())).thenReturn(employee);
        UpdateEmployeeRequest updateEmployeeRequest = new UpdateEmployeeRequest();
        assertEquals(HttpStatus.OK, employeeController.updateEmployee(updateEmployeeRequest).getStatusCode());

        when(employeeService.updateEmployee(any())).thenReturn(null);
        assertEquals(HttpStatus.NOT_FOUND, employeeController.updateEmployee(updateEmployeeRequest).getStatusCode());
    }

    @Test
    void delete() {
        DeleteEmployeeResponse deleteEmployeeResponse = new DeleteEmployeeResponse();
        when(employeeService.deleteEmployee("001")).thenReturn(true);
        assertEquals(HttpStatus.OK, employeeController.delete("001").getStatusCode());

        when(employeeService.deleteEmployee("003")).thenReturn(false);
        assertEquals(HttpStatus.NOT_FOUND, employeeController.delete("003").getStatusCode());
    }
}