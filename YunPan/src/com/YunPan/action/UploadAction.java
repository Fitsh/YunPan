package com.YunPan.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.YunPan.dao.file;
import com.YunPan.dao.fileDao;
import com.YunPan.dao.Impl.fileDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	private String vpath;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getVpath() {
		return vpath;
	}
	public void setVpath(String vpath) {
		this.vpath = vpath;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		String newName = UUID.randomUUID() 
				+getUploadFileName().substring(getUploadFileName().indexOf("."));
		System.out.println(newName);
		FileOutputStream fos = new FileOutputStream(getSavePath()
				+"\\" + newName);
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		System.out.println(getSavePath());
		while((len = fis.read(buffer)) > 0)
		{
			fos.write(buffer, 0, len);
		}
		System.out.println(getUploadFileName());
		file fi = new file();
		System.out.println("jjj");
		fi.setNewName(newName);
		fi.setOldName(getUploadFileName());
		System.out.println("lei xing : "  +  getUploadContentType());
		fi.setContentType(getUploadContentType());
		fi.setFileType(getUploadFileName().substring(getUploadFileName().indexOf(".")+1));
		fi.setSize((int) getUpload().length());
		fi.setSavePath(getVpath());
		fi.setUsername((String)ServletActionContext.getRequest().getSession().getAttribute("username"));
		fileDao fDao = new fileDaoImpl();
		fDao.add(fi);
		setUploadFileName(newName);
		return SUCCESS;
	}
	
	
}
