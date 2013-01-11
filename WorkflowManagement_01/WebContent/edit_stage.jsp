<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Workflow Details</title>
<script src="slideshow.js" type="text/javascript"></script>
<script src="jquery-1.8.3.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="validation.js"></script>
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
	<s:form action="" method="post" onSubmit="return edit_stage(buttonIndex);">

	<s:iterator value="objListWfDetails" >
		<tr><td>Stage Name</td><td><s:textfield name="stageName" label="Stage Name" id="stageName"  size="30" /></td></tr>
		<tr><td>Stage Description</td><td><s:textfield name="stageDescription" label="Stage Description" id="stageDescription"
			size="50" /></td></tr>
		<tr><td>Stage SLA(in hrs)</td><td><s:textfield name="stageSLA" label="Stage SLA(in hrs)" id="stageSLA"
			size="5" /></td></tr>
		<tr><td><s:submit name="button" value="Update Stage"
			action="updateNowStage" align="center" onclick="buttonIndex=1;"	 /></td>
		<td>
		<s:submit name="button" value="Delete Stage"
			action="deleteNowStage" align="center" onclick="buttonIndex=1;"/>
		<s:submit name="button"  value="Back"
			action="doneStage" align="center" onclick="buttonIndex=2;" />
			<div id="loginmandatory" style="color:red"></div>
			</td>			
		</tr>
			</s:iterator>	
	</s:form>
	</table>
	</div>
</body>
</html>