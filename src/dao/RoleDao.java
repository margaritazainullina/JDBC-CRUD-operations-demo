package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import model.Role;
import model.User;

import com.mysql.jdbc.Connection;

import data.ConnectionFactory;

public class RoleDao {
	Connection con = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;

	public RoleDao() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(Role r) throws ParseException {
		try {		
			
			String querystring = "INSERT INTO Role VALUES(?,?)";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			ptmt.setInt(1, r.getId());
			ptmt.setString(2, r.getRole());
			ptmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	public void update(Role r) {
		try {
			String querystring = "UPDATE ROLE SET ROLE=? WHERE IDROLE=?";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
						
			ptmt.setString(1, r.getRole());
			ptmt.setInt(2, r.getId());
			ptmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void delete(int id) {

		try {
			String querystring = "DELETE FROM ROLE WHERE IDROLE=?";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			ptmt.setInt(1, id);
			ptmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public ArrayList findAll() {
		ArrayList roles = new ArrayList();
		Role r = null;
		try {
			String querystring = "SELECT * FROM ROLE";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				r = new Role();
				r.setId(rs.getInt(1));
				r.setRole(rs.getString(2));
				roles.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return roles;
	}

	public Role findByPrimaryKey(int id) {

		Role r = null;
		try {
			String querystring = "SELECT * FROM ROLE WHERE IDROLE=?";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			ptmt.setInt(1, id);
			rs = ptmt.executeQuery();
			if (rs.next()) {
				r = new Role();
				r.setId(rs.getInt(1));
				r.setRole(rs.getString(2));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return r;
	}

}
