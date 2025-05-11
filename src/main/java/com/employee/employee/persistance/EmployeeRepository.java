package com.employee.employee.persistance;


import com.employee.employee.model.EmployeePersistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeePersistance, String> {
}
