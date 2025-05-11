package com.employee.employee.adapter;

import com.employee.employee.adapter.request.CreateEmployeeRequest;
import com.employee.employee.adapter.request.UpdateEmployeeRequest;
import com.employee.employee.adapter.response.CreateEmployeeResponse;
import com.employee.employee.adapter.response.DeleteEmployeeResponse;
import com.employee.employee.adapter.response.GetEmployeeResponse;
import com.employee.employee.adapter.response.UpdateEmployeeResponse;
import com.employee.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @PostMapping
    @ResponseBody
    public ResponseEntity<CreateEmployeeResponse> createEmployee(
            @RequestBody CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = new Employee();
        employee.setEmployee_id(createEmployeeRequest.getEmpId());
        employee.setEmployee_first_name(createEmployeeRequest.getEmpFirstName());
        employee.setEmployee_middle_name(createEmployeeRequest.getEmpMiddleName());
        employee.setEmployee_last_name(createEmployeeRequest.getEmpLastName());
        employee.setEmployee_code(createEmployeeRequest.getEmpCode());
        employeeService.addEmployee(employee);

        CreateEmployeeResponse createEmployeeResponse = new CreateEmployeeResponse("Employee Created Successfully");
        return ResponseEntity.ok().body(createEmployeeResponse);
    }


    //Using GET using @PathVariable
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<GetEmployeeResponse> getEmployee(@PathVariable("id") String id) {
        Employee employee = employeeService.getEmployee(id);
        if(employee != null) {
            GetEmployeeResponse getEmployeeResponse = new GetEmployeeResponse();
            getEmployeeResponse.setEmpId(employee.getEmployee_id());
            getEmployeeResponse.setEmpFirstName(employee.getEmployee_first_name());
            getEmployeeResponse.setEmpMiddleName(employee.getEmployee_middle_name());
            getEmployeeResponse.setEmpLastName(employee.getEmployee_last_name());
            getEmployeeResponse.setEmpCode(employee.getEmployee_code());
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(getEmployeeResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //GET using @PathParam
    // GET /employee?id={id}

    @GetMapping()
    @ResponseBody
    public ResponseEntity<GetEmployeeResponse> getEmployee1(@RequestParam("id") String id) {
        Employee employee = employeeService.getEmployee(id);
        if(employee != null) {
            GetEmployeeResponse getEmployeeResponse = new GetEmployeeResponse();
            getEmployeeResponse.setEmpId(employee.getEmployee_id());
            getEmployeeResponse.setEmpFirstName(employee.getEmployee_first_name());
            getEmployeeResponse.setEmpMiddleName(employee.getEmployee_middle_name());
            getEmployeeResponse.setEmpLastName(employee.getEmployee_last_name());
            getEmployeeResponse.setEmpCode(employee.getEmployee_code());
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(getEmployeeResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<UpdateEmployeeResponse> updateEmployee(
            @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = employeeService.updateEmployee(updateEmployeeRequest);
        if(employee != null) {
            UpdateEmployeeResponse updateEmployeeResponse = new UpdateEmployeeResponse();
            updateEmployeeResponse.setStatus("Successfully updated empolyee : " + employee.getEmployee_id());
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(updateEmployeeResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteEmployeeResponse> delete(@PathVariable("id") String employeeId) {
        DeleteEmployeeResponse deleteEmployeeResponse = new DeleteEmployeeResponse();
        if(employeeService.deleteEmployee(employeeId)) {
            deleteEmployeeResponse.setStatus("Delete Employee :"+Integer.parseInt(employeeId));
            return ResponseEntity.ok().body(deleteEmployeeResponse);
        } else {
            deleteEmployeeResponse.setStatus("Unable to find employee having id :"
                    +Integer.parseInt(employeeId));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(deleteEmployeeResponse);
        }
    }
}
