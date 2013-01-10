<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<title>Welcome Editor</title>
<script src="slideshow.js" type="text/javascript"></script>
<script src="jquery-1.8.3.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
<%@include file="master.html" %>	
	<s:actionmessage/>
	<s:actionerror/>
	<div id="buttons_menu">
	<ul>
	<s:form action="" method="">
	<s:text name="%{#session['role']}"/>
	<s:hidden name="workflowID" id="workflowID" value="%{workflowID}" />
	<s:submit name="button" value="SLA Report" action="slaReport"
			align="left" />
	<li>	<s:submit name="button" value="Item Status Report" action="itemReport"
			align="left" /></li>
		<li><s:submit name="button" value="Resource Allocation Chart" action="resourceReport"
			align="left" /></li>
			<li><s:submit name="button" value="Back" action="doneEditorConsole"
			align="left" /></li>
	</s:form>
	</ul>
	</div>
	</div>
</body>
</html>