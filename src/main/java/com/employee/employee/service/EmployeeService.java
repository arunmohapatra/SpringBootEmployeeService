package com.employee.employee.service;

import com.employee.employee.adapter.Employee;
import com.employee.employee.adapter.request.UpdateEmployeeRequest;
import com.employee.employee.model.EmployeePersistance;
import com.employee.employee.persistance.EmployeeRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Setter
@Getter
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee) {
        EmployeePersistance employeePersistance = new EmployeePersistance();
        employeePersistance.setEmpId(employee.getEmployee_id());
        employeePersistance.setEmployee_first_name(employee.getEmployee_first_name());
        employeePersistance.setEmployee_middle_name(employee.getEmployee_middle_name());
        employeePersistance.setEmployee_last_name(employee.getEmployee_last_name());
        employeePersistance.setEmployee_code(employee.getEmployee_code());
        employeeRepository.save(employeePersistance);
     }

    public Employee getEmployee(String employeeId) {
        Optional<EmployeePersistance> result = employeeRepository.findById(employeeId);
        if(!result.isEmpty()) {
            EmployeePersistance employeePersistance = result.get();
            Employee employee = new Employee();
            employee.setEmployee_id(employeePersistance.getEmpId());
            employee.setEmployee_first_name(employeePersistance.getEmployee_first_name());
            employee.setEmployee_middle_name(employeePersistance.getEmployee_middle_name());
            employee.setEmployee_last_name(employeePersistance.getEmployee_last_name());
            employee.setEmployee_code(employeePersistance.getEmployee_code());
            return employee;
        } else {
            return null;
        }
    }

    public Employee updateEmployee(UpdateEmployeeRequest updateEmployeeRequest) {
        Optional<EmployeePersistance> result = employeeRepository.findById(updateEmployeeRequest.getEmpId());
        if(!result.isEmpty()){
            EmployeePersistance employeePersistance = result.get();
            Employee employee = new Employee();
            employee.setEmployee_id(updateEmployeeRequest.getEmpId());
            employee.setEmployee_first_name(updateEmployeeRequest.getEmpFirstName());
            employee.setEmployee_middle_name(updateEmployeeRequest.getEmpMiddleName());
            employee.setEmployee_last_name(updateEmployeeRequest.getEmpLastName());
            employee.setEmployee_code(updateEmployeeRequest.getEmpCode());
            return employee;
        } else {
            return null;
        }
    }
    public boolean deleteEmployee(String employeeId) {
        Optional<EmployeePersistance> result = employeeRepository.findById(employeeId);
        if(!result.isEmpty()) {
            employeeRepository.delete(result.get());
            return true;
        } else {
            return false;
        }
    }
}
