package com.revature.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeePostgres implements EmployeeDao {

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "select * from employees;";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("empl_id");
				String empl_name = rs.getString("empl_name");
				double empl_salary = rs.getDouble("empl_salary");
				String empl_role = rs.getString("empl_role");
				String empl_email = rs.getString("empl_email");
				String empl_pass = rs.getString("empl_pass");
				Employee manager = new Employee(rs.getInt("manager_id"));
				
				Employee employee = new Employee(id, empl_name, empl_salary, empl_role, empl_email, empl_pass,manager);
				employees.add(employee);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public int addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
