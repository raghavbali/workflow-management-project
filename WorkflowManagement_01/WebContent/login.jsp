<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
 <meta http-equiv="Cache-Control" content="no-cache">
 <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<title>WFMS: Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="slideshow.js" type="text/javascript"></script>
<script src="jquery-1.8.3.js" type="text/javascript"></script>
<script src="validation.js"></script>
<script language="JavaScript">
var x=window.history.length;
if (window.history[x]!=window.location)
{
    window.history.forward();
}
</script> 
</head>
<body>
<%@include file="master.html" %>
<div id="loginjsp_login">
<s:actionerror />
<s:form action="login.action" method = "post" onSubmit="return login_check();">
	<br><br>&nbsp&nbspUsername:<s:textfield placeholder="username" name = "username" id="username" label="Username" size = "20" value="admin1" />
	<br><br>&nbsp&nbspPassword:<s:password placeholder="password" name = "password" label="Password" id="password" size="20" value="pass1"/>	
	<br><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp	
	<s:submit name = "button1" id="buton1" method = "execute" value = "Login" align="center" />
	&nbsp; &nbsp &nbsp &nbsp &nbsp<div id="loginmandatory" style="color:red"></div>
</s:form>
</div>

<div id="loginjsp_aboutus" style="text-align: justify;	"><h4 style="text-align: center;"><u>Namaskar</u></h4><br><span style="color:rgb(50,0,250)">Welcome to <b><i>FLUX</i></b>.<br/>
We are a team of dedicated professionals to provide your team with state of the art yet simple and fluid Workflow Management System.<br/><br/>
<b><i>FLUX</i></b> is not simply yet another off the shelf Workflow Management System. Its designed inside out with Team focus at its core.<br/><b><i>FLUX</i></b> is here to help you achieve MORE.<br/>Make us part of your success and get <b><i>FLUX</i>ed!</b>
</span></div>
</body>
</html>