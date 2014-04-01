package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import model.Genre;
import model.Role;

import com.mysql.jdbc.Connection;

import data.ConnectionFactory;

public class GenreDao {
	Connection con = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;

	public GenreDao() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(Genre g) throws ParseException {
		try {

			String querystring = "INSERT INTO Genre VALUES(?,?)";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			ptmt.setInt(1, g.getId());
			ptmt.setString(2, g.getGenre());
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

	public void update(Genre g) {
		try {
			String querystring = "UPDATE ROLE SET ROLE=? WHERE IDROLE=?";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);

			ptmt.setInt(1, g.getId());
			ptmt.setString(2, g.getGenre());
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
			String querystring = "DELETE FROM Genre WHERE IDGenre=?";
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
		ArrayList<Genre> genres = new ArrayList();
		Genre g = null;
		try {
			String querystring = "SELECT * FROM Genre";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				g = new Genre();
				g.setId(rs.getInt(1));
				g.setGenre(rs.getString(2));
				genres.add(g);
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
		return genres;
	}

	public Genre findByPrimaryKey(int id) {

		Genre g = null;
		try {
			String querystring = "SELECT * FROM Genre WHERE IDGenre=?";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			ptmt.setInt(1, id);
			rs = ptmt.executeQuery();
			if (rs.next()) {
				g = new Genre();
				g.setId(rs.getInt(1));
				g.setGenre(rs.getString(2));

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
		return g;
	}
	
}
