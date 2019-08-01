package com.projectone.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private Connection connection;
	String url = "jdbc:postgresql://192.168.99.100:5432/postgres";
	String username = "postgres";
	String password = "postgres";

	public ConnectionUtil() {
		try {
			Class.forName("org.postgresql.Driver");
			this.connection = DriverManager.getConnection(this.url, this.username, this.password);
		} catch (SQLException e) {
			e.getMessage();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {

        }
    }
}