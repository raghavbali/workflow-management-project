<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit User Advanced</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="slideshow.js" type="text/javascript"></script>
<script src="jquery-1.8.3.js" type="text/javascript"></script>
<script src="validation.js"></script>
<SCRIPT Language="JavaScript">
<!--//
function showAndClearField(frm){
  if (frm.fname.value == "")
      alert("Hey! You didn't enter anything!")
  
  frm.fname.value = ""
}
//-->
</SCRIPT>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@include file="master.html" %>
<div id="edit_user_adv">
<h2>Edit User Advanced</h2>
<table>
	<s:form action="update_user_adv.action" method="post" onSubmit="return edit_user_adv(buttonIndex);">
		<s:hidden name="user_id"/>
		<s:hidden name="p_id" value="%{tmpuser.getP_id()}"/>
		<s:hidden name ="active_flag" value="%{tmpuser.getActive_flag()}"/>
		<s:hidden name="pageName" value="%{pageName}"/>
		<s:hidden name="workflowID" />
		<tr><td>Select Workflow</td><td><s:select label="Select Workflow" 
			list="wfList"
			name="w_id" value="%{tmpuser.getW_id()}" required="true"/></td></tr>
		<tr><td>Select Role</td><td><s:select label="Select Role" 
			list="roleList"
			name="role" value="%{tmpuser.getRole()}" required="true"/></td></tr>
		<tr><td>User Name</td><td><s:textfield name="username" placeholder="username" id="username" label="User Name" value="%{tmpuser.getUsername()}" size="30" required="true"/></td></tr>
		<tr><td>Password</td><td><s:password name="password" placeholder="password" id="password" label="Password" size="30" required="true"/></td></tr>
		<tr><td>Select active state</td><td><s:select label="Is active?" 
			list="actstateList"
			name="selected_actstate" value="%{tmpuser.getActive_flag()}" required="true"/></td></tr>
		<s:actionerror />
		<s:actionmessage/>
		<tr>
					<td><s:submit name="commandButton" id="mysubmit"
							value="Edit role" align="center" onclick="buttonIndex=1" /></td>
					<s:if test="%{#session['role']=='admin'}">
						<td><s:submit name="button1" value="Back" align="center"
								action="editUserAdminConsole" onclick="buttonIndex=2" />
						<div id="loginmandatory" style="color: red"></div>
						</td>
					</s:if>
					<s:elseif test="%{#session['role']=='editor'}">
						<td><s:submit name="button1" value="Back" align="center"
							action="assignRoleEditorConsole" onclick="buttonIndex=1" />
						<div id="loginmandatory" style="color: red"></div>
						</td>
					</s:elseif>
		</td>
		</tr>
	</s:form>
	</table>
	</div>
	</div>
</body>
</html>