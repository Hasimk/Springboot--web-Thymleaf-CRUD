package com.pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.model.Employee;
import com.pack.repository.EmployeeRepository;
import com.sun.el.stream.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
   private EmployeeRepository employeeReposiotry;
    
    @Override
    public List<Employee> getAllEmployees() {
        return employeeReposiotry.findAll();
        
    }

    @Override
    public void saveEmployee(Employee employee) {
        
        this.employeeReposiotry.save(employee);
        
        
    }

   @Override
    public Employee getEmployeeById(long id) {
      
        java.util.Optional<Employee> opt = employeeReposiotry.findById(id);
       
        Employee employee= null;
        if(opt.isPresent()) {
         employee = opt.get();
        
    }else {
        
        throw new RuntimeException("Employee not found ::" +id);
                      
        }
        
        return employee;
    }

@Override
public void deleteEmployeeById(long id) {
 
    this.employeeReposiotry.deleteById(id);
    
}

}
