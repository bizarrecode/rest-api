package com.bizarrecode.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizarrecode.restapi.model.Employee;
import com.bizarrecode.restapi.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.delete(id);
	}

	@Override
	public List<Employee> listAllEmployees() {
		return employeeRepository.findAll();
	}

}
