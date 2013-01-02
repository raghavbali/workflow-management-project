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
	<s:form action=".action" method="post">
		<s:textfield name="itemName" id="itemName" label="Item Name" size="50" />
		<s:textfield name="itemDescription" id="itemDescription" label="Item Description"
			size="50" />
		<s:textfield name="remarks" id="remarks" label="Remarks"
			size="50" />
		<s:textfield name="filePath" id="filePath" label="File Path"
			size="50" />
		<s:submit name="addItem" id="addItem" method="execute" value="Add"
			align="center" />
	</s:form>
</body>
</html>