package com.employee.employee.service;

import com.employee.employee.adapter.Employee;
import com.employee.employee.adapter.request.UpdateEmployeeRequest;
import com.employee.employee.model.EmployeePersistance;
import com.employee.employee.persistance.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.Optional;

class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;
    @Mock
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void addEmployee() {

        Employee employee = new Employee();
        employee.setEmployee_id("1");
        employee.setEmployee_first_name("John");
        employee.setEmployee_middle_name("M");
        employee.setEmployee_last_name("Doe");
        employee.setEmployee_code("E123");

        employeeService.addEmployee(employee);

        EmployeePersistance employeePersistance = new EmployeePersistance();
        when(employeeRepository.save(employeePersistance)).thenReturn(null);
    }

    @Test
    void getEmployee() {

        EmployeePersistance employeePersistance = new EmployeePersistance();
        employeePersistance.setEmpId("001");
        Optional<EmployeePersistance> employeePersistance1 = Optional.ofNullable(employeePersistance);
        when(employeeRepository.findById("001")).thenReturn(employeePersistance1);

        Employee employee = employeeService.getEmployee("001");
        assertEquals("001", employee.getEmployee_id());

        employee = employeeService.getEmployee("002");
        assertEquals(null, employee);
    }

    @Test
    void updateEmployee() {

        EmployeePersistance employeePersistance = new EmployeePersistance();
        employeePersistance.setEmpId("001");
        Optional<EmployeePersistance> employeePersistance1 = Optional.ofNullable(employeePersistance);
        when(employeeRepository.findById("001")).thenReturn(employeePersistance1);

        UpdateEmployeeRequest updateEmployeeRequest = new UpdateEmployeeRequest();
        updateEmployeeRequest.setEmpId("001");
        updateEmployeeRequest.setEmpFirstName("Arun");
        Employee employee = employeeService.updateEmployee(updateEmployeeRequest);
        assertEquals("Arun", employee.getEmployee_first_name());

        updateEmployeeRequest = new UpdateEmployeeRequest();
        updateEmployeeRequest.setEmpId("002");
        updateEmployeeRequest.setEmpFirstName("Arun");
        employee = employeeService.updateEmployee(updateEmployeeRequest);
        assertEquals(null, employee);

    }

    @Test
    void deleteEmployee() {
        EmployeePersistance employeePersistance = new EmployeePersistance();
        employeePersistance.setEmpId("001");
        Optional<EmployeePersistance> employeePersistance1 = Optional.of(employeePersistance);
        //
        when(employeeRepository.findById("001")).thenReturn(employeePersistance1);

        boolean ret = employeeService.deleteEmployee("001");
        assertTrue(ret);

        ret = employeeService.deleteEmployee("002");
        assertTrue(!ret);
    }
}