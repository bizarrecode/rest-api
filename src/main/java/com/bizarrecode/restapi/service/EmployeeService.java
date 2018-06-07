package com.bizarrecode.restapi.service;

import java.util.List;

import com.bizarrecode.restapi.model.Employee;

/**
* @author <a href="mailto:ekarach.kmt@gmail.com">Eakarach Kotmontri</a>
*/
public interface EmployeeService {
	public Employee getEmployee(int id);
    public void deleteEmployee(int id);
    public List<Employee> listAllEmployees();
    public void addEmployee(Employee employee);
    public void updateEmployee(Employee employee);
}
