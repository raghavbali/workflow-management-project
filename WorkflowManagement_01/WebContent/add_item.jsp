<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Add Item</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@include file="master.html" %>
	<div id="add_item">
	<h2>Add Item</h2>
	<s:actionerror />
	<s:actionmessage/>
	Workflow ID :<s:property value="workflowID" />
	<s:form action=".action" method="post">
		<s:hidden name="workflowID" id="workflowID" value="%{workflowID}" />
		<s:textfield name="itemName" id="itemName" label="Item Name" size="50" />
		<s:textfield name="itemDescription" id="itemDescription" label="Item Description"
			size="50" />
		<s:textfield name="remarks" id="remarks" label="Remarks"
			size="50" />
		<s:textfield name="filePath" id="filePath" label="File Path"
			size="50" />
			<s:submit name="button" value="Add"
			action="addToWorkflowItemConsole" align="left" id="addToWorkflowItemConsole"/>
			<s:submit name="button" value="Back"
			action="doneEditorConsole" align="left" />
	</s:form>
	</div>
	</div>
</body>
</html>