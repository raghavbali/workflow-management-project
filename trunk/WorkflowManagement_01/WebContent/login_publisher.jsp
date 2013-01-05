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

<script language="JavaScript">
	var x = window.history.length;
	if (window.history[x] != window.location) {
		window.history.forward();
	}
</script>
<title>Welcome publisher</title>
</head>
<body>
<s:actionmessage/>
	<s:actionerror/>
	<s:if test="%{#session['logged-in']=='true'}">
	<s:form action="" method="">
	<a href="logoutAdminConsole.action">Logout</a>
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
					  </td>
					 <td><s:property value="status" />
					 </td>
					 <td><s:property value="daysLeft" />
					 </td>
					<td><a
						href="edit_wf.action?workflowID=<s:property value = "workflowID" />">Delegate </a></td>
					<td><a
						href="stage_mod.action?workflowID=<s:property value = "workflowID" />&pageName=workflow_list ">Move to Next Stage </a>
					</td>
					<td><a
						href="stage_mod.action?workflowID=<s:property value = "workflowID" />&pageName=workflow_list ">MOve to Previous Stage </a>
					</td>
				</tr>
			</s:iterator>
			</table>
	</s:form>
	</s:if>
	<s:else>
    	Trespassers will be shot. Survivors will be shot again!!!
    	<a href="login.jsp">Login</a>
	</s:else>
</body>
</html>