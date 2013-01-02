<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Edtior</title>
</head>
<body>
	<h2>successful login!</h2>
	<s:actionmessage/>
	<s:actionerror/>
	<s:form action="" method="">
	<s:hidden name="workflowID" id="workflowID" value="%{workflowID}" />
	<s:submit name="button" value="Stage Assignment"
			action="assignStageEditorConsole" align="left" />
		<s:submit name="button" value="Create Item"
			action="createItemEditorConsole" align="left" />
		<s:submit name="button" value="Edit Item" action="editItemEditorConsole"
			align="left" />
		<s:submit name="button" value="Assign Role" action="assignRoleEditorConsole"
			align="left" />
		<s:submit name="button" value="Edit Profile" action="editProfileEditorConsole"
			align="left" />
	</s:form>
</body>
</html>