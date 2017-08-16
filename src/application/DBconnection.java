package application;

import java.sql.*;

public class DBconnection {

	public static Connection Connector() {
		try {
			//Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movierecom","root","root");
			System.out.println("SQL is connected");
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
