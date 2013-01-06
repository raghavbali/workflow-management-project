<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

<script language="JavaScript">
	var x = window.history.length;
	if (window.history[x] != window.location) {
		window.history.forward();
	}
</script>
<title>Welcome author</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div id="box">
	<div id="heading">
	WORKFLOW MANAGEMENT
	</div>
	<div id="menu">
	<ul>	
		<li><a href="#">Home</a></li>
		<li><a href="#">About US</a></li>
		<li><a href="logoutAdminConsole.action">Logout</a></li>
	</ul>
	<s:actionmessage />
	<s:actionerror />
	<s:if test="%{#session['logged-in']=='true'}">
		<s:form action="" method="">
			<a href="logoutAdminConsole.action">Logout</a>
			<table border="1">
				<tr>
					<th><h3>Sno</h3></th>
					<th><h3>Item ID</h3></th>
					<th><h3>Item Name</h3></th>
					<th><h3>Stage Name</h3></th>
					<th><h3>Assigned On</h3></th>
					<th><h3>Delivery Date</h3></th>
					<th><h3>Status</h3></th>
					<th><h3>Days Left</h3></th>
					<th><h3>Update Item</h3></th>
				</tr>
				<s:iterator value="objBucketView" status="Sno">
					<tr>
						<td><s:property value="#Sno.index+1" /></td>
						<td><s:property value="itemID" /></td>
						<td><s:property value="itemName" /></td>
						<td><s:property value="stageName" /></td>
						<td><s:property value="assignedDate" /></td>
						<td><s:property value="deliveryDate" /></td>
						</td>
						<td><s:property value="status" /></td>
						<td><s:property value="daysLeft" /></td>
						<td><a
							href="authorAction.action?itemID=<s:property value = "itemID" />&status=<s:property value="status"/>">Update
								Item </a></td>
					</tr>
				</s:iterator>
			</table>
			<s:if test="%{remarks !=null}">
						Remarks: <s:property value="remarks" /><br>
						<s:textarea name="remarks" id="remarks" value=""/>
						<s:select label="Status" headerKey="-1"
						headerValue="Status"
						list="statusOptions"
						name="status"
						value="%{status}" />
			<s:submit name="update_author_item" method="updateItem" value="Update" align="left"/>
			</s:if>
		</s:form>
	</s:if>
	<s:else>
    	Trespassers will be shot. Survivors will be shot again!!!
    	<a href="login.jsp">Login</a>
	</s:else>
	</div>
	</div>
</body>
</html>