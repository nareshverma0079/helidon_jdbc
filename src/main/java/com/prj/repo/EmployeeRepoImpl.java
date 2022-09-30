package com.prj.repo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.prj.model.Employee;

@ApplicationScoped
public class EmployeeRepoImpl implements EmployeeRepo {
	
	
	@Inject
	@Named("employeeDataSource")
	DataSource ds;

	@Override
	public Employee saveEmp(Employee employee) {
		CallableStatement cstmt = null;
		Connection conn = null;
//		JSONObject jsonObject = new JSONObject();
		try {
			
//			Gson gson = new Gson();
//			String jsonData = gson.toJson(employee);
//			System.out.println(jsonData);
			
			conn = ds.getConnection();
			cstmt = conn.prepareCall("{call INSERT_EMP(?,?,?,?)}");
			cstmt.setInt(1, employee.getId());
			cstmt.setString(2, employee.getName());
			cstmt.setString(3, employee.getDesignation());
			cstmt.setString(4,employee.getAddress());
			cstmt.executeUpdate();
//			ResultSet rs = cstmt.executeQuery();
//			while(rs.next()) {
//				System.out.println(rs.getInt(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
//				System.out.println(rs.getString(4));
//			}
			
			
			
//			String result = cstmt.getString(5);
//			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return employee;
	}

	@Override
	public Employee getEmp(int id) {
		Employee employee = null;
		CallableStatement cstmt = null;
		Connection conn = null;
		try {
			
			conn= ds.getConnection();
			cstmt = conn.prepareCall("{call GET_EMP_BY_ID(?,?,?,?)}");
			cstmt.setInt(1, id);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			
			
//			cstmt.executeUpdate();
			String name = cstmt.getString(2);
			String designation = cstmt.getString(3);
			String address = cstmt.getString(4);
			
			employee = new Employee(id, name, designation, address);
			
			System.out.println("name = " + name);
	           System.out.println("designation = " + designation);
	           System.out.println("address = " +address);//returns java.Sql.Date
	           
	           System.out.println("Stored procedure executed successfully, "
	                 + "data has been fetched from Employee table");   
	           cstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public boolean updateEmp(Employee employee, int id) {
		
		boolean rowUpdated = false;
		Connection conn = null;
		CallableStatement cstmt = null;
		try {
			conn= ds.getConnection();
			cstmt = conn.prepareCall("{call UPDATE_EMP(?,?,?,?)}");
			cstmt.setInt(1, id);
			cstmt.setString(2, employee.getName());
			cstmt.setString(3, employee.getDesignation());
			cstmt.setString(4, employee.getAddress());
			
			
			
			rowUpdated =cstmt.executeUpdate()>0;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowUpdated;
	}

}
