package com.bizarrecode.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bizarrecode.restapi.model.Employee;
/**
* @author <a href="mailto:ekarach.kmt@gmail.com">Eakarach Kotmontri</a>
*/
@Repository("employeeRepository")
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

}
