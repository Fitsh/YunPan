<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String username=request.getParameter("username");
if(username==null)
	username=(String)session.getAttribute("username");
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if(session.getAttribute("username") ==null) 
session.setAttribute("username", username);
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>海量云盘</title>
    
	<!--  <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta charset="utf-8">
	<script src="jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="main.css" />
</head>
<body>
	
	<% String currentPath = "/";
		if(request.getParameter("currentPath") !=null)
		{
			currentPath="/";
		}
	 %>
	  <jsp:forward page="/Files/file_findByPath.action">
	  	<jsp:param value="<%=currentPath %>" name="savePath"/>
	  	<jsp:param value="<%=username%>" name="username"/>
	  </jsp:forward>
	
</body>
</html>

