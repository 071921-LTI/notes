package com.revature.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		String sql = "select * from employees where empl_id = ?";
		Employee emp = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id); // 1 refers to first ? to parameterize
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int empId = rs.getInt("empl_id");
				String empl_name = rs.getString("empl_name");
				double empl_salary = rs.getDouble("empl_salary");
				String empl_role = rs.getString("empl_role");
				String empl_email = rs.getString("empl_email");
				String empl_pass = rs.getString("empl_pass");
				int manId = rs.getInt("manager_id");
				emp = new Employee(empId, empl_name, empl_salary, empl_role, empl_email, empl_pass, new Employee(manId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "select e.empl_id \"e.empl_id\",e.empl_name \"e.empl_name\", e.empl_salary \"e.empl_salary\", e.empl_role \"e.empl_role\", e.empl_email \"e.empl_email\", e.empl_pass \"e.empl_pass\", \r\n"
					+ "m.empl_id \"m.empl_id\",m.empl_name \"m.empl_name\", m.empl_salary \"m.empl_salary\", m.empl_role \"m.empl_role\", m.empl_email \"m.empl_email\", m.empl_pass \"m.empl_pass\", m.manager_id \"m.manager_id\"\r\n"
					+ "from employees e\r\n"
					+ "join employees m\r\n"
					+ "on e.manager_id = m.empl_id;";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("e.empl_id");
				String empl_name = rs.getString("e.empl_name");
				double empl_salary = rs.getDouble("e.empl_salary");
				String empl_role = rs.getString("e.empl_role");
				String empl_email = rs.getString("e.empl_email");
				String empl_pass = rs.getString("e.empl_pass");
				Employee manager = new Employee(rs.getInt("m.empl_id"),rs.getString("m.empl_name"),rs.getDouble("m.empl_salary"),rs.getString("m.empl_role"),rs.getString("m.empl_email"),rs.getString("m.empl_pass"),new Employee(rs.getInt("m.manager_id")));
				
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
		int id = -1;
		String sql = "insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values (?,?,?,?,?,?) returning empl_id;";
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employee.getName());
			ps.setDouble(2, employee.getSalary());
			ps.setString(3, employee.getRole());
			ps.setString(4, employee.getEmail());
			ps.setString(5, employee.getPassword());
			ps.setInt(6, employee.getManager().getId());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("empl_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteEmployee(int id) {
		String sql = "delete from employees where empl_id = ?;";
		int rowsChanged = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsChanged;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
