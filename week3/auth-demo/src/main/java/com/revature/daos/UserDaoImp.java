package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImp implements UserDao {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	@Override
	public User getUserById(int id) throws UserNotFoundException {//Retrieve an user from the database user table based on the given ID
		String sql = "select * from users where id = ?";
		User user = null;
		try{
			conn = ConnectionUtil.getConnectionFromEnv();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id); // 1 refers to first ? to parameterize
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int userId = rs.getInt("id");
				String username = rs.getString("username");
				String role = rs.getString("password");
				String password = rs.getString("role");
				user = new User(userId, username, role, password);
			}
		} catch (SQLException e) {
			e.fillInStackTrace();
		}
		return user;
	}
	
	@Override
	public User getUserByUsername(String name) throws UserNotFoundException {//Retrieve an user from the database user table based on the given ID
		String sql = "select * from users where username = ?";
		User user = null;
		
		try{
			conn = ConnectionUtil.getConnectionFromEnv();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name); // 1 refers to first ? to parameterize
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int userId = rs.getInt("id");
				String username = rs.getString("username");
				String role = rs.getString("role");
				String password = rs.getString("password");
				user = new User(userId, username, role, password);
			}
		} catch (SQLException e) {
			e.fillInStackTrace();
		}
		
		return user;
	}
//
//	@Override
//	public List<User> getUsers() {//Retrieve an array list of all the rows on the users table from the database
//		List<User> users = new ArrayList<>();
//		
//		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
//			String sql = "select * from users;";
//			Statement s = con.createStatement();
//			ResultSet rs = s.executeQuery(sql);
//			
//			while(rs.next()) {
//				int userId = rs.getInt("user_id");
//				String username = rs.getString("username");
//				String password = rs.getString("pass");
//				int permissionLevel = rs.getInt("perm_level");
//				User user = new User(userId, username, password, permissionLevel);
//
//				users.add(user);
//			}
//			
//		} catch (SQLException e) {
//			log.error("Failed to find any users.");
//		}
//		return users;
//	}
//
//	@Override
//	public boolean addUser(User user) {//Add a user to the users database table
//		int id = -1;
//		String sql = "insert into users (username, pass, perm_level) values (?,?,?) returning user_id;";
//		
//		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
//			
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, user.getUsername());
//			ps.setString(2, user.getPassword());
//			ps.setInt(3, user.getPermissionLevel());
//			
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				id = rs.getInt("user_id");
//			}
//			return true;
//	    }  catch (SQLException e)  {
//			log.error("Failed to add given user with information " + user);
//	    }
//		return false;
//	}
//
//	@Override
//	public int deleteUser(int id) throws UserNotFoundException {//Delete a user from the users table on the database
//		String sql = "delete from users where user_id = ?;";
//		int rowsChanged = -1;
//		
//		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setInt(1, id);
//			
//			rowsChanged = ps.executeUpdate();
//		} catch (SQLException e) {
//			log.error("Failed to delete user with Id " + id);
//		}
//		return rowsChanged;
//	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteUser(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}
}
