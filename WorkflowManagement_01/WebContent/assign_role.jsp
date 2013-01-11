<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Assign Role</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="slideshow.js" type="text/javascript"></script>
<script src="jquery-1.8.3.js" type="text/javascript"></script>

</head>
<body>
<%@include file="master.html" %>
<div id="assign_role">
<h3>Assign Role</h3>
<s:form>
<s:hidden name="pageName" value="%{pageName}"/>
<s:hidden name="workflowID" value="%{workflowID}" />
	<table>
	<tr>
	    <th><h3>P_ID</h3></th>
	    <th><h3>Prefix</h3></th>
	    <th><h3>First Name</h3></th>
	    <th><h3>Last Name</h3></th>
	    <th><h3>Edit Profile</h3></th>
	    <th><h3>Assign Role</h3></th>
	</tr>
	<s:iterator value = "usrlist">
	<tr>
		<td><s:property value="p_id"/></td>
		<td><s:property value="prefix"/></td>
		<td><s:property value="fname"/></td>
		<td><s:property value="lname"/></td>
		<td><a href="edit_user_basic?p_id=<s:property value="p_id"/>&workflowID=<s:property value="workflowID"/>">Edit</a></td>
		<td><a href="continue_role_assign?p_id=<s:property value="p_id"/>&pageName=<s:property value="pageName"/>&workflowID=<s:property value="workflowID"/>">User roles</a></td>

	</tr>
	</s:iterator>
	<tr><td>
	<s:if test="%{#session['role']=='admin'}">
	<s:submit name = "button1" value = "Back" align="center" action="backToAdminConsole"/>
	</s:if>
	<s:elseif test="%{#session['role']=='editor'}">
	<s:submit name = "button1" value = "Back" align="center" action="doneEditorConsole"/>
	</s:elseif>
	</td>
	<td></td><td></td><td></td><td></td><td></td>
	</tr>
	</table>
	</s:form>
	</div>
	</div>
</body>
</html>