package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

	private final static String URL = "jdbc:mysql://localhost:3306/vehicles";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "128ShermanAvenue";
	private static Connection connection;
	private static dbConnection instance;
	
	private dbConnection(Connection connection) {
		dbConnection.connection = connection;
	}
	
	public static Connection getConnection() {
		if (instance == null) {
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new dbConnection(connection);
				System.out.println("CONNECTION SUCCESSFUL!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} return dbConnection.connection;
	}
}
