package com.employee.employee.adapter.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEmployeeRequest {

    String empId;

    String empFirstName;

    String empMiddleName;

    String empLastName;

    String empCode;
}
