package com.example.spring_rest_api.services;

import com.example.spring_rest_api.exception.DoNotUseException;
import com.example.spring_rest_api.exception.EmptyInputException;
import com.example.spring_rest_api.models.Employee;
import com.example.spring_rest_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceimpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        if(employee.getName().isEmpty() || employee.getName().length() == 0)
        {
            throw new EmptyInputException(); //custom exception handling
        }
        else
        {
            if(employee.getName().equals("Nifrad")) {
                throw new DoNotUseException(); //custom exception handling
            }
            else {
                return employeeRepository.save(employee);
            }
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmpById(Long empidL) {
        return employeeRepository.findById(empidL).get();
    }

    @Override
    public void deleteEmpById(Long empidL) {
        employeeRepository.deleteById(empidL);
    }
}
