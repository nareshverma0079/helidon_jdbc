package com.prj.repo;

import javax.validation.Valid;

import com.prj.model.Employee;

public interface EmployeeRepo {

	Employee saveEmp(Employee employee);
	
	Employee getEmp(int id);
	
	boolean updateEmp(Employee employee , int id);
}
