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
var x=window.history.length;
if (window.history[x]!=window.location)
{
    window.history.forward();
}
</script> 

<title>Welcome admin</title>
</head>
<body>
	<s:actionmessage/>
	<s:actionerror/>
	<s:if test="%{#session['logged-in']=='true'}">
	<s:form action="" method="">
		<a	href="logoutAdminConsole.action">Logout</a>
		<s:submit name="button" value="Create Workflow"
			action="createWfAdminConsole" align="left" />
		<s:submit name="button" value="Edit Workflow" action="editWorkflowAdminConsole"
			align="left" />
		<s:submit name="button" value="Add User" action="createUserAdminConsole"
			align="left" />
		<s:submit name="button" value="Edit User" action="editUserAdminConsole"
			align="left" />
		<s:submit name="button" value="Manual Override" action="manualAdminConsole"
			align="left" />
	</s:form>
	</s:if>
	<s:else>
    	Trespassers will be shot. Survivors will be shot again!!!
    	<a	href="login.jsp">Login</a>
	</s:else>
</body>
</html>