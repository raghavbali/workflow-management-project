<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin page - Add User</title>
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
<div id="box">
<div id="heading">
	WORKFLOW MANAGEMENT
</div>
<h2 style="text-align: center;"><br><br><br><br><br>Add User</h2>
	<s:form action="add_user.action" method="post">
		<s:select label="Select prefix" headerKey="-1"
			headerValue="Select prefix"
			list="prefixList"
			name="prefix" value="%{AddUser.prefix}"/>
		<s:textfield name="fname" label="First Name" value="%{AddUser.fname}" size="30" />
		<s:textfield name="lname" label="Last Name" value="%{AddUser.lname}" size="30" />
		<s:select label="Select sex" headerKey="-1"
			headerValue="Select sex"
			list="sexList"
			name="sex" value="%{AddUser.sex}" />
		<s:textfield name="dob" label="DoB(yyyy-mm-dd)" size="30" value="%{AddUser.dob}" />
		<s:textfield name="address" label="Address" size="100" value="%{AddUser.address}"/>
		<s:textfield name="country" label="Country" size="30" value="%{AddUser.country}"/>
		<s:textfield name="phone" label="Phone no." size="30" value="%{AddUser.phone}"/>
		<s:textfield name="email" label="Email ID" size="30" value="%{AddUser.email}"/>
		<button type="submit" value="Create" name="buttonName">Create</button>
		<button type="submit" value="Back" name="buttonName">Back</button>
		<s:actionerror />
		<s:actionmessage/>
	</s:form>
	</div>
</body>
</html>