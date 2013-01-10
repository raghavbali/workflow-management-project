<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Workflow Details</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="slideshow.js" type="text/javascript"></script>
<script src="jquery-1.8.3.js" type="text/javascript"></script>

</head>
<body>
<%@include file="master.html" %>
	<div id="add_stage">
	<h2>Add Details</h2>
	<s:actionerror />
	<s:actionmessage/>
	<table>
	<tr><td>WorkflowID:</td><td><s:property value="workflowID" /></td></tr>
	<s:form action="" method="post">
	<s:hidden name="workflowID" value="%{workflowID}"/>
		<tr><td>Stage Name:</td><td><s:textfield name="stageName" label="Stage Name" size="30" /></td></tr>
		<tr><td>Stage Description:</td><td><s:textfield name="stageDescription" label="Stage Description"
			size="50" /></td></tr>
		<tr><td>Stage SLA(in Hrs):</td><td><s:textfield name="stageSLA" label="Stage SLA(in hrs)"
			size="5" /></td></tr>
		<tr><td>Stage Sequence No:</td><td><s:textfield name="stageSequenceNo" label="Stage Sequence Number"
			 size="5" /><td></tr>
		<tr><td><s:submit name="button" value="Add Stage"
			action="addNowStage" align="center" /></td>
		<td><s:submit name="button"  value="Back"
			action="addLaterStage" align="center" /></td></tr>	
	</s:form>
	</table>
	</div>
	</div>
</body>
</html>