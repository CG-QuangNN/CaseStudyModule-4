package com.example.furama.repository;

import com.example.furama.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select employeeId from Employee")
    List<Integer> findAllEmployeeId();
}
