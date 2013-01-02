<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Select Stage</title>
</head>
<body>
	<h2>Stage Details</h2>
	<s:actionerror />
	<s:actionmessage />
	<s:form action="stage_mod.action" method="post">
	Workflow ID :<s:property value="workflowID" />
	<s:hidden name="workflowID" value="%{workflowID}"/>
	<s:hidden name="pageName" value="stage_list_default"/>
		<table>
			<tr>
				<th><h3>Stage ID </h3>
				</th>
				<th><h3>Stage Name </h3>
				</th>
				<th><h3>Stage Description </h3>
				</th>
				<th><h3>Stage SLA </h3>
				</th>
				<th><h3>Stage Sequence </h3>
				</th>
				<th><h3>Edit Stage </h3>
				</th>
			</tr>
			<s:iterator value="objListWfDetails" var="wfDetail" status="stat" >
				<tr>
				
					<td><s:property value="stageID" />
					 </td>
					<td><s:property value="stageName" />
					 </td>
					<td><s:property value="stageDescription" />
					 </td>
					<td><s:property value="stageSLA" />
					 </td>
					<td><s:property value="stageSequenceNo" />
					 </td>
					<td>
					<a
						href="stage_mod.action?stageID=<s:property value = "stageID" />&pageName=stage_list&workflowID=<s:property value = "workflowID" /> ">Modify Stage </a>
					</td>
				</tr>
			</s:iterator>
			</table>
			<s:submit name="button" value="Add Stage" align="left" method="addStage"/>
			<s:submit name="button"  value="Done"
			action="doneStage" align="center" />
			</s:form>
</body>
</html>