<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Create Workflow</title>
</head>
<body>
	<h2>Admin Console</h2>
	<s:actionerror />
	<s:form action="create_wf.action" method="post">
		<s:textfield name="wf_name" label="Workflow Name" size="50" />
		<s:textfield name="wf_description" label="Workflow Description"
			size="100" />
		<s:select label="Select a domain" headerKey="-1"
			headerValue="Domains"
			list="domainList"
			name="wf_domain"
			value="%{workflowDomain}" />
		<s:submit name="wf_create" method="execute" value="Next"
			align="center" />
	</s:form>
</body>
</html>