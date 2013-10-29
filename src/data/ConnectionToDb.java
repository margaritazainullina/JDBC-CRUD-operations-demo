package data;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionToDb {
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loading success!");
			String url = "jdbc:mysql://localhost/mysql";
			String name = "root";
			String password = "root";
			try {
				Connection con = (Connection) DriverManager.getConnection(url,
						name, password);
				System.out.println("Connected.");
				con.close();
				System.out.println("Disconnected.");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
