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
<script src="slideshow.js" type="text/javascript"></script>
<script src="jquery-1.8.3.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
<%@include file="master.html" %>
	
	<s:if test="%{#session['logged-in']=='true'}">
		<s:form action="" method="">
		<div id="login_author">
		<table>
	<s:actionmessage />
	<s:actionerror />
	</table>
			<table>
				<tr>
					<th><h3>Sno</h3></th>
					<th><h3>Item ID</h3></th>
					<th><h3>Item Name</h3></th>
					<th><h3>Stage Name</h3></th>
					<th><h3>Assigned On</h3></th>
					<th><h3>Delivery Date</h3></th>
					<th><h3>Status</h3></th>
					<th><h3>Days Left</h3></th>
					<th><h3>Last Updated</h3></th>
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
						<td><s:property value="lastUpdated" /></td>
						<td>
						<s:set name= "statusVal" value="status"/>
							<s:if test='%{#statusVal!="F" && #statusVal!="B"}'>
						<a
							href="authorAction.action?itemID=<s:property value = "itemID" />&status=<s:property value="status"/>&stageID=<s:property value="stageID"/>">Update
								Item </a>
						</s:if>
							<s:else>
							Updated
							</s:else>
						</td>
					</tr>
				</s:iterator>
			</table>
			<s:if test="%{remarks !=null}">
						Remarks: <s:text name="remarks.split('<br/>|<\r\n>')"  /><br/>
						<s:textarea name="remarksNew" id="remarksNew" value=""/>
						<s:select label="Status" 
						list="statusOptions"
						name="status"
						value="%{status}" />
			<s:hidden id="remarks" name="remarks"/>
			<s:hidden id="itemID" name="itemID"/>
			<s:hidden id="userID" name="userID"/>
			<s:hidden id="stageID" name="stageID"/>
			<s:submit name="update_author_item" method="updateItem" value="Update" align="left"/>
			</s:if></div>
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