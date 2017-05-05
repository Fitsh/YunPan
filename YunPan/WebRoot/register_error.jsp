<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!--  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

-->
<!doctype html>
<html>
  <head>
    <base href="<%=basePath%>">
    
   <!--  <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  
  <title> 海量云盘 </title>
  <link rel="stylesheet" type="text/css" href = "index.css">
  <script src="index.js"></script>
</head>
<body>
<div class="login_container" >
  <div class="ibg-bg index-bg" id="bg" style="background: url(Images/bg1.jpg) no-repeat center center;transform: matrix(1,0,0,1,0,0); transition:all 500ms liner;">
	</div>
  <div class="header">
  	 <div class="logo">
	 	   <a class="yun-logo" href="" target="_black" 
		   title="海量云盘">海量云盘</a>
	   </div>
     <div class="login-title">
	    	<a class="login" href="javascript:login(10000)">用户登陆及注册</a>
	   </div>
  </div>
	<div style="clear:both">
	</div>
	<div class="showWin showLogin" id="login" >
		<div class="PHead">
	    <div class="close" style="float: right">
				<a href="">
		  		<img src="Images/12.png" class="close-logo" alt="close"/>
				</a>
			</div>
	  	<div class="P_login ">
	  		<div class="P_login1 IB" >登陆</div>
		  	<div class="P_L_register IB" >
					<a href="javascript:register(10000)">
		  			<img src="Images/right.png" alt="register">
						注册
					</a>
		 	  </div>
	 	 	</div>
		</div>
		<div class="B1">
	  	<form action="<%= path%>/Users/User_login.action" method="post">
  	 		 <a style="display:block">
	 				 <input name="username" class="login_Input" id="username" 
					 maxlength="20" type="text"	placeholder="请输入帐号" required>
	  		</a>
	  		<a style="display:block">
	 			 <input name="password" class="login_Input" id="login-password" type="password" 
	 		 		 placeholder="密码" required>
	  		 <input class="login_Input" id="password" 
				 type="hidden"  style="display:block">
	  		</a>
				<div class="RM_1">
					<input class="remember" type="radio">记住我
				</div>
				<div>
				</div>
	  		<button class="submit" type="submit" >登陆</button> 
	  		<button class="reset" type="reset"> 重置</button>
	  	</form>
	 	</div>
	</div>
	<div class="showWin showRegister" id="register" >
		<div class="PHead">
	    <div class="close" style="float: right" >
				<a href="">
		  		<img src="Images/12.png" class="close-logo" alt="close"/>
				</a>
			</div>
	  	<div class="P_register ">
	  		<div class="P_register1 IB" >注册</div>
		  	<div class="P_L_Login IB" >
					<a href="javascript:login(10000)">
		  			<img src="Images/right.png" alt="">
						登陆
					</a>
		 	  </div>
	 	 	</div>
		</div>
		<div class="B1">
	  	<form action="<%=path %>/Users/User_register" method="post">
  	 		 <a style="display:block">
	 				 <input name="username" class="login_Input" id="username" 
					 maxlength="20"  type="text"	placeholder="请输入帐号" required>
	  		</a>
	  		<a style="display:block">
	 			 <input class="login_Input" id="login-password1" type="password" 
	 		 		 placeholder="请输入密码" required>
				</a>
				<a style="display: block">
	 			 <input name="password" class="login_Input" id="login-password2" type="password" 
	 		 		 placeholder="请输入确认密码" onBlur="javascript:check()" required>
	  		 
	  		</a>
	  		<div id="message">
	  		</div>
	  		<button class="submit" type="submit" >注册</button> 
	  		<button class="reset" type="reset"> 重置</button>
	  	</form>
	 	</div>
	</div>

</div>
<div class="footer">
  <span>
  <a href="mailto:  @qq.com">Connect with us</a>
   <br/>
    
     
Server Time: <span id="time"></span> 
  </span>
</div>
<script>
 function GetTime() {
    var time = new Date();
    var year = time.getFullYear();
    var month = time.getMonth() + 1;        // 月份从0开始
    var day = time.getDate();               // 注意是getDate()
    var hour = time.getHours();
    var minute = time.getMinutes();
    var sec = time.getSeconds();
    var timestring;
    if (minute < 10) {
    timestring
    = year + "-" + month + "-" + day + " " + hour + ":0" + minute + ":" + sec;
    }
    else {
    timestring
    = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + sec;
    }
    // div没有value属性
    document.getElementById("time").innerHTML = timestring;
    }
    window.setInterval("GetTime()", 1000);
	alert("账号已被使用过~~~");
	register(10000);
	function login( a)
	{
		document.getElementsByClassName("showRegister")[0].style.zIndex=-100;
		document.getElementsByClassName("showLogin")[0].style.zIndex=a;
	}
	function register( a)
	{
		document.getElementsByClassName("showLogin")[0].style.zIndex=-100;
		document.getElementsByClassName("showRegister")[0].style.zIndex=a;
	}
	function close()
	{
		register(-100);
	}
	window.setInterval("changeBG()", 2000);
</script>
</body>
</html>
