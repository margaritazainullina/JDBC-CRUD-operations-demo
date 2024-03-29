package model;

public class Role {
	private int id;
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Role(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	
	public Role() {
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.id);
		sb.append(" - ");
		sb.append(this.role);
		
		return sb.toString();
	}
}
