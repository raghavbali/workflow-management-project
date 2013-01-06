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
<div id="box">
<div id="heading">
	WORKFLOW MANAGEMENT
</div>
<div id="edit_user_basic">
<h2>Edit User Basic</h2>
	<s:form action="update_user_basic.action" method="post">
		<s:hidden name="p_id"/>
		<s:select label="Select prefix" headerKey="-1"
			headerValue="Select prefix"
			list="prefixList"
			name="prefix" value="%{tmpuser.getPrefix()}"/>
		<s:textfield name="fname" label="First Name" value="%{tmpuser.getFname()}" size="30" />
		<s:textfield name="lname" label="Last Name" value="%{tmpuser.getLname()}" size="30" />
		<s:select label="Select sex" headerKey="-1"
			headerValue="Select sex"
			list="sexList"
			name="sex" value="%{tmpuser.getSex()}" />
		<s:textfield name="dob" label="DoB(yyyy-mm-dd)" size="30" value="%{tmpuser.getDob()}" />
		<s:textfield name="address" label="Address" size="100" value="%{tmpuser.getAddress()}"/>
		<s:textfield name="country" label="Country" size="30" value="%{tmpuser.getCountry()}"/>
		<s:textfield name="phone" label="Phone no." size="30" value="%{tmpuser.getPhone()}"/>
		<s:textfield name="email" label="Email ID" size="30" value="%{tmpuser.getEmail()}"/>
		<s:submit name = "button1" value = "Edit" align="center" />
		<s:actionerror />
		<s:actionmessage/>
	</s:form>
	</div>
	</div>
</body>
</html>