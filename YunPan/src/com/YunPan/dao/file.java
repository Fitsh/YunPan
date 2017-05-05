package com.YunPan.dao;

public class file {
	private String newName;
	private String oldName;
	private String fileType;
	private int size;
	private String savePath;
	private String username;
	private String contentType;
	public file(){
		
	}
	
	public file(String newName, String oldName, String fileType, int size,
			String savePath, String username, String contentType) {
		super();
		this.newName = newName;
		this.oldName = oldName;
		this.fileType = fileType;
		this.size = size;
		this.savePath = savePath;
		this.username = username;
		this.contentType = contentType;
	}

	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int l) {
		this.size = l;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
}
