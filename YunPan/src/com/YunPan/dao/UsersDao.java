package com.YunPan.dao;

import java.sql.SQLException;


public interface UsersDao {
	public boolean login(User user) throws SQLException;
	public boolean register(User user) throws SQLException;
	boolean find(String username) throws SQLException;
	void deleteUser(String username) throws SQLException;
	public boolean findAll(String username,String password) throws SQLException ;
	
}
