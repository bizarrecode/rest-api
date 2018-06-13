package com.bizarrecode.restapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bizarrecode.restapi.model.Employee;
import com.bizarrecode.restapi.repository.EmployeeRepository;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner setup(EmployeeRepository employeeRepository) {
		return (args) -> {
			Employee employee = new Employee();
			employee.setName("name");
			employee.setSurname("surname");
			employee.setPhone("phone");
			employeeRepository.save(employee);
		};
	}
}
