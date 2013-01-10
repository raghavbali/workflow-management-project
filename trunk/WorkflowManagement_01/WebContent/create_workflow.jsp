<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Create Workflow</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="slideshow.js" type="text/javascript"></script>
<script src="jquery-1.8.3.js" type="text/javascript"></script>

</head>
<body>
<%@include file="master.html" %>
<br><br><br><br><br><br><br><br>
	<div id="admin_console">
	<h2><br>&nbsp&nbspCreate Workflow</h2>
	<s:actionerror />
	<s:form  cssClass="create_workflow" action="create_wf.action" method="post">
		<br>Workflow Name:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <s:textfield  name="wf_name"  size="50" theme="simple" />
		<br><br>Workflow Description:&nbsp<s:textfield name="wf_description" size="50" theme="simple"  />
		<br><br><br>
		Select a domain: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<s:select  headerKey="1"
			list="domainList"
			name="wf_domain"
			value="%{workflowDomain}" theme="simple" />
			<br><br><s:submit name="wf_create" method="execute" value="Save"
			align="left" theme="simple" />			
		<s:submit name="button" value="Back"
				action="backToAdminConsole" align="center" theme="simple" />
	</s:form>
	</div>
	</div>
</body>
</html>