package com.Employee.EmployeeManagement.Service;

import com.Employee.EmployeeManagement.Entity.Employee;
import com.Employee.EmployeeManagement.Repository.EmpRepo;
import com.Employee.EmployeeManagement.Service.ServiceimpL.Service;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class EmpServiceImpl implements Service {
    private EmpRepo repo;

    public EmpServiceImpl(EmpRepo repo) {
        this.repo = repo;
    }

    //save employee(create)
    @Override
    public Employee saveEmployee(Employee employee) {
        return repo.save(employee);
    }

    //getall employees
    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee=repo.findById(id);
        return employee.get();
    }

    @Override
    public Employee UpdateEmployee(Employee employee, int id) {
        Employee exempoloyee =repo.findById(id).get();
        exempoloyee.setFirstname(employee.getFirstname());
        exempoloyee.setLastname(employee.getLastname());
        exempoloyee.setEmail(employee.getEmail());
        exempoloyee.setPhone_no(employee.getPhone_no());
        repo.save(exempoloyee);
        return exempoloyee;
    }

    @Override
    public void DeleteEmployee(int id) {

//        if (!repo.existsById(id)) {
//            System.out.println("employee not found");
//        } else {
            repo.deleteById(id);

    }



    /*
//    @Override
//    public Employee UpdateEmployee(int id) {
//        Employee exempoloyee =repo.findById(id).get();
//        exempoloyee.setFirstname(exempoloyee.getFirstname());
//        exempoloyee.setLastname(exempoloyee.getLastname());
//        exempoloyee.setEmail(exempoloyee.getEmail());
//        exempoloyee.setPhone_no(exempoloyee.getPhone_no());
//        repo.save(exempoloyee);
//        return exempoloyee;
//    }

    The above commented code will be like get and setting the same element there itself
*/

}
