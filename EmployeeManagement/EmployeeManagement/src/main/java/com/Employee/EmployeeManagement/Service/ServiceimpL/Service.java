package com.Employee.EmployeeManagement.Service.ServiceimpL;

import com.Employee.EmployeeManagement.Entity.Employee;
import com.Employee.EmployeeManagement.Repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface Service {
    @Autowired
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee UpdateEmployee(Employee employee, int id);

    void DeleteEmployee(int id);
//    Employee UpdateEmployee(int id);
}
