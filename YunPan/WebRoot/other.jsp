<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username=request.getParameter("username");
if(username==null)
	username=(String)session.getAttribute("username");
if(username !=null) 
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
	<div class="header">
		<div class="FL">
			<a href="">
				<span>
				<img id="logo" src="Images/logo.png" alt="logo">
				海量云盘
				</span>
				</a>
		</div>
		<div class="FR">
			<span >
				<span>
					<img id="touxiang" src="Images/touxiang.jpg" alt="logo">
				</span>
				<span>
					<%= request.getParameter("username") %>
				</span>
				<span>
				<a href="index.jsp" target="_top">退出</a>
				</span>
			</span>
		</div>
	</div>
	<%! String h; %>
	<div class="frame_aside">
		<div> 
			
			<% h = path+"/Files/file_findByPath.action?savePath=/&username="
				+request.getParameter("username"); %>
			
			<a href="main.jsp">
			全部文件
			</a>
		</div>
		<div>
			<%-- h = path+"/Files/file_findByType.action?ContentType=doc&username="
				+request.getParameter("username"); --%>
			<a href="main.jsp">
			文档
			</a>
		</div>
		<div>
			<% h = path+"/Files/file_findByType.action?ContentType=pic&username="
				+request.getParameter("username"); %>
			<a href=<%=h %>>
			图片
			</a>
		</div>
		<div>
			<% h = path+"/Files/file_findByType.action?ContentType=vedio&username="
				+request.getParameter("username"); %>
			<a href=<%=h %>>
			视频
			</a>
		</div>
		<div>
			<% h = path+"/Files/file_findByType.action?ContentType=music&username="
				+request.getParameter("username"); %>
			<a href=<%=h %>>
			音乐
			</a>
		</div>
		<div>
			<% h = path+"/Files/file_findByType.action?ContentType=other&username="
				+request.getParameter("username"); %>
			<a href=<%=h %>>
			其它
			</a>
		</div>
	</div>
	<div class="frame-main">
		<div style="height:7%; padding-top:2%">
			<span class="list_main" >文件名
			</span>
			<span class="list_span">--
			</span>
			<span class="list_span">文件大小
			</span>
			<span class="list_span">文件类型
			</span>
		</div>
		<div class="list" id="list-all"style="overflow-y:auto; height:80%;width:100%;display:block">
		<c:forEach items = "${requestScope.list }" var="file">
			<div class="list_m" style="width:100%">
			 	<span class="list_main" style="width:30%">
					<input type="checkbox" onclick="javascript: addlist(this)" />
					<img class="sign" src="Images/other.jpg"/>
					<input value="${file.newName}" type="hidden"></input>
					<input value="${file.contentType }" type="hidden"/>
					<c:out value="${file.oldName }"></c:out>
				</span>
				<span class="list_span" >
				
				<a href="download?downFileName=${file.newName}&oldfileName=${file.oldName}">下载
				</a>
				<a href="/YunPan/Files/file_del.action?newName=${file.newName }">删除</a>
				</span>
				<span class="list_span">${file.size}B
				</span>
				<span class="list_span">${file.fileType }
				</span>
			</div>
		</c:forEach>
		</div>	
	</div>
	<script>
	
	$("#upload1").click(function(){
		$("#upload").toggle();
	});
	</script>
</body>
</html>

