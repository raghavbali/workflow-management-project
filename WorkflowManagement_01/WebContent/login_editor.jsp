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
	<%@include file="master.html"%>
	<div id="buttons_menu">
		<s:actionmessage />
		<s:actionerror />
		<s:if test="%{#session['logged-in']=='true'}">
			<s:form action="" method="">
				<s:hidden name="workflowID" id="workflowID" value="%{workflowID}" />

				<table>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><s:submit name="button" value="Stage Assignment"
								action="assignStageEditorConsole" align="left" /></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><s:submit name="button" value="Create Item"
								action="createItemEditorConsole" align="left" /></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><s:submit name="button" value="Edit Item"
								action="editItemsEditorConsole" align="left" /></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><s:submit name="button" value="Configue User"
								action="assignRoleEditorConsole" align="left" /></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><s:submit name="button" value="Generate reports"
								action="generateReportsEditorConsole" align="left" /></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>

			</s:form>
		</s:if>
		<s:else>
    	Trespassers will be shot. Survivors will be shot again!!!
    	<a href="login.jsp">Login</a>
		</s:else>
	</div>

	<div id="editorConsole">
	<img src="images/editorConsole.jpg" alt="editorConsole.jsp"  />
	</div>

	</div>
</body>
</html>