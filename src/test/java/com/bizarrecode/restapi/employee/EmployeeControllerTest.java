package com.bizarrecode.restapi.employee;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bizarrecode.restapi.controller.EmployeeController;
import com.bizarrecode.restapi.model.Employee;
import com.bizarrecode.restapi.service.EmployeeService;
/**
* @author <a href="mailto:ekarach.kmt@gmail.com">Eakarach Kotmontri</a>
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {
	
	@MockBean
	EmployeeService employeeService;

    @Autowired
    EmployeeController restApiController;

    @Before
    public void setUp() throws Exception {
    	Mockito.when(employeeService.getEmployee(1)).thenReturn(new Employee(1, "John", "Wick", "023456789"));
    }

    @Test
    public void getEmployee() throws Exception {
        Employee employee = employeeService.getEmployee(1);
        Assert.assertEquals("John", employee.getName());
        Assert.assertEquals("Wick", employee.getSurname());
        Assert.assertEquals("023456789", employee.getPhone());
    }

    @Test
    public void deleteEmployee() throws Exception {
        employeeService.deleteEmployee(1);
    }

    @Test
    public void addEmployee() throws Exception {
       employeeService.addEmployee(
    		   new Employee(2, "John", "Rambo", "xxxxxxxxxx")
       );
    }

    @Test
    public void listAllEmployees() throws Exception {
        List<Employee> listResponseEntity = employeeService.listAllEmployees();
        Assert.assertEquals(0, listResponseEntity.size());
    }

    @Test
    public void updateEmployee() throws Exception {
        employeeService.updateEmployee(
        		new Employee(2, "John", "Rambo", "yyyyyyyyyy")
        );
    }

}
