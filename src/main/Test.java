package main;

import data.ConnectionToDb;

public class Test {
	public static void main(String[] args) {
	ConnectionToDb conn = new ConnectionToDb();
	conn.connect();
	}
}
