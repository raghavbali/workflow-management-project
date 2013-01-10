<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Select Workflow</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@include file="master.html" %>
<div id="edit_workflow">
	<h2>Edit Workflow</h2>
	<table id="line" align="left">
	
	<tr><th><s:actionerror /></th>
	<th><s:actionmessage /></th>
	</tr>
	<s:form action="edit_wf.action" method="post">
		<tr><td></td><td></td><td>Workflow ID</td><td><s:textfield name="workflowID" label="Workflow ID" value="%{workflowID}" readonly="true"/></td></tr>
		<tr><td></td><td></td><td>Workflow Name</td><td><s:textfield name="workflowName" label="Workflow Name"
			value="%{workflowName}" onfocus="true"/></td></tr>
		<tr><td></td><td></td><td>Workflow Description</td><td><s:textfield name="workflowDescription" label="Workflow Description"
			value="%{workflowDescription}" /></td></tr>
		<tr><td></td><td></td><td>WorkFlow Domain</td><td><s:select label="Select a domain" headerKey="1"
			list="domainList"
			name="workflowDomain"
			value="%{workflowDomain}" /></td></tr>
			<s:set name= "freezeVal" value="freeze"/>
		<tr><td></td><td></td><td>Freeze</td><td><s:if test='%{#freezeVal=="N"}'><s:select label="Freeze"
			list="freezeList"
			name="freeze"
			value="%{freeze}" /><s:submit name="button" value="Delete Workflow" align="center" method="deleteMaster"/>
		</s:if>
		<s:else>
		<s:property value="freeze"/>
		</s:else></td></tr>
		<br><tr><td></td><td><s:submit name="button" value="Save Changes" align="center" method="saveChanges"/></td>
		<td><s:submit name="button" value="Back" method="back" align="left" /></td></tr>
		</table>
	</s:form>
	</div>
	</div>
</body>
</html>