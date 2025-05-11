package com.employee.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EmployeePersistance {

    @Id
    String empId;

    String employee_first_name;

    String employee_middle_name;

    String employee_last_name;

    String employee_code;
}
