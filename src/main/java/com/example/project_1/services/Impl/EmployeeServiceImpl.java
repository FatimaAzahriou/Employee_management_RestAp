package com.example.project_1.services.Impl;

import com.example.project_1.Exceptions.RessourceNotFoundException;
import com.example.project_1.models.Employee;
import com.example.project_1.repository.EmployeeRepository;
import com.example.project_1.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//    inject the employee repository interface , we will use constructor-based injection
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
//        Optional<Employee> employee = Optional.of(employeeRepository.getReferenceById(id));
//        if(employee.isPresent()){
//            return employee.get();
//        }else{
//            throw new RessourceNotFoundException("Employee","Id",id);
//        }
        return employeeRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("Employee","Id",id));

    }
    @Override
    public Employee updateEmployee(Employee employee, long id) {

        // we need to check whether employee with given id is exist in DB or not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new RessourceNotFoundException("Employee", "Id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        // save existing employee to DB
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
        public void deleteEmployee(long id) {

            // check whether a employee exist in a DB or not
            employeeRepository.findById(id).orElseThrow(() ->
                    new RessourceNotFoundException("Employee", "Id", id));
            employeeRepository.deleteById(id);
    }
}
