package model;

public class Genre {
	private int id;
	private String genre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Genre(int id, String genre) {
		super();
		this.id = id;
		this.genre = genre;
	}

	public Genre() {
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.id);
		sb.append(" - ");
		sb.append(this.genre);		
		return sb.toString();
	}
}
