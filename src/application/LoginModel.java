package application;

import java.sql.*;

public class LoginModel {
	Connection con;
	
	public LoginModel() {
		con = DBconnection.Connector();
		if(con == null)
			System.exit(1);
	}
	
	public boolean isBDConnected() {
		try {
			return !con.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return false;
		}
	}
	
	public boolean isLogin(String user, String pass) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "Select * from tbl_user where username = ? and password = ?";
		
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			return false;
		} finally {
			ps.close();
			rs.close();
		}
	}
}
