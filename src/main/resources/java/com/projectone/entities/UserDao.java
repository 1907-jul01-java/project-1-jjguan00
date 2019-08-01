package com.projectone.entities;
import java.util.Scanner;
import java.sql.*;
import com.projectone.models.User;
import com.projectone.controllers.UserController;
public class UserDao {
	Connection connection;
	public UserDao(Connection connection) {
		this.connection = connection;
	}
	public void createUser(User user) {
		try {
			PreparedStatement pStatement = connection
					.prepareStatement("insert into users(email, name, password) values(?,?,?)");
			pStatement.setString(1, user.getEmail());
			pStatement.setString(2, user.getName());
			pStatement.setString(3, user.getPassword());
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			System.out.println("Thank you for signing up for bank. You can log in now.");
		}
	}

}
