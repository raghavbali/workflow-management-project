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

<script language="JavaScript">
	var x = window.history.length;
	if (window.history[x] != window.location) {
		window.history.forward();
	}
</script>

<title>Welcome admin</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<%@include file="master.html" %>
	    <div id="buttons_menu">
	
	<s:actionmessage />
	<s:actionerror />
	<s:if test="%{#session['logged-in']=='true'}">
		<s:form action="" method="">
					<br> &nbsp &nbsp &nbsp&nbsp&nbsp &nbsp
			<s:if test="%{#session.tableSuffix=='_00000000000000'}">
		
				<s:submit name="button" value="Create Workflow"
					action="createWfAdminConsole" align="left" />
			</s:if>
			<br/><br>
			&nbsp &nbsp &nbsp&nbsp&nbsp &nbsp
			<s:submit name="button" value="Edit Workflow"
				action="editWorkflowAdminConsole" align="left" />
				<br><br>
				&nbsp &nbsp &nbsp&nbsp&nbsp &nbsp
			<s:submit name="button" value="Add User"
				action="createUserAdminConsole" align="left" />
				<br><br>
				&nbsp &nbsp &nbsp&nbsp&nbsp &nbsp
			<s:submit name="button" value="Edit User"
				action="editUserAdminConsole" align="left" />
				<br><br>
				&nbsp &nbsp &nbsp&nbsp&nbsp &nbsp
			<s:submit name="button" value="Manual Override"
				action="manualAdminConsole" align="left" /><br>
				
		</s:form>
	</s:if>
	<s:else>
    	Trespassers will be shot. Survivors will be shot again!!!
    	<a href="login.jsp">Login</a>
	</s:else>
	
	 </div>
	 <div id="login_admin_about_menu">
	 <h2 style="text-align: center;"><br>&nbsp &nbsp About Menu</h2>
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