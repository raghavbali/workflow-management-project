<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Add Item</title>
</head>
<body>
	<h2>Add Item</h2>
	<s:actionerror />
	<s:actionmessage />
	Workflow ID :
	<s:property value="workflowID" />
	<s:form action=".action" method="post">
		<s:hidden name="workflowID" id="workflowID" value="%{workflowID}" />
		<s:hidden name="itemID" id="itemID" value="%{itemID}" />
		Item ID :<s:property value="itemID" />
		<s:iterator value="itemList" var="itemList" status="stat" id="itemList">
			<s:textfield name="itemName" id="itemName" label="Item Name"
				size="50" />
			<s:textfield name="itemDescription" id="itemDescription"
				label="Item Description" size="50" />
			Current Stage ID :<s:property value="currentStageID" />
			<s:hidden name="currentStageID" id="currentStageID" value="%{currentStageID}" />
			<s:textfield name="remarks" id="remarks" label="Remarks" size="50" />
			<s:textfield name="filePath" id="filePath" label="File Path"
				size="50" />
		</s:iterator>
		<s:submit name="button" value="Save" action="editToWorkflowItemConsole"
			align="left" id="editToWorkflowItemConsole" />
	</s:form>
</body>
</html>