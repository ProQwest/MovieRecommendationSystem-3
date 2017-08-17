package recommendations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecommendationsModel {
	
	private Connection connection;
	
	public RecommendationsModel(Connection connection) {
		this.connection = connection;
	}
	
	public List<String> getMoviesByGenrer(String genrer) throws SQLException {
		
		List<String> movieNames = new ArrayList<>();
		String query = "SELECT name FROM Movie WHERE genrers LIKE ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, "%" + genrer + "%");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			movieNames.add(rs.getString("name"));
		}
		
		return movieNames;
		
	}

}
