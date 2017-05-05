package com.YunPan.action;

import org.apache.jasper.tagplugins.jstl.core.Out;

import java.sql.SQLException;
import java.util.*;

import com.YunPan.dao.User;
import com.YunPan.dao.UsersDao;
import com.YunPan.dao.Impl.UserDaoImpl;

public class UserAction extends superAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	public String login() throws SQLException{
		
		UsersDao udao = new UserDaoImpl();
		if(udao.login(new User(username,password))){
			System.out.println("true");
			return "login_success";
		}
		else{
			System.out.println(password);
			System.out.println("false");
			return "login_failure";
		}
	}
	public String register() throws SQLException
	{
		UsersDao udao = new UserDaoImpl();
		if(udao.register(new User(username,password))){
			return "register_success";
		}
		else{
			return "register_failure";
		}
	}
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		//super.validate();
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
