package com.revature;

import java.util.List;

import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeePostgres;
import com.revature.models.Employee;

public class Driver {

	public static void main(String[] args) {
		
		EmployeeDao ed = new EmployeePostgres();
		List<Employee> emps = ed.getEmployees();
		for(Employee e : emps) {
			System.out.println(e);
		}

	}

}
