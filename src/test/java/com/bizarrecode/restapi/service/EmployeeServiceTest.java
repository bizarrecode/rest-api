package com.bizarrecode.restapi.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bizarrecode.restapi.model.Employee;
import com.bizarrecode.restapi.repository.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllEmployee(){
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(1,"name1","surname1","phone1"));
		employeeList.add(new Employee(1,"name2","surname2","phone2"));
		employeeList.add(new Employee(1,"name3","surname3","phone3"));
		when(employeeRepository.findAll()).thenReturn(employeeList);
		
		List<Employee> result = employeeService.listAllEmployees();
		assertEquals(3, result.size());
	}
	
	@Test
	public void testGetEmployeeById(){
		Employee employee = new Employee(1,"name1","surname1","phone1");
		when(employeeRepository.findById(1)).thenReturn(employee);
		Employee result = employeeService.getEmployeeById(1);
		assertEquals(1, result.getId());
		assertEquals("name1", result.getName());
		assertEquals("surname1", result.getSurname());
		assertEquals("phone1", result.getPhone());
	}
	
	@Test
	public void testSaveEmployee(){
		Employee employee = new Employee(2,"name2","surname2","phone2");
		when(employeeRepository.save(employee)).thenReturn(employee);
		Employee result = employeeService.saveEmployee(employee);
		assertEquals(2, result.getId());
		assertEquals("name2", result.getName());
		assertEquals("surname2", result.getSurname());
		assertEquals("phone2", result.getPhone());
	}
	
	@Test
	public void testRemoveEmployee(){
		Employee employee = new Employee(2,"name2","surname2","phone2");
		when(employeeRepository.save(employee)).thenReturn(employee);
		Employee result = employeeService.saveEmployee(employee);
		employeeService.deleteEmployeeById(employee.getId());
        verify(employeeRepository, times(1)).delete(employee);
	}
	
}
