package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Address;
import model.Role;
import model.User;

import com.mysql.jdbc.Connection;

import data.ConnectionFactory;

public class AddressDao {
	Connection con = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;

	public AddressDao() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(Address a) throws ParseException {

		try {
			String querystring = "INSERT INTO Address VALUES(?,?,?,?,?,?)";
			// String querystring =
			// "INSERT INTO Address VALUES(0,'l','l','l','l','l')";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);

			ptmt.setInt(1, a.getId());
			ptmt.setString(2, a.getCountry());
			ptmt.setString(3, a.getCity());
			ptmt.setString(4, a.getStreet());
			ptmt.setString(5, a.getZipCode());
			ptmt.setString(6, a.getHouse());

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

	public void update(Address a) {

		try {
			String querystring = "UPDATE ADDRESS SET COUNTRY=?, CITY=?, STREET=?, ZIPCODE=?, HOUSE=? WHERE IDADDRESS=?";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);

			ptmt.setInt(1, a.getId());
			ptmt.setString(2, a.getCountry());
			ptmt.setString(3, a.getCity());
			ptmt.setString(4, a.getStreet());
			ptmt.setString(5, a.getZipCode());
			ptmt.setString(6, a.getHouse());
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
			String querystring = "DELETE FROM ADDRESS WHERE IDADDRESS=?";
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
		ArrayList addresses = new ArrayList();
		Address a = null;
		try {
			String querystring = "SELECT * FROM Address";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				a = new Address();
				a.setId(rs.getInt(1));
				a.setCountry(rs.getString(2));
				a.setCity(rs.getString(3));
				a.setStreet(rs.getString(4));
				a.setZipCode(rs.getString(5));
				// a.setHouse(rs.getString(6));
				addresses.add(a);
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
		return addresses;
	}

	public Address findByPrimaryKey(int id) {

		Address a = null;
		try {
			String querystring = "SELECT * FROM Address WHERE IDAddress=?";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			ptmt.setInt(1, id);
			rs = ptmt.executeQuery();
			if (rs.next()) {
				a = new Address();
				a.setId(rs.getInt(1));
				a.setCountry(rs.getString(2));
				a.setCity(rs.getString(3));
				a.setStreet(rs.getString(4));
				a.setZipCode(rs.getString(5));
				a.setHouse(rs.getString(6));
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
		return a;
	}

}
