package com.example.spring_rest_api.controllers;

import com.example.spring_rest_api.models.Employee;
import com.example.spring_rest_api.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        Employee employeeSaved = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employeeSaved, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEmployees(){
        List<Employee> listOfAllEmps = employeeService.getAllEmployees();
        return new ResponseEntity<>(listOfAllEmps, HttpStatus.OK);
    }

    @GetMapping("/emp/{empid}")
    public ResponseEntity<?> getEmpById(@PathVariable("empid") Long empidL){

        Employee empRetrieved = employeeService.getEmpById(empidL);
        return new ResponseEntity<>(empRetrieved, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empid}")
    public ResponseEntity<?> deleteEmpById(@PathVariable("empid") Long empidL){

        employeeService.deleteEmpById(empidL);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
        Employee employeeSaved = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employeeSaved, HttpStatus.CREATED);
    }
}
