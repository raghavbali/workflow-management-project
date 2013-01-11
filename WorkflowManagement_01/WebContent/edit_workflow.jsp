<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Select Workflow</title>
<script src="slideshow.js" type="text/javascript"></script>
<script src="jquery-1.8.3.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="validation.js" type="text/javascript"></script>
</head>
<body>
<%@include file="master.html" %>
<div id="edit_workflow">
	<h2>Edit Workflow</h2>
	<table id="line" align="left">
	
	<tr><th><s:actionerror /></th>
	<th><s:actionmessage /></th>
	</tr>
	<s:form action="edit_wf.action" method="post" onSubmit="return edit_workflow(buttonIndex);">
		<tr><td>Workflow ID</td><td><s:textfield name="workflowID" label="Workflow ID" value="%{workflowID}" readonly="true" required="true"/></td></tr>
		<tr><td>Workflow Name</td><td><s:textfield name="workflowName" id="workflowName" label="Workflow Name"
			value="%{workflowName}" onfocus="true" required="true"/></td></tr>
		<tr><td>Workflow Description</td><td><s:textfield name="workflowDescription" id="workflowDescription" label="Workflow Description"
			value="%{workflowDescription}" required="true"/></td></tr>
		<tr><td>WorkFlow Domain</td><td><s:select label="Select a domain" 
			list="domainList"
			name="workflowDomain"
			value="%{workflowDomain}" required="true" /></td></tr>
			<s:set name= "freezeVal" value="freeze"/>
		<tr><td>Freeze</td><td><s:if test='%{#freezeVal=="N"}'><s:select label="Freeze"
			list="freezeList"
			name="freeze"
			value="%{freeze}" required="true"/><s:submit name="button" value="Delete Workflow" align="center" method="deleteMaster"/>
		</s:if>
		<s:else>
		<s:property value="freeze"/>
		<s:hidden name="freeze" value="%{freeze}"/>
		</s:else></td></tr>
		<br><tr><td><s:submit name="button" value="Save Changes" align="center" method="saveChanges" onclick="buttonIndex=1;" /></td>
		<td><s:submit name="button" value="Back" method="back" align="left" onclick="buttonIndex=2;" />
		<div id="loginmandatory" style="color:red"></div>
		</td></tr>
	</s:form>
	</table>
	</div>
	</div>
</body>
</html>