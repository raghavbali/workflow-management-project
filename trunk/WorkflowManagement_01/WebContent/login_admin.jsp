<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

<title>Welcome admin</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="slideshow.js" type="text/javascript"></script>
<script src="jquery-1.8.3.js" type="text/javascript"></script>

</head>
<body>
	<%@include file="master.html"%>
	<div id="buttons_menu">
		<s:actionmessage />
		<s:actionerror />
		<s:if test="%{#session['logged-in']=='true'}">
			<s:form action="" method="">
<table>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><s:if test="%{#session.tableSuffix=='_00000000000000'}">

								<s:submit name="button" value="Create Workflow"
									action="createWfAdminConsole" align="left" />
							</s:if>
						</td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><s:submit name="button" value="Edit Workflow"
								action="editWorkflowAdminConsole" align="left" />
						</td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><s:submit name="button" value="Add User"
								action="createUserAdminConsole" align="left" />
						</td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><s:submit name="button" value="Edit User"
								action="editUserAdminConsole" align="left" />
						</td>
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
	<div id="login_admin_about_menu">
	<img src="images/adminConsole.jpg" alt="adminConsole.jsp"  />
	</div>
	</div>
</body>
</html>