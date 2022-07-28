package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import value.UsersValue;

public class UsersDAO {
	private Connection con;
	
	public UsersDAO(Connection con) {
		this.con = con;
	}
	
	public UsersValue findUsers(String userId) throws SQLException{
		String sql = "SELECT * FROM users WHERE user_id = ?";
		try(PreparedStatement pst = this.con.prepareStatement(sql)){
			pst.setString(1, userId);
			
			ResultSet rs = pst.executeQuery();
			
			UsersValue uv = null;
			if(rs.next()) {
				uv = new UsersValue(
						rs.getString("user_id"), 
						rs.getString("password"), 
						rs.getString("name"), 
						rs.getString("address")
						);
			}
			return uv;
		} catch(SQLException e) {
			throw e;
		}
	}
	
	public void updateUsers(String userId, String password, String name, String address) throws SQLException{
		String sql = "UPDATE users SET password = ?, name = ?, address = ?, WHERE = user_id = ?";
		try(PreparedStatement pst = this.con.prepareStatement(sql)){
			pst.setString(1, password);
			pst.setString(2, name);
			pst.setString(3, address);
			pst.setString(4, userId);
			
			pst.executeUpdate();
		} catch(SQLException e) {
			throw e;
		}
	}
}
