<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Workflow Details</title>
</head>
<body>
	<h2>Edit Details</h2>
	<s:actionerror />
	<s:actionmessage/>
	WorkflowID:<s:property value="workflowID" />
	<s:hidden name="workflowID" value="%{workflowID}"/>
	<s:form action="" method="post">
	<s:iterator value="objListWfDetails" >
		<s:textfield name="stageName" label="Stage Name"  size="30" />
		<s:textfield name="stageDescription" label="Stage Description"
			size="100" />
		<s:textfield name="stageSLA" label="Stage SLA(in hrs)"
			size="5" />
		<s:textfield name="stageSequenceNo" label="Stage Sequence Number"
			 size="5" />
		<s:submit name="button" value="Update Stage"
			action="updateNowStage" align="center" />
		<s:submit name="button"  value="Done"
			action="doneStage" align="center" />
			</s:iterator>
	</s:form>
</body>
</html>