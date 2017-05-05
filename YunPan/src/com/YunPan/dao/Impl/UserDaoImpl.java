package com.YunPan.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.YunPan.dao.User;
import com.YunPan.dao.UsersDao;
import com.YunPan.util.db.DBUtils;

public class UserDaoImpl implements UsersDao {

	

	@Override
	public boolean login(User user) throws SQLException {
		// TODO Auto-generated method stub
		return findAll(user.getUsername(),user.getPassword());
	}

	public boolean register(User user) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(user.getUsername());
		if(find(user.getUsername()))
			return false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into User(username,password)value(?,?)";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
		DBUtils.close(null,ps,conn);
		}
	}

	@Override
	public void deleteUser(String username) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from User where username=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.close(null,ps,conn);
		}
	}

	@Override
	public boolean find(String username) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from User where username=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			rs = ps.executeQuery();
			if(rs.next())
				return true;
			return false;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			DBUtils.close(null,ps,conn);
		}
		
	}
	public boolean findAll(String username,String password) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select password from User where username=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			rs = ps.executeQuery();
			
			if(rs!=null && rs.next() &&rs.getString(1).equals(password)  )
			{
				return true;
			}
			return false;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			DBUtils.close(null,ps,conn);
		}
		
	}

}
