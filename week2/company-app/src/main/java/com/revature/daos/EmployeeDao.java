package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {
	public abstract Employee getEmployeeById(int id);
	public abstract List<Employee> getEmployees();
	public abstract int addEmployee(Employee employee);
	public abstract boolean updateEmployee(Employee employee);
	public abstract int deleteEmployee(int id);
	public abstract Employee getEmployeeByEmail(String email);
}
