package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import model.Genre;
import model.Role;
import model.User;
import model.UserGenre;

import com.mysql.jdbc.Connection;

import data.ConnectionFactory;

public class UserGenreDao {
	Connection con = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;

	public UserGenreDao() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(User u, Genre g) throws ParseException {
		try {

			String querystring = "INSERT INTO user_genre VALUES(?,?)";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			ptmt.setInt(1, u.getId());
			ptmt.setInt(2, g.getId());
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

	public void update(User u, Genre g) {
		try {
			String querystring = "UPDATE user_genre SET idgenre=? WHERE iduser=?";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);

			ptmt.setInt(1, u.getId());
			ptmt.setInt(2, g.getId());
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
			String querystring = "DELETE FROM user_genre WHERE iduser=?";
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
		ArrayList<UserGenre> ul = new ArrayList();
		UserGenre ug = null;
		Genre g = null;
		User u = null;
		UserDao ud = new UserDao();
		GenreDao gd = new GenreDao();

		try {
			String querystring = "SELECT * FROM user_genre";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			rs = ptmt.executeQuery();
			while (rs.next()) {

				u = ud.findByPrimaryKey(rs.getInt(1));
				g = gd.findByPrimaryKey(rs.getInt(2));
				ug = new UserGenre(u, g);

				ul.add(ug);
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
		return ul;
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
