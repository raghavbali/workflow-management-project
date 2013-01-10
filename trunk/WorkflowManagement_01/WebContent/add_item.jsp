<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Add Item</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="slideshow.js" type="text/javascript"></script>
<script src="jquery-1.8.3.js" type="text/javascript"></script>

</head>
<body>
<%@include file="master.html" %>
	<div id="add_item">
	<h2>Add Item</h2>
	<s:actionerror />
	<s:actionmessage/>
	<table>
	<tr><td>Workflow ID :</td><td><s:property value="workflowID" /></td></tr>
	<s:form action=".action" method="post">
		<s:hidden name="workflowID" id="workflowID" value="%{workflowID}" />
		<tr><td>Item Name</td><td><s:textfield name="itemName" id="itemName" label="Item Name" size="50" /></td></tr>
		<tr><td>Item Description:</td><td><s:textfield name="itemDescription" id="itemDescription" label="Item Description"
			size="50" /></td></tr>
		<tr><td>Remarks</td><td><s:textfield name="remarks" id="remarks" label="Remarks"
			size="50" /></td></tr>
		<tr><td>File Path:</td><td><s:textfield name="filePath" id="filePath" label="File Path"
			size="50" /></td></tr>
		<tr><td><s:submit name="button" value="Add"
			action="addToWorkflowItemConsole" align="left" id="addToWorkflowItemConsole"/></td>
			<td><s:submit name="button" value="Back"
			action="doneEditorConsole" align="left" /></td></tr>
	</s:form>
	</table>
	</div>
	</div>
</body>
</html>