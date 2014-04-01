package model;

public class UserGenre {
	private User user;
	private Genre genre;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public UserGenre(User user, Genre genre) {
		super();
		this.user = user;
		this.genre = genre;
	}

	public UserGenre() {
	}
}
