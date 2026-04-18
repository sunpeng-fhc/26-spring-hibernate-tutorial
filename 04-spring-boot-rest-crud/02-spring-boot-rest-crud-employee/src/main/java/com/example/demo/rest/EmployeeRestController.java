package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;


    private JsonMapper jsonMapper;

    //   quick and dirty: inject employee service (use constructor injection)
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService,JsonMapper theJsonMapper) {
        employeeService = theEmployeeService;
        jsonMapper = theJsonMapper;
    }



    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
         return  employeeService.findAll();
    }



    // add mapping for GET /employee/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if (employee == null){
            throw  new RuntimeException("Employee id not found - " + employeeId);
        }
        return  employee;
    }

    // add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        // if an id is provided in the request, ignore it
        // set id to null to ensure Hibernate performs an INSERT instead of UPDATE
        theEmployee.setId(null);

        Employee dbEmployee =   employeeService.save(theEmployee);

        return  dbEmployee;
    }


    // add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee =   employeeService.save(theEmployee);

        return  dbEmployee;
    }


    // add mapping for PATCH
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable Integer employeeId,
                                  @RequestBody Map<String, Object> patchPayload){

        Employee tempEmployee = employeeService.findById(employeeId);

        //throw exception if null
        if (tempEmployee == null){
            throw new RuntimeException("Employee is not found - " + employeeId);
        }

        // throw exception if request body contains "id" key
        if (patchPayload.containsKey("id")){
            throw new RuntimeException("Employee id  not allowed  in request body " + employeeId);
        }

        Employee patchEmployee = jsonMapper.updateValue(tempEmployee,patchPayload);

        Employee dbEmployee = employeeService.save(patchEmployee);

        return  dbEmployee;
    }




    // add mapping for DELETE /employees/{employeeId} - delete existing employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);
        if (tempEmployee == null){
            throw new RuntimeException("Employee is not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId ;
    }














}
