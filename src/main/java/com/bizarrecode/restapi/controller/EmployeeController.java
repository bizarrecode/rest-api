package com.bizarrecode.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bizarrecode.restapi.model.Employee;
import com.bizarrecode.restapi.service.EmployeeService;
/**
* @author <a href="mailto:ekarach.kmt@gmail.com">Eakarach Kotmontri</a>
*/
@RestController
@RequestMapping(value = "/api/v1/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
    
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/get-employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getMEmployee(@PathVariable("id") int id) {
        try {
        	Employee employee = employeeService.getEmployee(id);
            if (employee != null) {
                return ResponseEntity.status(HttpStatus.OK).body(employee);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/delete-employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
        try {
        	employeeService.deleteEmployee(id);;
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/add-employee", method = RequestMethod.POST)
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
        try {
        	employeeService.addEmployee(employee);;
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listAllEmployees() {
        try {
            List<Employee> result = employeeService.listAllEmployees();
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/update-employee", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee) {
        try {
        	employeeService.updateEmployee(employee);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
