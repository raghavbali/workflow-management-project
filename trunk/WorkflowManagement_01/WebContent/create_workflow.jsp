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
<script src="validation.js" type="text/javascript"></script>
</head>
<body>
<%@include file="master.html" %>
<br><br><br><br><br><br><br><br>
	<div id="admin_console">
	<h2><br>&nbsp&nbspCreate Workflow</h2>
	<s:actionerror />
	<table>
	<s:form  cssClass="create_workflow" onSubmit="return create_workflow(buttonIndex);" action="create_wf.action" method="post">
		<tr><td>Workflow Name:</td><td><s:textfield  name="wf_name" id="wf_name" size="50" theme="simple" /></td></tr>
		<tr><td>Workflow Description:</td><td><s:textfield name="wf_description" id="wf_description" size="50" theme="simple"  /></td></tr>		
		<tr><td>Select a domain: </td><td><s:select  headerKey="1"
			list="domainList"
			name="wf_domain"
			value="%{workflowDomain}" theme="simple" /></td></tr>
			<tr><td><s:submit name="wf_create" method="execute" value="Save"
			align="left" theme="simple" onclick="buttonIndex=1" /></td>			
		    <td><s:submit name="button" value="Back" onclick="buttonIndex=2;"
				action="backToAdminConsole" align="center" theme="simple" />
				&nbsp &nbsp &nbsp <div id="loginmandatory" style="color:red;"></div>
				</td>				
				</tr>
	</s:form>
	</table>
	</div>
	</div>
</body>
</html>