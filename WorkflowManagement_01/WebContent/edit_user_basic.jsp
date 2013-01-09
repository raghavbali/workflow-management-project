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

</head>
<body>
<%@include file="master.html" %>
<div id="edit_user_basic">
<table>
<h2>Edit User Basic</h2>
	<s:form action="update_user_basic.action" method="post">
		<s:hidden name="p_id"/>
		<tr><td>Select prefix</td><td><s:select label="Select prefix" headerKey="-1"
			headerValue="Select prefix"
			list="prefixList"
			name="prefix" value="%{tmpuser.getPrefix()}"/></td></tr>
		<tr><td>First Name</td><td><s:textfield name="fname" label="First Name" value="%{tmpuser.getFname()}" size="30" /></td></tr>
		<tr><td>Last Name</td><td><s:textfield name="lname" label="Last Name" value="%{tmpuser.getLname()}" size="30" /></td></tr>
		<tr><td>Sex</td><td><s:select label="Select sex" headerKey="-1"
			headerValue="Select sex"
			list="sexList"
			name="sex" value="%{tmpuser.getSex()}" /></td>
		<tr><td>DOB</td><td><s:textfield name="dob" label="DoB(yyyy-mm-dd)" size="30" value="%{tmpuser.getDob()}" /></td></tr>
		<tr><td>Address</td><td><s:textfield name="address" label="Address" size="100" value="%{tmpuser.getAddress()}"/></td></tr>
		<tr><td>Country</td><td><s:textfield name="country" label="Country" size="30" value="%{tmpuser.getCountry()}"/></td></tr>
		<tr><td>Phone no.</td><td><s:textfield name="phone" label="Phone no." size="30" value="%{tmpuser.getPhone()}"/></td></tr>
		<tr><td>Email ID</td><td><s:textfield name="email" label="Email ID" size="30" value="%{tmpuser.getEmail()}"/></td></tr>
		<tr><td><s:submit name = "button1" value = "Edit" align="center" /></td>
		<td><s:submit name = "button1" value = "Back" align="center" /></td>
		</tr>
		
		<s:actionerror />
		<s:actionmessage/>
	</s:form>
	</table>
	</div>
	</div>
</body>
</html>