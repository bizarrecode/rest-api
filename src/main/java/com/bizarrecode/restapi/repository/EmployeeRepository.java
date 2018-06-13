package com.bizarrecode.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bizarrecode.restapi.model.Employee;

@Repository("employeeRepository")
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

}
