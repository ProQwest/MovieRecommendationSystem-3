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
		String query = "Select * from user_table where username = ? and password = ?";
		
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
	
	
	public void signup(String fname, String lname, String uname, String pass) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "insert into user_table(username,password,firstname,lastname) values(" + "'" + uname + "','" + pass + "','" + fname + "','" + lname + "'"+")";
		
		
		
		
		try {
			ps = con.prepareStatement(query);
			ps.executeUpdate();
			
			System.out.println(query);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ps.close();
			rs.close();
		}
	}
	
}
