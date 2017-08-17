package mapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.DBconnection;

public class DBMapper {
	
	public static void mapMovieRecommendationsFile() throws IOException, SQLException {
		
		// Reading file
		File file = new File("src/recommendations.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		Connection connection = DBconnection.Connector();
		
		String readLine = "";
		
		while ((readLine = br.readLine()) != null) {
			
			System.out.println(readLine);
			String[] movieInfo = readLine.split(",");
			
			// Adding movie to the table
			String query = "INSERT INTO Movie VALUES(?,?);";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, movieInfo[0].trim());
			ps.setString(2, movieInfo[1].trim());
			
		}
		
	}

}
