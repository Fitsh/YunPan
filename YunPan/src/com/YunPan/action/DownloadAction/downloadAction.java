package com.YunPan.action.DownloadAction;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class downloadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String inputPath;
	private String contentType;
	private String oldfileName;
	private String downFileName;
	private InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath)
		throws Exception{
		this.inputPath = inputPath;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getDownFileName() {
		return downFileName;
	}

	public void setDownFileName(String downFileName)
		throws Exception{
		this.downFileName = downFileName;
	}

	public InputStream getTargetFile() throws Exception{
		inputStream = ServletActionContext.getServletContext().getResourceAsStream("/uploads/" + downFileName);
		System.out.println(downFileName);
        if (inputStream == null) {  
            inputStream = new ByteArrayInputStream("Sorry,File not found !"  
                    .getBytes());  
        } 
		return inputStream;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		contentType = ServletActionContext.getServletContext().getMimeType(downFileName);
		return SUCCESS;
	}

	public String getOldfileName() throws UnsupportedEncodingException {
		System.out.println(oldfileName);
		ServletActionContext.getResponse().setHeader("charset","ISO8859-1");  
        String st= new String(oldfileName.getBytes(), "ISO8859-1");  
		
		System.out.println(st);
		return st;
	//	return oldfileName;
	}

	public void setOldfileName(String oldfileName) {
		this.oldfileName = oldfileName;
	}

}