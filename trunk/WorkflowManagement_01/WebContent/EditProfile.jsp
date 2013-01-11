<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit User Profile</title>
<SCRIPT Language="JavaScript">
<!--//
function showAndClearField(frm){
  if (frm.fname.value == "")
      alert("Hey! You didn't enter anything!")
  
  frm.fname.value = ""
}
//-->
</SCRIPT>
<script src="validation.js"></script>
</head>
<body >
<%@include file="master.html" %>
<div id="edit_user_profile">
<h2>Edit User Profile</h2>
<s:actionerror />
			<s:actionmessage/>
<table>
<tr><td></td><td><div id="loginmandatory" style="color:red"></div></td></tr>
	<s:form method="post" onSubmit="return edit_user_profile(buttonIndex);">
		<s:hidden name="user_id"/>
		<s:hidden name="p_id" value="%{tmpuser.getP_id()}"/>
		<s:hidden name ="active_flag" value="%{tmpuser.getActive_flag()}"/>
		<s:hidden name="workflowID" />
		<s:hidden name="pageName" value="%{pageName}"/>
		<s:set name="pageName" value="%{pageName}"/>
		<tr><td>Select prefix</td><td><s:select label="Select prefix" headerKey="-1"
			headerValue="Select prefix"
			list="prefixList"
			name="prefix" value="%{tmpuser.getPrefix()}"/></td></tr>
		<tr><td>First Name</td><td><s:textfield name="fname" label="First Name" id="fname" placeholder="First Name"  value="%{tmpuser.getFname()}" size="30" /></td></tr>
		<tr><td>Last Name</td><td><s:textfield name="lname" label="Last Name" id="lname" placeholder="Last Name" value="%{tmpuser.getLname()}" size="30" /></td></tr>
		<tr><td>Sex</td><td><s:select label="Select sex" headerKey="-1"
			headerValue="Select sex"
			list="sexList"
			name="sex" value="%{tmpuser.getSex()}" /></td>
		<tr><td>DOB</td><td><s:textfield name="dob" label="DoB(yyyy-mm-dd)" id="dob" placeholder="DOB" size="30" value="%{tmpuser.getDob()}" /></td></tr>
		<tr><td>Address</td><td><s:textfield name="address" id="address" placeholder="Address" label="Address" size="100" value="%{tmpuser.getAddress()}"/></td></tr>
		<tr><td>Country</td><td><s:textfield name="country" label="Country" id="country" placeholder="Country" size="30" value="%{tmpuser.getCountry()}"/></td></tr>
		<tr><td>Phone no.</td><td><s:textfield name="phone" label="Phone no." id="phone" placeholder="Phone No" size="30" value="%{tmpuser.getPhone()}"/></td></tr>
		<tr><td>Email ID</td><td><s:textfield name="email" id="email" placeholder="email" label="Email ID" size="30" value="%{tmpuser.getEmail()}"/></td></tr>
		
		<tr><td>Role</td><td><s:label value="%{tmpuser.getRole()}"/></td></tr>
		<tr><td>User Name</td><td><s:label value="%{tmpuser.getUsername()}"/></td></tr>
		
		<tr><td>Password</td><td><a href="changePass.action?pageName=<s:property value="pageName"/>">Reset Password?</a>
		<tr><td><s:submit name = "button1" value = "Edit" onclick="buttonIndex=1" align="center" action="editUserProfileBasic"/></td>
		<td>
		<s:if test="%{#session['role']=='admin'}">
			<s:submit name = "button1" value = "Back" onclick="buttonIndex=2" align="center" action="backToAdminConsole"/>
		</s:if>
		<s:if test="%{#session['role']=='author'}">
			<s:submit name = "button1" value = "Back" onclick="buttonIndex=2" align="center" action="authorAction"/>
		</s:if>
		<s:if test="%{#session['role']=='publisher'}">
			<s:submit name = "button1" value = "Back" onclick="buttonIndex=2" align="center" action="publisherAction"/>
		</s:if>
		<s:if test="%{#session['role']=='editor'}">
			<s:submit name = "button1" value = "Back" onclick="buttonIndex=2" align="center" action="doneEditorConsole"/>
		</s:if>				
		</td>
		</tr>
	</s:form>
	</table>
	
	<s:if test="%{#pageName=='changePass'}">
	<s:form method="post">
	<table>
	<tr><td>Old password: </td><td><s:password name = "oldPass" size = "30"/></td></tr>
	<tr><td>New password: </td><td><s:password name = "newPass" size = "30"/></td></tr>
	<tr><td>New password (Enter again): </td><td><s:password name = "reNewPass" size = "30"/></td></tr>
	<tr><td><s:submit name = "button1" value = "Change" align="center" action="editUserProfileAdv"/></td>
	<td><s:submit name = "button1" value = "Cancel" align="center" action="editUserProfile"/></td>
	</table>
	</s:form>
	</s:if>
	</div>
	</div>
</body>
</html>