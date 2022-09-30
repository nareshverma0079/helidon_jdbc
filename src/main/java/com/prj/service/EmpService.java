package com.prj.service;

import com.prj.model.Employee;

public interface EmpService {

	Employee saveEmp(Employee employee);
	Employee getEmp(int id);
	boolean updateEmp(Employee employee, int id);
}
