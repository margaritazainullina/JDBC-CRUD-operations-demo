package main;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;

import model.Address;
import model.Genre;
import model.Role;
import model.User;
import dao.AddressDao;
import dao.GenreDao;
import dao.RoleDao;
import dao.UserDao;
import dao.UserGenreDao;

public class Test {
	public static void main(String[] args) throws ParseException {

		Role r = new Role(0, "user");
		Address a = new Address(0, "Ukraine", "Kharkiv", "Tankopiya", null,
				"14");
		Genre g = new Genre(0, "Rock");
		ArrayList<Genre> genres = new ArrayList<Genre>();
		genres.add(g);

		Date date = java.sql.Date.valueOf("1995-03-26");

		User u = new User(0, "Margarita", "Zainullina", date, a, r, genres);

		RoleDao rd = new RoleDao();
		AddressDao ad = new AddressDao();
		UserDao ud = new UserDao();
		GenreDao gd = new GenreDao();
		UserGenreDao ugd = new UserGenreDao();

		ugd.delete(0);
		ud.delete(0);
		rd.delete(0);
		ad.delete(0);
		gd.delete(0);

		rd.add(r);
		ad.add(a);
		gd.add(g);
		ud.add(u);

		Role r1 = new Role(0, "Admin");
		rd.update(r1);
		
		Address a1 = new Address(0, "Ukraine", "Kharkiv", "Tankopiya", "06100",
				"14");
		ad.update(a1);

		User u1 = new User(0, "Margarita", "Zainullina1", date, a, r, genres);
		ud.update(u1);
		
		System.out.println("Roles:");
		ArrayList<Role> rl = rd.findAll();
		for (Role role : rl) {
			System.out.println(role.toString());
		}

		System.out.println("Addresses:");
		ArrayList<Address> al = ad.findAll();
		for (Address address : al) {
			System.out.println(address.toString());
		}

		System.out.println("Users:");
		ArrayList<User> ul = ud.findAll();
		for (User users : ul) {
			System.out.println(users.toString());
		}

		System.out.println("Genres:");
		ArrayList<Genre> gl = gd.findAll();
		for (Genre ge : gl) {
			System.out.println(ge.toString());
		}

	}
}
