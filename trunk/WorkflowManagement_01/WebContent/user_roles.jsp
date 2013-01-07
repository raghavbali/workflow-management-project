<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Roles</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@include file="master.html" %>
<div id="user_roles">
<h3> User details for User with p_id = ${p_id} </h3>
<s:actionerror />
<s:hidden name="pageName" value="%{pageName}"/>
<s:hidden name="workflowID" />
<table>
	<tr>
	    <th><h3>User_ID</h3></th>
	    <th><h3>User Name</h3></th>
	    <th><h3>Password</h3></th>
	    <th><h3>P_ID</h3></th>
	    <th><h3>W_ID</h3></th>
	    <th><h3>Role</h3></th>
	    <th><h3>Active?</h3></th>
	</tr>
	<s:iterator value = "usrlist">
	<tr>
		<td><s:property value="user_id"/></td>
		<td><s:property value="username"/></td>
		<td><s:property value="password"/></td>
		<td><s:property value="p_id"/></td>
		<td><s:property value="w_id"/></td>
		<td><s:property value="role"/></td>
		<td><s:property value="active_flag"/></td>
		<td><a href="edit_user_role?user_id=<s:property value="user_id"/>&pageName=<s:property value="pageName"/>&workflowID=<s:property value="workflowID"/>">Edit</a></td>
	</tr>
	</s:iterator>
</table>
<h2>Add a role: </h2>
	<s:form action="final_assign_role.action" method="post">
		<s:hidden name="p_id"/>
		<s:hidden name="workflowID" value="%{workflowID}" />
		<s:hidden name="pageName" value="%{pageName}"/>
		<s:set name="pageName" value="%{pageName}"/>
		<s:if test="%{#pageName=='AdminConsole'}">
		<s:select label="Select Workflow" headerKey="-1"
			headerValue="Select Workflow"
			list="wfList"
			name="selected_wf"/>
		</s:if>
		<s:elseif test="%{#pageName=='EditorConsole'}">
		<s:select label="Select Workflow" headerKey="-1"
			headerValue="Select Workflow"
			list="wfList"
			name="selected_wf" />
		</s:elseif>
		<s:select label="Select Role" headerKey="-1"
			headerValue="Select Role"
			list="roleList"
			name="selected_role"/>
		<s:textfield name="username" label="User Name" value="%{AssignRole.username}" size="30" />
		<s:textfield name="password" label="Password" value="%{AssignRole.username}" size="30" />
		<s:actionerror />
		<s:actionmessage/>
		<s:submit name = "commandButton" id="mysubmit" value="Add role" align="center" />

	</s:form>
	</div>
	</div>
</body>
</html>