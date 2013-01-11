<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin page - Edit User Basic</title>
<SCRIPT Language="JavaScript">
<!--//
function showAndClearField(frm){
  if (frm.fname.value == "")
      alert("Hey! You didn't enter anything!")
  
  frm.fname.value = ""
}
//-->
</SCRIPT>
<script src="slideshow.js" type="text/javascript"></script>
<script src="jquery-1.8.3.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="validation.js"></script>
</head>
<body>
<%@include file="master.html" %>
<div id="edit_user_basic">
<table>
<h2>Edit User Basic</h2>
	<s:form action="update_user_basic.action" method="post" onSubmit="return edit_user_basic(buttonIndex);">
		<s:hidden name="p_id"/>
		<s:hidden name="workflowID" value="%{workflowID}" />
		<tr><th><div id="loginmandatory" style="color:red"></div></th></tr>
		<tr><td>Select prefix</td><td><s:select label="Select prefix" headerKey="-1"
			headerValue="Select prefix"
			list="prefixList"
			name="prefix" value="%{tmpuser.getPrefix()}"/></td></tr>
		<tr><td>First Name</td><td><s:textfield name="fname" id="fname" label="First Name" value="%{tmpuser.getFname()}" size="30" required="true"/></td></tr>
		<tr><td>Last Name</td><td><s:textfield name="lname" id="lname" label="Last Name" value="%{tmpuser.getLname()}" size="30" required="true"/></td></tr>
		<tr><td>Sex</td><td><s:select label="Select sex" headerKey="-1"
			headerValue="Select sex"
			list="sexList"
			name="sex" value="%{tmpuser.getSex()}" /></td>
		<tr><td>DOB</td><td><s:textfield name="dob" id="dob" label="DoB(yyyy-mm-dd)" size="30" value="%{tmpuser.getDob()}" required="true"/></td></tr>
		<tr><td>Address</td><td><s:textfield name="address" id="address" label="Address" size="60" value="%{tmpuser.getAddress()}" required="true"/></td></tr>
		<tr><td>Country</td><td><s:textfield name="country" id="country" label="Country" size="30" value="%{tmpuser.getCountry()}" required="true"/></td></tr>
		<tr><td>Phone no.</td><td><s:textfield name="phone" id="phone" label="Phone no." size="30" value="%{tmpuser.getPhone()}" required="true"/></td></tr>
		<tr><td>Email ID</td><td><s:textfield name="email" id="email" label="Email ID" size="30" value="%{tmpuser.getEmail()}" required="true"/></td></tr>
		<tr><td><s:submit name = "button1" value = "Edit" align="center" onclick="buttonIndex=1" /></td>
		<td>
		<s:if test="%{#session['role']=='admin'}">
		<s:submit name = "button1" value = "Back" align="center" action="editUserAdminConsole" onclick="buttonIndex=2" />
		</s:if>
		<s:elseif test="%{#session['role']=='editor'}">
		<s:submit name = "button1" value = "Back" align="center" action="assignRoleEditorConsole" onclick="buttonIndex=2" />
		</s:elseif>
		</td>
		</tr>
		
		<s:actionerror />
		<s:actionmessage/>
	</s:form>
	</table>
	</div>
	</div>
</body>
</html>