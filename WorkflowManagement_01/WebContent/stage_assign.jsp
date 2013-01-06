<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Assign users to stage</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div id="box">
	<div id="heading">
	WORKFLOW MANAGEMENT
	</div>
	<div id="assign_role">
<h3> Available stages: </h3>
<s:actionerror />
<s:hidden name="workflowID" value="%{workflowID}"/>
<s:hidden name="pageName" value="%{pageName}"/>
<s:set name="pageName" value="%{pageName}"/>
<table>
	<tr>
	    <th><h3>Stage_ID</h3></th>
	    <th><h3>Stage Name</h3></th>
	    <th><h3>Stage Description</h3></th>
	    <th><h3>SLA</h3></th>
	    <th><h3>Seq_No.</h3></th>
	    <th><h3>Stage Lead</h3></th>
	    <th><h3>W_ID</h3></th>
	</tr>
	<s:iterator value = "stageList">
	<tr>
		<td><s:property value="stageID"/></td>
		<td><s:property value="stageName"/></td>
		<td><s:property value="stageDescription"/></td>
		<td><s:property value="stageSLA"/></td>
		<td><s:property value="stageSequenceNo"/></td>
		<td><s:property value="stageLeadID"/></td>
		<td><s:property value="wfId"/></td>
		<td><a href="assign_users?stageID=<s:property value="stageID"/>&workflowID=<s:property value="workflowID"/>">Assign Users</a></td>
	</tr>
	</s:iterator>
</table>
<s:if test="%{#pageName=='assignUsers'}">
<br>
<h3>Assign Stage ${stageID}: </h3>
<h4>Available authors: </h4>
	<s:form action="final_assign_authors.action" method="post">
		<s:hidden name="stageID" value="%{stageID}" />
		<s:hidden name="workflowID" value="%{workflowID}" />		
	<table>
	<s:iterator value = "usrlist">
	<tr>
	<td><s:checkbox name="checkboxes" label="%{getUser().getFname()} %{getUser().getLname()} [%{getUser_role().getUser_id()}]" fieldValue="%{getUser_role().getUser_id()}" value="%{getUser_role().getUser_id() in checkboxes}" /></td>
	</tr>
		</s:iterator>
	<tr>
		<s:submit name = "commandButton" id="mysubmit" value="Assign" align="center" />
	</tr>
	</table>

	</s:form>
<h4>Available publishers: </h4>
	<s:form action="final_assign_publishers.action" method="post">
		<s:hidden name="stageID" value="%{stageID}" />
		<s:hidden name="workflowID" value="%{workflowID}" />		
	<table>
	<tr>	
		<td><s:radio name = "selectedPublisher" list="usrlist2" label="publishers" value = "selectedPublisher"  /> </td>
	</tr>
	<tr>
		<s:submit name = "commandButton" id="mysubmit" value="Assign" align="center" />
	</tr>
	</table>
	<s:actionerror />
	<s:actionmessage/>
	</s:form>
	
</s:if>
</div>
</div>
</body>
</html>