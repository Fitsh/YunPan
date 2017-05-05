package com.YunPan.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YunPan.dao.file;
import com.YunPan.dao.fileDao;
import com.YunPan.dao.Impl.fileDaoImpl;

public class FileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("init....");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("fileServlet");
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if("findByType".equals(method)){
			try {
				findByType(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("findByPath".equals(method)){
			try {
				findByPath(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("add".equals(method)){
			add(request,response);
		}else if("del".equals(method)){
			 del(request,response);
		}
	}

	private void del(HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
	}

	private void findByType(HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		List<String> pic = new ArrayList<String>();
		pic.add(".jpg");pic.add(".png");pic.add(".jpeg");
		List<String> vedio = new ArrayList<String>();
		vedio.add(".mp4");
		List<String>  music= new ArrayList<String>();
		music.add(".mp3");
		String username = request.getSession().getAttribute("username").toString();
		String ContentType = request.getParameter("ContentType");
		fileDao fDao = new fileDaoImpl();
		List<String> cc =new ArrayList<String>();
		if(ContentType.equals("vedio"))
			cc.addAll(vedio);
		else if(ContentType.equals("music"))
			cc.addAll(music);
		else if(ContentType.equals("pic"))
			cc.addAll(pic);
		List<file> list = fDao.findByType(cc,username);
		request.setAttribute("list", list);
	}

	private void findByPath(HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		String path = request.getParameter("path");
		String username = request.getParameter("username");
		fileDao fDao = new fileDaoImpl();
		List<file> list= fDao.findByPath(path,username);
		request.setAttribute("list", list);
	}


	private void add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}
	

}
