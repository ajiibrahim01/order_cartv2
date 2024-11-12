package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.entity.User;
import com.shop.infrastructure.DBUtils;
import com.shop.dto.*;
public class UserRepo {
	
	public User getUser(String username, String password) {
		Connection connection = null;
		BasicAuth auth = new BasicAuth();
		String encodedUsername = auth.encode(username);
		String encodedPassword = auth.encode(password);
		
		User user = null;
		try {

			connection = DBUtils.getConnection();
	
			String query = "SELECT user_name,user_role from user where user_name =(?) AND user_password = (?)";
			
			PreparedStatement getIdState = connection.prepareStatement(query);
			getIdState.setString(1, encodedUsername);
			getIdState.setString(2, encodedPassword);
			
			ResultSet rs = getIdState.executeQuery();
			
			while(rs.next()) {
			String name = auth.decode(rs.getString("user_name"));
			String role = rs.getString("user_role");
			user = new User(name,role);
			}
			//order = currentOrder;
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(connection);
		}
		
		return user;
	}
	
	public int getUserId(String username) {
		int userId = 0;
		Connection connection = null;
		try {

			connection = DBUtils.getConnection();
	
			String query = "SELECT id from user WHERE user.user_name =?";
			
			PreparedStatement getIdState = connection.prepareStatement(query);
			getIdState.setString(1, username);

			ResultSet rs = getIdState.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				userId = id;
			}
			//order = currentOrder;
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(connection);
		}
		return userId;
	}
}
