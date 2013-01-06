<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
function submitForm(workflowID){
	   //All this would be very easy if you were using jQuery
	   var nameElem = document.getElementById(workflowID);

	    //set the values to submit
	   document.getElementById("workflowID").value = workflowID;

	   document.workflowMod.submit(); //finally submit the form
	}
</script>
<link rel="stylesheet" type="text/css" href="style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Select Workflow</title>
</head>
<body>
	<div id="box">
	<h2>Add Details</h2>
	<s:actionerror />
	<s:actionmessage />
	<s:form action="stage_mod.action" method="post" name="workflowMod" >
		<table>
			<tr>
				<th><h3>Workflow_ID </h3>
				</th>
				<th><h3>Workflow Name </h3>
				</th>
				<th><h3>Workflow Description </h3>
				</th>
				<th><h3>Workflow Domain </h3>
				</th>
				<th><h3>Workflow Modifications </h3>
				</th>
				<th><h3>Stage Modifications </h3>
				</th>
			</tr>
			<s:iterator value="objListWfMaster">
				<tr>
					<td><s:property value="workflowID" />
					 </td>
					<td><s:property value="workflowName" />
					 </td>
					<td><s:property value="workflowDescription" />
					 </td>
					<td><s:property value="workflowDomain" />
					 </td>
					<td><a
						href="edit_wf.action?workflowID=<s:property value = "workflowID" />">Workflow Modifications </a></td>
					<td><a
						href="stage_mod.action?workflowID=<s:property value = "workflowID" />&pageName=workflow_list ">Stage Modifications </a>
					</td>
				</tr>
			</s:iterator>
			</table>
			<s:submit name="button" value="Back"
				action="backToAdminConsole" align="left" />
			</s:form>
			</div>
</body>
</html>