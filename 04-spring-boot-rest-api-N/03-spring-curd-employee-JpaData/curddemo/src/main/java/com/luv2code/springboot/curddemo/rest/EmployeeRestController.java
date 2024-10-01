package com.luv2code.springboot.curddemo.rest;
import com.luv2code.springboot.curddemo.entity.Employee;
import java.util.List;

import com.luv2code.springboot.curddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeRestController
{
//    private EmployeeDAO employeeDAO;
    private EmployeeService employeeService;

    //quick and dirty: inject employee dao(constructor j=injection)
    public EmployeeRestController(EmployeeService theemployeeservice)
    {
        employeeService = theemployeeservice;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //add mapping for GET/employees/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null)
        {
            throw new RuntimeException("Employee id not found - "+employeeId);

        }
        return  theEmployee;
    }

    //add mapping for POST/employee - add new employee
    @PostMapping("/employees")
    public  Employee addEmployee(@RequestBody Employee theEmployee)
    {
        //also just in case they pass an id in JSOn .. set it to 0
        //this is to force a save of new item..instead of update

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    //add mapping for PUT / employee - update existing employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        Employee dbEmployee = employeeService.save(theEmployee);

        return  dbEmployee;
    }


    //add mapping for DELETE /emmployee/{employeeID} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Employee tempEmployee = employeeService.findById(employeeId);

        //throw exception if null
        if(tempEmployee == null)
        {
            throw new RuntimeException("Employee does not exist" + employeeId);

        }

        employeeService.deleteById(employeeId);

        return  "Deleted employee id - " + employeeId;
    }

}
