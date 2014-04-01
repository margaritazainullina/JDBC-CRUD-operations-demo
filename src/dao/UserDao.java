package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import model.Address;
import model.Genre;
import model.Role;
import model.User;

import com.mysql.jdbc.Connection;

import data.ConnectionFactory;

public class UserDao {
	Connection con = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;

	public UserDao() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	
	public void add(User u) throws ParseException {

		try {
			Role r = new Role();
			Address a = new Address();
			r = u.getRole();
			a = u.getAddress();
			ArrayList<Genre> g = u.getGenres();	
			
			String querystring = "INSERT INTO USER VALUES(?,?,?,?,?,?)";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			ptmt.setInt(1, u.getId());
			ptmt.setString(2, u.getfName());
			ptmt.setString(3, u.getlName());
			ptmt.setDate(4, (Date) u.getBirthday());
			ptmt.setInt(5, r.getId());
			ptmt.setInt(6, a.getId());
			ptmt.executeUpdate();
			
			UserGenreDao ugd = new UserGenreDao();
			for (Genre genre : g) {
				ugd.add(u, genre);
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
	}
	
	public void update(User u) {

		Role r = new Role();
		Address a = new Address();
		r = u.getRole();
		a = u.getAddress();
		ArrayList<Genre> g = u.getGenres();
		
		
		try {
			String querystring = "UPDATE USER SET FNAME=?,"
					+ "LNAME=?, BIRTHDAY=?, ROLEID=?, ADDRESSID=? WHERE IDUSER=?";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			ptmt.setString(1, u.getfName());
			ptmt.setString(2, u.getlName());
			ptmt.setDate(3, (Date) u.getBirthday());
			ptmt.setInt(4, r.getId());
			ptmt.setInt(5, a.getId());
			ptmt.setInt(6, u.getId());
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
			String querystring = "DELETE FROM USER WHERE IDUser=?";
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

	public ArrayList<User> findAll() {
		ArrayList<User> users = new ArrayList<>();
		
		AddressDao ad = new AddressDao();
		RoleDao rd = new RoleDao();		
		User u = null;
		
		try {
			String querystring = "SELECT * FROM USER";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setfName(rs.getString(2));
				u.setlName(rs.getString(3));
				u.setBirthday(rs.getDate(4));
				u.setAddress(ad.findByPrimaryKey(rs.getInt(5)));
				u.setRole(rd.findByPrimaryKey(rs.getInt(6)));				
				users.add(u);
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
		return users;
	}

	public User findByPrimaryKey(int id) {

		User u = null;
		RoleDao rd = new RoleDao();
		AddressDao ad =new AddressDao();
		
		try {	
			String querystring = "SELECT * FROM User WHERE IDUSER=?";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			ptmt.setInt(1, id);
			rs = ptmt.executeQuery();
			if (rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setfName(rs.getString(2));
				u.setlName(rs.getString(3));
				u.setBirthday(rs.getDate(4));
				u.setRole(rd.findByPrimaryKey(rs.getInt(5)));
				u.setAddress(ad.findByPrimaryKey(rs.getInt(6)));	
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
		return u;
	}
	
}
