package model;

import java.util.Date;

public class Address {
	private int id;
	private String country;
	private String city;
	private String street;
	private String zipCode;
	private String house;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public Address(int id, String country, String city, String street,
			String zipCode, String house) {
		super();
		this.id = id;
		this.country = country;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		this.house = house;
	}

	public Address() {
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.id);
		sb.append(", ");
		sb.append(this.country);
		sb.append(", ");
		sb.append(this.city);
		sb.append(", ");
		sb.append(this.street);
		sb.append(", ");
		sb.append(this.zipCode);
		sb.append(", ");
		sb.append(this.house);
		
		return sb.toString();
	}
}
