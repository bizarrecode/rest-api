package com.bizarrecode.restapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizarrecode.restapi.model.Employee;
import com.bizarrecode.restapi.repository.EmployeeRepository;
import com.bizarrecode.restapi.service.EmployeeService;
/**
* @author <a href="mailto:ekarach.kmt@gmail.com">Eakarach Kotmontri</a>
*/
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee getEmployee(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException(
					"The object can not be null.");
		}
		return employeeRepository.findById(id).get();
	}

	@Override
	public void deleteEmployee(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException(
					"The object can not be null.");
		}
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> listAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void addEmployee(Employee employee) {
		if (employee == null) {
			throw new IllegalArgumentException(
					"The object can not be null.");
		}
		employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		if (employee == null || employee.getId() <= 0) {
			throw new IllegalArgumentException(
					"The object can not be null.");
		}
		employeeRepository.save(employee);
	}

}
