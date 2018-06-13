package com.bizarrecode.restapi.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bizarrecode.restapi.RestApiApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RestApiApplication.class)
@SpringBootTest
public class EmployeeControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() throws Exception {
    	this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testAllEmployeeList() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/employees/employees").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(1))).andDo(print());
    }
    
    @Test
	public void testGetEmployeeById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/employees/get-employee/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.name").exists())
		.andExpect(jsonPath("$.surname").exists())
		.andExpect(jsonPath("$.phone").exists())
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.name").value("name"))
		.andExpect(jsonPath("$.surname").value("surname"))
		.andExpect(jsonPath("$.phone").value("phone"))
		.andDo(print());
	}

    @Test
	public void testInvalidEmployeeArgument() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/employees/get-employee/f").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.errorCode").value(400))
			.andExpect(jsonPath("$.message").value("Invalid argument."))
			.andDo(print());
	}
	
    @Test
	public void testInvalidEmployeeId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/employees/get-employee/0").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("Employee doesn´t exist"))
		.andDo(print());
	}
    
    @Test
	public void testNullEmployee() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/employees/get-employee/7").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("Employee doesn´t exist"))
		.andDo(print());
	}
    
    @Test
	public void testDeleteEmployee() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/employees/delete-employee/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.status").value(200))
		.andExpect(jsonPath("$.message").value("Employee has been deleted"))
		.andDo(print());
	}
    
    @Test
	public void testInvalidEmployeeIdToDelete() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/employees/delete-employee/7").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("Employee to delete doesn´t exist"))
		.andDo(print());
	}

    @Test
	public void testSaveEmployee() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/employees/add-employee/")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\" : \"name2\", \"surname\" : \"surname2\", \"phone\" : \"phone2\" }")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.name").exists())
		.andExpect(jsonPath("$.surname").exists())
		.andExpect(jsonPath("$.phone").exists())
		.andExpect(jsonPath("$.id").value(2))
		.andExpect(jsonPath("$.name").value("name2"))
		.andExpect(jsonPath("$.surname").value("surname2"))
		.andExpect(jsonPath("$.phone").value("phone2"))
		.andDo(print());
	}
    
    @Test
	public void testUpdateEmployee() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/employees/update-employee/")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{ \"id\": \"2\", \"name\" : \"new name\", \"surname\" : \"new surname\", \"phone\" : \"new phone\" }")
        .accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.name").exists())
		.andExpect(jsonPath("$.surname").exists())
		.andExpect(jsonPath("$.phone").exists())
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.name").value("new name"))
		.andExpect(jsonPath("$.surname").value("new surname"))
		.andExpect(jsonPath("$.phone").value("new phone"))
		.andDo(print());
	}
    
    @Test
	public void testInvalidEmployeeUpdate() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/employees/update-employee/")
        .contentType(MediaType.APPLICATION_JSON)
       .content("{ \"id\": \"7\", \"name\" : \"name7\", \"surname\" : \"surname7\", \"phone\" : \"phone7\" }")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("Employee to update doesn´t exist"))
		.andDo(print());
	}

}
