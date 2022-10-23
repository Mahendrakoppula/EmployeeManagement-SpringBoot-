package com.Employee.EmployeeManagement.Controller;

import com.Employee.EmployeeManagement.Entity.Employee;
import com.Employee.EmployeeManagement.Service.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/employees")
public class EmployeeController {
    public EmployeeController(EmpServiceImpl empService) {
        this.empService = empService;
    }

    @Autowired
    private EmpServiceImpl empService;

    //CREATE EMPLOYEE
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(empService.saveEmployee(employee), HttpStatus.CREATED);
    }
    //GET ALL EMPLOYEES
    @GetMapping
    public List<Employee> getAllEmployees(){
        return empService.getAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
        return new ResponseEntity<Employee>(empService.getEmployeeById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id,@RequestBody Employee employee){
        return new ResponseEntity<Employee>(empService.UpdateEmployee(employee,id),HttpStatus.OK);
    }
    @DeleteMapping({"id"})
    public String DeleteEmployee(@PathVariable("id")int id){
        empService.DeleteEmployee(id);
        return "employee deleted Successfully";
    }
/*
//    @PutMapping("{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id,@RequestBody Employee employee){
//        return new ResponseEntity<Employee>(empService.UpdateEmployee(id),HttpStatus.OK);
//
    }

    The above commented code is because service method is commented
 */
}
