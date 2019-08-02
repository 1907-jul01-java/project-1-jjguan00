package com.projectone.entities;
import java.sql.*;
import com.projectone.models.User;
import com.projectone.controllers.UserController;
import com.projectone.models.LogInUser;
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
	
	public void login(LogInUser user) {
    	try {
    		PreparedStatement pStatement = connection.prepareStatement("select * from users where email = ? and password = ?");
    		pStatement.setString(1,user.getEmail());
    		pStatement.setString(2,user.getPassword());
    		ResultSet rs = pStatement.executeQuery();
		   if( rs.next()){
			   String email = rs.getString("email");
			   String name = rs.getString("name");
			   String password = rs.getString("password");
			   User loggeduser = new User(email,name,password);
			   System.out.println(loggeduser);
		   } else {
		        System.out.print("Wrong UserName and Password");
		   }
    	}catch(SQLException e) {
    		e.getMessage();
    	}
    }

}
