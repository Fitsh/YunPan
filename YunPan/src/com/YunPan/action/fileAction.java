package com.YunPan.action;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.YunPan.dao.file;
import com.YunPan.dao.fileDao;
import com.YunPan.dao.Impl.fileDaoImpl;
import com.opensymphony.xwork2.ActionContext;

public class fileAction extends superAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		super.setServletRequest(request);
	}
	public String del() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("del");
		HttpServletRequest request = ServletActionContext.getRequest();
		String newName = request.getParameter("newName");
		System.out.println(newName);
		String path=request.getRealPath("/uploads")+newName;
		File fi=new File(path);
		fileDao f = new fileDaoImpl();
		f.del(newName);
		if(fi.exists())
		{
			fi.delete();
		}
		return SUCCESS;
	}
	
	public String findByType() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("findbyType");
		HttpServletRequest request = ServletActionContext.getRequest();
		List<String> pic = new ArrayList<String>();
		pic.add("jpg");pic.add("png");pic.add("jpeg");pic.add("bmp");pic.add("gif");
		List<String> vedio = new ArrayList<String>();
		vedio.add("mp4");vedio.add("avi");vedio.add("rmvb");vedio.add("mkv");vedio.add("wmv");vedio.add("rmvb");vedio.add("rm");
		List<String>  music= new ArrayList<String>();
		music.add("mp3");music.add("wav");
		List<String>  doc= new ArrayList<String>();
		doc.add("doc");doc.add("html");doc.add("pdf");doc.add("docx");doc.add("pptx");doc.add("txt");
		String username = request.getParameter("username");
		System.out.println(username);
		String ContentType = request.getParameter("ContentType");
		System.out.println(ContentType);
		fileDao fDao = new fileDaoImpl();
		List<String> cc =new ArrayList<String>();
		if(ContentType.equals("vedio"))
			cc.addAll(vedio);
		else if(ContentType.equals("music"))
			cc.addAll(music);
		else if(ContentType.equals("pic"))
			cc.addAll(pic);
		else if(ContentType.equals("doc"))
			cc.addAll(doc);
		else{
			cc.addAll(vedio);
			cc.addAll(music);
			cc.addAll(pic);
			cc.addAll(doc);
		}
		System.out.println(cc.size());
		List<file> list = fDao.findByType(cc,username);
		System.out.println(list.size());
		request.setAttribute("list", list);
		return ContentType;
	}

	public String findByPath() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("findBypath");
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getParameter("savePath");
		System.out.println(path);
		String username = request.getParameter("username");
		fileDao fDao = new fileDaoImpl();
		List<file> list= fDao.findByPath(path,username);
		System.out.println(username);
		System.out.println(list.size());
		request.setAttribute("list", list);
		return "success";
	}


	private void add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	

}
