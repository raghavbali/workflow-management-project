<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Roles</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="slideshow.js" type="text/javascript"></script>
<script src="jquery-1.8.3.js" type="text/javascript"></script>
<script src="validation.js"></script>
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
<h3>Add a role: </h3>
	<s:form action="final_assign_role.action" method="post" onSubmit="return user_roles(buttonIndex);">
	<table>
		<s:hidden name="p_id"/>
		<s:hidden name="workflowID" value="%{workflowID}" />
		<s:hidden name="pageName" value="%{pageName}"/>
		<s:set name="pageName" value="%{pageName}"/>
		<s:if test="%{#pageName=='AdminConsole'}">
		<tr><td>Select Workflow</td><td><s:select label="Select Workflow" headerKey="-1"
			headerValue="Select Workflow"
			list="wfList"
			name="selected_wf"/></td></tr>
		</s:if>
		<s:elseif test="%{#pageName=='EditorConsole'}">
		<tr><td>Select Workflow</td><td><s:select label="Select Workflow" headerKey="-1"
			headerValue="Select Workflow"
			list="wfList"
			name="selected_wf" /></td></tr>
		</s:elseif>
		<tr><td>Select Role</td><td><s:select label="Select Role" headerKey="-1"
			headerValue="Select Role"
			list="roleList"
			name="selected_role"/></td></tr>
		<tr><td>User Name</td><td><s:textfield name="username" id="username" placeholder="username" label="User Name" value="%{AssignRole.username}" size="30" /></td></tr>
		<tr><td>Password</td><td><s:textfield name="password" id="password" placeholder="password" label="Password" value="%{AssignRole.username}" size="30" /></td></tr>
		<s:actionerror />
		<s:actionmessage/>
		<tr><td><s:submit name = "commandButton" id="mysubmit" value="Add role" align="center" onclick="buttonIndex=1" /></td>
		<td><div id="loginmandatory" style="color:red"></div>
		<s:if test="%{#session['role']=='admin'}">
		<s:submit name = "button1" value = "Back" align="center" action="editUserAdminConsole"/>
		</s:if>
		<s:elseif test="%{#session['role']=='editor'}">
		<s:submit name = "button1" value = "Back" align="center" action="assignRoleEditorConsole"/>
		</s:elseif>
		<div id="loginmandatory" style="color:red"></div>
		</td>
		</tr>
		
	</table>
	</s:form>
	</div>
	</div>
</body>
</html>