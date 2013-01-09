<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Workflow Details</title>
</head>
<body>
<%@include file="master.html" %>
<div id="edit_workflow">
<table>
	<h2>Edit Details</h2>
	<tr><td><s:actionerror /></td>
	<td><s:actionmessage/></td></tr>
	<tr><td>WorkflowID:</td><td><s:property value="workflowID" /></td></tr>
	<s:hidden name="workflowID" value="%{workflowID}"/>
	<s:form action="" method="post">

	<s:iterator value="objListWfDetails" >
		<tr><td>Stage Name</td><td><s:textfield name="stageName" label="Stage Name"  size="30" /></td></tr>
		<tr><td>Stage Description</td><td><s:textfield name="stageDescription" label="Stage Description"
			size="50" /></td></tr>
		<tr><td>Stage SLA(in hrs)</td><td><s:textfield name="stageSLA" label="Stage SLA(in hrs)"
			size="5" /></td></tr>
		<tr><td>Stage Sequence</td><td><s:textfield name="stageSequenceNo" label="Stage Sequence Number"
			 size="5" /></td></tr>
		<tr><td><s:submit name="button" value="Update Stage"
			action="updateNowStage" align="center" /></td>
		<td><s:submit name="button"  value="Back"
			action="doneStage" align="center" /></td></tr>
			</s:iterator>	
	</s:form>
	</table>
	</div>
</body>
</html>