package com.example.sys;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo pr;
     
    
    public Employee create(Employee p)
    {
       
        return pr.save(p);
    }
    public List<Employee> fetchDepartmentList() 
    { 
        return (List<Employee>) pr.findAll(); 
    } 
    //getbyid
    public Employee getbyid(int employeeId)
    {
        return pr.findById(employeeId).orElse(null);
    }
    public List<Employee> getbysort(String field)
    {
        return pr.findAll(Sort.by(Sort.Direction.ASC,field));
    }
    //put
    public boolean updateDetails(int employeeId,Employee p)
        {
            if(pr.findById(employeeId)==null)
            {
                return false;
            }
            try{
                pr.save(p);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }
        public boolean deleteEmployee(int employeeId)
        {
            if(this.getbyid(employeeId) == null)
            {
                return false;
            }
            pr.deleteById(employeeId);
            return true;
        }

}


