<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

<script language="JavaScript">
	var x = window.history.length;
	if (window.history[x] != window.location) {
		window.history.forward();
	}
</script>
<title>Welcome Editor</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@include file="master.html" %>
<div id="menu">
	<ul>	
		<li><a href="#">Home</a></li>
		<li><a href="#">About US</a></li>
		<li><a href="logoutAdminConsole.action">Logout</a></li>
	</ul>
</div>
	
	<s:actionmessage/>
	<s:actionerror/>
	<div id="buttons_menu">
	<s:if test="%{#session['logged-in']=='true'}">
	<s:form action="" method="">
	
	<s:hidden name="workflowID" id="workflowID" value="%{workflowID}" />
	<br><br><br>&nbsp &nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	<s:submit name="button" value="Stage Assignment" action="assignStageEditorConsole"
			align="left" />
	<br><br><br>&nbsp &nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp		
		<s:submit name="button" value="Create Item" action="createItemEditorConsole"
			align="left" />
	<br><br><br>&nbsp &nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp		
		<s:submit name="button" value="Edit Item" action="editItemsEditorConsole"
			align="left" />
	<br><br><br>&nbsp &nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp		
		<s:submit name="button" value="Assign Role" action="assignRoleEditorConsole"
			align="left" />
	<br><br><br>&nbsp &nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp		
		<s:submit name="button" value="Edit Profile" action="editProfileEditorConsole"
			align="left" />
			
	</s:form>
	</s:if>
	<s:else>
    	Trespassers will be shot. Survivors will be shot again!!!
    	<a href="login.jsp">Login</a>
	</s:else>
	</div>
	
	<div style="border-radius:15px;position: absolute;border: thin solid black; top:40%;left:30%;width:60%;height:55%;">
	 <h2 style="text-align: center;"><br>&nbsp &nbsp About Menu</h2><br>
	 <ul>
	 	<li>Create Workflow : Content to be written by Mr Raghav hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh hjh
	 	</li>
	 	<li>Edit Workflow : Content to be written by Mr Raghav hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh hjh
	 	</li>
	 	<li>Add User : Content to be written by Mr Raghav hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh hjh
	 	</li>
	 	<li>Edit User : Content to be written by Mr Raghav hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh hjh
	 	</li>
	 	<li>Manual Override : Content to be written by Mr Raghav hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh hjh
	 	</li>
	 </ul>	 
	 </div>
	
	</div>
</body>
</html>