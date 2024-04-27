package com.example.sys;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService ps;
    
    
    @PostMapping("/api/employee")
    public ResponseEntity<Employee> adddata(@RequestBody Employee p)
    {
        Employee obj=ps.create(p);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }
    @GetMapping("/api/employees") 
    public List<Employee> fetchDepartmentList() 
    { 
        return ps.fetchDepartmentList(); 
    } 
    @GetMapping("/api/sort/{field}")
    public ResponseEntity<List<Employee>> get(@PathVariable String field)
    {
        try{
            return new ResponseEntity<>(ps.getbysort(field),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/api/employee/{employeeId}")
    public ResponseEntity<Employee> putMethod(@PathVariable("employeeId") int employeeId,@RequestBody Employee pd)
    {
        if(ps.updateDetails(employeeId,pd) == true)
        {
            return new ResponseEntity<>(pd,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/api/employee/{employeeId}")
    public ResponseEntity<Boolean> delete(@PathVariable("employeeId") int employeeId)
    {
        if(ps.deleteEmployee(employeeId) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}

