<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Select Item</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@include file="master.html" %>
	<div id="item_list">
	<h2>Item Details</h2>
	<s:actionerror />
	<s:actionmessage />
	<s:form action="*EditorConsole.action" method="post">
	Workflow ID :<s:property value="workflowID"/>
	<s:hidden name="workflowID" value="%{workflowID}"/>
		<table>
			<tr>
				<th><h3>Item ID </h3>
				</th>
				<th><h3>Item Name </h3>
				</th>
				<th><h3>Item Description </h3>
				</th>
				<th><h3>Remarks </h3>
				</th>
				<th><h3>File Path </h3>
				</th>
				<th><h3>Edit Item </h3>
				</th>
				<th><h3>Push Item </h3>
				</th>
			</tr>
			<s:iterator value="itemList" var="itemList" status="stat" id="itemList">
				<tr>
					<td><s:property value="itemID" />
					 </td>
					<td><s:property value="itemName" />
					 </td>
					<td><s:property value="itemDescription" />
					 </td>
					<td><s:property value="remarks" />
					 </td>
					<td><s:property value="filePath" />
					 </td>
					<td>
					<a
						href="editItemEditorConsole.action?itemID=<s:property value = "itemID" />&workflowID=<s:property value = "workflowID" /> ">Modify Item </a>
					</td>
					<td>
					<a
						href="pushItemEditorConsole.action?itemID=<s:property value = "itemID" />">Push Item </a>
					</td>
				</tr>
			</s:iterator>
			</table>
			<s:submit name="button" value="Add Item"
			action="createItemEditorConsole" align="left" />
			<s:submit name="button" value="Back"
			action="doneEditorConsole" align="left" />
			</s:form>
			</div>
			</div>
</body>
</html>