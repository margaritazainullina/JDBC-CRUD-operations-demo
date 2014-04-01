package data;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {
	String driverClassName = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost/users";
	String dbUser = "root";
	String dbPwd = "root";

	private static ConnectionFactory connectionFactory = null;

	private ConnectionFactory() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = (Connection) DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		return conn;
	}

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}

}
