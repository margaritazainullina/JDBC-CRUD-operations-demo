package model;

import java.util.ArrayList;
import java.util.Date;

public class User {
	private int id;
	private String fName;
	private String lName;
	private Date birthday;
	private Address address;
	private Role role;
	private ArrayList<Genre> genres;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public ArrayList<Genre> getGenres() {
		return genres;
	}

	public void setGenres(ArrayList<Genre> genres) {
		this.genres = genres;
	}

	/*public User(int id, String fName, String lName, Date birthday,
			Address address, Role role) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.birthday = birthday;
		this.address = address;
		this.role = role;
	}*/
	
	public User(int id, String fName, String lName, Date birthday,
			Address address, Role role, ArrayList<Genre> genres) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.birthday = birthday;
		this.address = address;
		this.role = role;
		this.genres = genres;
	}

	public User() {
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.id);
		sb.append(" - ");
		sb.append(this.fName);
		sb.append(" ");
		sb.append(this.lName);
		sb.append(" - ");
		sb.append(this.birthday);
		sb.append(" ");
		sb.append(this.role.toString());
		sb.append(" ");
		sb.append(this.address.toString());
		sb.append(", Genres:");
		ArrayList<Genre> gg = this.getGenres();
		/*for (Genre g : gg) {
			sb.append(g.toString());
			sb.append("\n");
		}*/
		
		return sb.toString();
	}
}
