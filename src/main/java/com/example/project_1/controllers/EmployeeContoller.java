package com.example.project_1.controllers;


import com.example.project_1.models.Employee;
import com.example.project_1.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeContoller {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeContoller(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

//    because it will return status headers ,.....
//    create a  REST api to insert an employee in the db
   @PostMapping("save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
           return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
//    build getAll emplyees Rest API
    @GetMapping
    public List<Employee> getAllEmployees(){
       return employeeService.getAllEmployees();
    }
    @GetMapping("EmpById")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.FOUND);
    }
    // build update employee REST API
    // http://localhost:8080/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id
            ,@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){

        // delete employee from DB
        employeeService.deleteEmployee(id);

        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }

}
