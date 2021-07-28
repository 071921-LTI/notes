package com.revature;

import java.util.List;

import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeePostgres;
import com.revature.models.Employee;

public class Driver {

	public static void main(String[] args) {
		
		EmployeeDao ed = new EmployeePostgres();
//		List<Employee> emps = ed.getEmployees();
//		for(Employee e : emps) {
//			System.out.println(e);
//		}
//		System.out.println(ed.getEmployeeById(1));
		Employee e = new Employee();
		e.setName("KevinTest");
		e.setEmail("SomeEmail1");
		e.setPassword("badPass1");
		e.setRole("Clown");
		e.setSalary(20.0);
		e.setManager(new Employee(1));
		
		int genId = ed.addEmployee(e);
		System.out.println("The generated id is:" + genId);
		System.out.println(ed.getEmployeeById(genId));
		System.out.println("Number of rows changed:" + ed.deleteEmployee(genId));
	}

}
