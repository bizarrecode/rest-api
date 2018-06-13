package com.bizarrecode.restapi.service;

import java.util.List;

import com.bizarrecode.restapi.model.Employee;

public interface EmployeeService {
	
	public Employee getEmployeeById(int id);
	public Employee saveEmployee(Employee employee);
    public void deleteEmployeeById(int id);
    public List<Employee> listAllEmployees();
    
}
