<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div id="loginjsp_login">
<s:actionerror />
<s:form action="login.action" method = "post">
	<s:textfield name = "username" label="Username" size = "20" value="admin1" />
	<s:password name = "password" label="Password" size="20" value="pass1"/>
	<s:submit name = "button1" method = "execute" value = "Login" align="center" />
</s:form>
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <a href="#" style="text-decoration:  none;">sign up!!</a>
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
<div id="loginjsp_aboutus" style="text-align: justify;	"><h4 style="text-align: center;">ABOUT THE SITE</h4><br>Workflow management is supposed to track the whereabouts about project that how it is done and many other things. Remaining has to be written by Raghav This project was started sinec 
yesterday. We had everything in the class. Please donot read whatever i wrote above</div>
</body>

</html>