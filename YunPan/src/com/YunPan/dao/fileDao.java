package com.YunPan.dao;

import java.sql.SQLException;
import java.util.List;

import com.YunPan.dao.file;

public interface  fileDao {
	public void add(file fi);
	public void del(String newname);
	public List<file> findByType(List<String> cc, String username) throws SQLException;
	public List<file> findByPath(String path, String username) throws SQLException;
}
