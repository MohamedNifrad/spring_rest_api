package com.example.spring_rest_api.services;

import com.example.spring_rest_api.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public Employee getEmpById(Long empidL);

    public void deleteEmpById(Long empidL);
}
