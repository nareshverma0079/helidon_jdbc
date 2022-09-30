package com.prj.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.prj.model.Employee;
import com.prj.repo.EmployeeRepo;

@ApplicationScoped
public class EmpServiceImpl implements EmpService{

	@Inject
	EmployeeRepo repo;
	
	@Override
	public Employee saveEmp(Employee employee) {
		
		return repo.saveEmp(employee);
	}

	@Override
	public Employee getEmp(int id) {
		return repo.getEmp(id);
	}

	@Override
	public boolean updateEmp(Employee employee, int id) {
		return repo.updateEmp(employee, id);
	}

}
