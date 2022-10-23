package com.Employee.EmployeeManagement.Repository;

import com.Employee.EmployeeManagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer> {
    Optional<Employee> findAllById(int id);
}
