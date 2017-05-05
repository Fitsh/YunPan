package com.YunPan.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.YunPan.dao.file;
import com.YunPan.dao.fileDao;
import com.YunPan.util.db.DBUtils;

public class fileDaoImpl implements fileDao {

	@Override
	public void add(file f) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into files(newname,oldname,fileType,size,username,savePath,contentType)value(?,?,?,?,?,?,?)";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, f.getNewName());
			ps.setString(2, f.getOldName());
			ps.setString(3, f.getFileType());
			ps.setInt(4, f.getSize());
			ps.setString(5, f.getUsername());
			ps.setString(6, f.getSavePath());
			ps.setString(7, f.getContentType());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtils.close(null,ps,conn);
	}
	@Override
	public void del(String newname) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from files where newname=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,newname);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.close(null,ps,conn);
		}
	}
	public boolean find(List<String> list,String s)
	{
		for(String it:list)
		{
			if(it.equals(s))
				return true;
		}
		return false;
	}
	@Override
	public List<file> findByType(List<String> cc, String username) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		file f = null;
		List<file> files = new ArrayList<file>();
		String sql = "select newname,oldname,size,savepath,filetype,contentType from files where  username=?";
		try{
			conn = DBUtils.getConnection();
			System.out.println("i");
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,username);
			rs = ps.executeQuery();
			while(rs.next()){
				if((find(cc,rs.getString(5)) && cc.size()<10)||(!find(cc,rs.getString(5)) &&cc.size()>=10) )
				{
					f = new file(rs.getString(1),rs.getNString(2),rs.getString(5),rs.getInt(3),username,rs.getString(4),rs.getString(6));
					files.add(f);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("失败");
		}finally{
			DBUtils.close(rs,ps,conn);
		}
		return files;
	}
	@Override
	public List<file> findByPath(String path, String username) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		file f = null;
		List<file> files = new ArrayList<file>();
		String sql = "select newname,oldname,fileType,size,contentType from files where savePath=? and username=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,path);
			ps.setString(2,username);
			rs = ps.executeQuery();
			while(rs.next()){
				f = new file(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),username,path,rs.getString(5));
				files.add(f);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("失败");
		}finally{
			DBUtils.close(rs,ps,conn);
		}
		return files;
	}
	
}
