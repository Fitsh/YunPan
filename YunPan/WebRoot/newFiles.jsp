<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<div class="list" id="list-all"style="overflow-y:auto; height:85%">
		<table border = "1">
		<c:forEach items = "${requestScope.list }" var="file">
			<tr>
				<td>
					<input type="checkbox"/>
					<img src="/Images/file.jpg">
					<input value="${file.newName}" type="hidden"></input>
					<c:out value="${file.oldName }"></c:out>
				</td>
				<td>${file.size}
				</td>
				<td>${file.fileType }
				</td>
			</tr>
		</c:forEach>
		
		</table>
		</div>
</body>
</html>

