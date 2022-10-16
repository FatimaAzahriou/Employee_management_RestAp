package com.example.project_1.repository;

import com.example.project_1.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//we do not need to add @reposiory because is added automatically
public interface EmployeeRepository extends JpaRepository<Employee,Long> {







}
