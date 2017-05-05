package com.YunPan.util.db;

import java.sql.*;

public class DBUtils {
	public final static String URL = "jdbc:mysql://localhost:3306/YunPan";
	public final static String USERNAME = "root";
	public final static String PASSWORD = "1234";
	public final static String DRIVER = "com.mysql.jdbc.Driver";
	private DBUtils(){
		
	}
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("驱动加载失败");
		}
		return conn;
	}
	public static void close(ResultSet rs,PreparedStatement state,Connection conn){
		try {
			if(rs!=null) rs.close();
			if(state!=null) state.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
