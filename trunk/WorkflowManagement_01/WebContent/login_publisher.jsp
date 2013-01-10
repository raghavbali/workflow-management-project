<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<link rel="stylesheet" type="text/css" href="style.css">
<script language="JavaScript">
	var x = window.history.length;
	if (window.history[x] != window.location) {
		window.history.forward();
	}
</script>
<title>Welcome publisher</title>
<script src="slideshow.js" type="text/javascript"></script>
<script src="jquery-1.8.3.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
<%@include file="master.html" %>
	<div id="menu">
	<ul>	
		<li><a href="#">Home</a></li>
		<li><a href="#">About US</a></li>
		<li><a href="logoutAdminConsole.action">Logout</a></li>
	</ul>
	</div>
	<div id="login_publisher">
	<s:actionmessage/>
	<s:actionerror/>
	<s:if test="%{#session['logged-in']=='true'}">
	<s:form action="updateLeaderList.action" method="post">
	<s:hidden name = "workflowID" value="%{workflowID}"/>
	<s:hidden name = "itemID" value="%{itemID}"/>
	<s:hidden name = "stageID" value="%{stageID}"/>
	<s:hidden name="pageName" value="%{pageName}"/>
	<s:set name="pageName" value="%{pageName}"/>
	
	<table border="1">
			<tr>
				<th><h3>Sno </h3>
				</th>
				<th><h3>Item ID </h3>
				</th>
				<th><h3>Item Name </h3>
				</th>
				<th><h3>Stage Name </h3>
				</th>
				<th><h3>Assigned On </h3>
				</th>
				<th><h3>Delivery Date </h3>
				</th>
				<th><h3>Last Updated </h3>
				</th>
				<th><h3>Status </h3>
				</th>
				<th><h3>Days Left </h3>
				</th>
				<th><h3>Delegate </h3>
				</th>
				<th><h3>Move to Next Stage </h3>
				</th>
				<th><h3>Move to Previous Stage </h3>
				</th>
			</tr>
			<s:iterator value="objBucketView" status="Sno">
				<tr>
					<td><s:property value="#Sno.index+1" />
					 </td>
					<td><s:property value="itemID" />
					 </td>
					<td><s:property value="itemName" />
					 </td>
					<td><s:property value="stageName" />
					 </td>
					<td><s:property value="assignedDate" />
					 </td>
					 <td><s:property value="deliveryDate" />
					 </td>
					 <td><s:property value="lastUpdated" />
					 </td>
					 <td><s:property value="status" />
					 </td>
					 <td><s:property value="daysLeft" />
					 </td>
					<td><a
						href="authorsList.action?stageID=<s:property value="stageID"/>&itemID=<s:property value="itemID"/>">Delegate </a></td>
					<td><a
						href="forwardMove.action?stageID=<s:property value="stageID"/>&itemID=<s:property value="itemID"/>">Move to Next Stage </a>
					</td>
					<td><a
						href="backwardMove.action?stageID=<s:property value="stageID"/>&itemID=<s:property value="itemID"/>">Move to Previous Stage </a>
					</td>
				</tr>
			</s:iterator>
			</table>
			<s:submit name = "commandButton" id="mysubmit" value="Update" align="center" />
	</s:form>
	</s:if>
	<s:else>
    	Trespassers will be shot. Survivors will be shot again!!!
    	<a href="login.jsp">Login</a>
	</s:else>
	<s:if test="%{#pageName=='delegateAuthors'}">
	<h4>Available authors for item ${itemID}: </h4>
	<s:form action="delegate_authors.action" method="post">
		<s:hidden name="stageID" value="%{stageID}" />
		<s:hidden name="workflowID" value="%{workflowID}" />	
		<s:hidden name = "itemID" value="%{itemID}"/>
			
	<table>
	<s:iterator value = "usrlist">
	<tr>
	<td><s:checkbox name="checkboxes" label="%{getUser().getFname()} %{getUser().getLname()} [%{getUser_role().getUser_id()}]" fieldValue="%{getUser_role().getUser_id()}" value="%{getUser_role().getUser_id() in checkboxes}" /></td>
	</tr>
		</s:iterator>
	<tr>
		<s:submit name = "commandButton" id="mysubmit" value="Delegate" align="center" />
	</tr>
	</table>

	</s:form>
	</s:if>
	</div>
	</div>
</body>
</html>