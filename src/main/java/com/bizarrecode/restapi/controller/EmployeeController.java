package com.bizarrecode.restapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bizarrecode.restapi.model.Employee;
import com.bizarrecode.restapi.model.Response;
import com.bizarrecode.restapi.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1/employees")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listAllEmployees() throws Exception {
		
    	logger.info("Return list of employee");
        return new ResponseEntity<List<Employee>>(employeeService.listAllEmployees(), HttpStatus.OK);
        
    }
	
    @RequestMapping(value = "/get-employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) throws Exception {
    	
    	logger.info("Employee id to return " + id);
    	Employee employee = employeeService.getEmployeeById(id);
    	if (employee == null || employee.getId() <= 0){
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		
    }

    @RequestMapping(value = "/delete-employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> deleteEmployee(@PathVariable("id") int id) throws Exception {
    	
    	logger.info("Employee id to delete " + id);
    	Employee employee = employeeService.getEmployeeById(id);
    	if (employee == null || employee.getId() <= 0){
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Employee has been deleted"), HttpStatus.OK);
    
    }

    @RequestMapping(value = "/add-employee", method = RequestMethod.POST)
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws Exception {
    	
    	logger.info("Employee to create" );
    	if (employee.getId() > 0){
    		return ResponseEntity.status(HttpStatus.CONFLICT).build();
    	}
    	return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.OK);
    
    }

    @RequestMapping(value = "/update-employee", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws Exception {
    	
    	logger.info("Employee id to delete " + ( employee != null ? employee.getId() : ""));
    	if (employee == null || employee.getId() <= 0){
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.OK);
    
    }

}
