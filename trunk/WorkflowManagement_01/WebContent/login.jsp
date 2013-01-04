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
<script language="JavaScript">
var x=window.history.length;
if (window.history[x]!=window.location)
{
    window.history.forward();
}
</script> 
</head>
<body>
<div id="loginjsp_login">
<s:actionerror />
<s:form action="login.action" method = "post">
	<s:textfield name = "username" label="Username" size = "20" value="admin1" />
	<s:password name = "password" label="Password" size="20" value="pass1"/>
	<s:submit name = "button1" method = "execute" value = "Login" align="center" />
</s:form>
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <a href="#" style="text-decoration:  none;">sign up!!</a>
</div>
<div id="loginjsp_box">
<div id="loginjsp_heading">
	WORKFLOW MANAGEMENT
</div>
	<div id="loginjsp_menu">
	<ul>	
		<li><a href="#">Home</a></li>
		<li><a href="#">About US</a></li>
	</ul>
	</div>
</div>
<div id="loginjsp_aboutus" style="text-align: justify;	"><h4 style="text-align: center;"><u>ABOUT THE SITE</u></h4><br><span style="color:rgb(50,0,250)">Workflow management is supposed to track the whereabouts about project that how it is done and many other things. Remaining has to be written by Raghav This project was started sinec 
yesterday. We had everything in the class. Please do not read whatever i wrote above</span></div>
</body>

</html>