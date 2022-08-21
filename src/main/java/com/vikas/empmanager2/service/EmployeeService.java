package com.vikas.empmanager2.service;

import com.vikas.empmanager2.exception.UserNotFoundException;
import com.vikas.empmanager2.model.Employee;
import com.vikas.empmanager2.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private  final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees (){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) throws Throwable {
        return employeeRepo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("User by Id"+id+"Not found") )  ;
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }




}
