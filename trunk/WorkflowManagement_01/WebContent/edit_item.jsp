<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Add Item</title>
<script src="slideshow.js" type="text/javascript"></script>
<script src="jquery-1.8.3.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@include file="master.html" %>
<div id="edit_item">
<table>
	Add Item
	<s:actionerror />
	<s:actionmessage />
	<tr><td>Workflow :</td>
	<td><s:property value="workflowID" /></td></tr>
	<s:form action=".action" method="post">
		<s:hidden name="workflowID" id="workflowID" value="%{workflowID}" />
		<s:hidden name="itemID" id="itemID" value="%{itemID}" />
		<tr><td>Item ID :</td><td><s:property value="itemID" /></td></tr>
		<s:iterator value="itemList" var="itemList" status="stat" id="itemList">
			<tr><td>ItemName</td><td><s:textfield name="itemName" id="itemName" label="Item Name"
				size="50" /></td></tr>
			<tr><td>Item Description</td><td><s:textfield name="itemDescription" id="itemDescription"
				label="Item Description" size="50" /></td></tr>
			Current Stage ID :<s:property value="currentStageID" />
			<s:hidden name="currentStageID" id="currentStageID" value="%{currentStageID}" />
			<tr><td>Remarks</td><td><s:textfield name="remarks" id="remarks" label="Remarks" size="50" />
			<s:textfield name="filePath" id="filePath" label="File Path"
				size="50" /></td></tr>
		</s:iterator>
		<tr><td></td><td><s:submit name="button" value="Save" action="editToWorkflowItemConsole"
			align="left" id="button" />
		<s:submit name="button" value="Back" action="backToWorkflowItemConsole"
			align="left" id="button" />
		<s:submit name="button" value="Delete" action="deleteToWorkflowItemConsole"
			align="left" id="button" /></td></tr>
	</s:form>
	</table>
	</div>
</body>
</html>