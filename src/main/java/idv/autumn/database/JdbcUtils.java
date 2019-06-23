package idv.autumn.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

	public static Connection getConnection(String driverUrl, String connString, String username, String password) {
		Connection connection = null;
		try {
			Class.forName(driverUrl);
			connection = DriverManager.getConnection(connString, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Success!");
		return connection;
	}
}