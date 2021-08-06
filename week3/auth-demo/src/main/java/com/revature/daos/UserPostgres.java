package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserPostgres implements UserDao {

    @Override
    public User getUserById(int id) throws UserNotFoundException {
        String sql = "Select * from users where id = ?";
        User user = null;
        try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");

                user = new User(userId, username, password, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user == null) {
            throw new UserNotFoundException();
        }

        return user;
    }

    @Override
    public User getUserByUsername(String username) throws UserNotFoundException {
        String sql = "Select * from users where username = ?";
        User user = null;
        try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("id");
                String returnedUsername = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");

                user = new User(userId, returnedUsername, password, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user == null) {
            throw new UserNotFoundException();
        }

        return user;
    }

    @Override
    public List<User> getUsers() {
        String sql = "select * from users";
        List<User> users = new ArrayList<>();

        try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");

                User user = new User(id, username, password, role);

                users.add(user);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

	@Override
	public int addUser(User user) {
		int id = -1;
		String sql = "insert into users (username, role, password) values (?,?,?) returning id;";
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getRole());
			ps.setString(3, user.getPassword());

			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}



	@Override
	public int deleteUser(int id) throws UserNotFoundException {
		String sql = "delete from users where id = ?;";
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

}
