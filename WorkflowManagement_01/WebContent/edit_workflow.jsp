<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Select Workflow</title>
</head>
<body>
	<h2>Edit Workflow</h2>
	<s:actionerror />
	<s:actionmessage />
	<s:form action="edit_wf.action" method="post">
		<s:textfield name="workflowID" label="Workflow ID" value="%{workflowID}" readonly="true"/>
		<s:textfield name="workflowName" label="Workflow Name"
			value="%{workflowName}" onfocus="true"/>
		<s:textfield name="workflowDescription" label="Workflow Description"
			value="%{workflowDescription}" />
		<s:select label="Select a domain" headerKey="-1"
			headerValue="Domains"
			list="domainList"
			name="workflowDomain"
			value="%{workflowDomain}" />
		<s:submit name="button" value="Save Changes" align="center" method="saveChanges"/>
	</s:form>
</body>
</html>