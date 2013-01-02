<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome admin</title>
</head>
<body>
	<h2>successful login!</h2>
	<s:actionmessage/>
	<s:form action="" method="">
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
</body>
</html>