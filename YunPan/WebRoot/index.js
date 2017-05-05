/**
 * 
 */
var i = 0;
function changeBG()
{
	 var s="url(Images/bg" + i + '.jpg) no-repeat center center;';
	document.getElementById("bg").style.background=s;
	i=i+1;
	i=i%3;
	
}
//window.setInterval("changeBG()", 2000);
function check(){
	var ps1=document.getElementById("login-password1").value;
	var ps2=document.getElementById("login-password2").value;
	if(ps1 != ps2)
		alert("输入的两次密码不一致！");
}