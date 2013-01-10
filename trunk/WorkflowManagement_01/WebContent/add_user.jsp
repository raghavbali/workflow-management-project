<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sx:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin page - Add User</title>
<link rel="stylesheet" type="text/css" href="style.css">
<!--<script src="validation.js"></script>  onSubmit="return addUserValidation();"-->
</head>
<body onload="document.add_user.prefix.focus();">

<%@include file="master.html" %>
	<s:form name="add_user" action="add_user.action" method="post"  >
		<h2 style="text-align: center;">Add User</h2>
		<table>
		<tr><th><s:actionerror /></th><th><s:actionmessage/></th></tr>
		<tr>
		<td>Prefix</td>
		<td align="left"><s:select label="Select prefix" headerKey="-1"
			headerValue="Select prefix"
			list="prefixList"
			name="prefix" value="%{AddUser.prefix}"/>
			</td></tr>
		<tr><td>First Name</td><td align="left"><s:textfield name="fname" label="First Name" value="%{AddUser.fname}" size="30" /></td></tr>
		<tr><td>Last Name</td><td><s:textfield name="lname" label="Last Name" value="%{AddUser.lname}" size="30" /></td></tr>
		<tr><td>Select Sex</td><td align="left"><s:select label="Select sex" headerKey="-1"
			headerValue="Select sex"
			list="sexList"
			name="sex" value="%{AddUser.sex}" /></td></tr>
		<tr><td>DOB</td><td><s:textfield name="dob" label="DoB(yyyy-mm-dd)" size="30" value="%{AddUser.dob}" />
		
		<sx:datetimepicker name="dob" label="Date of Birth" 
displayFormat="yyyy-MM-dd" value="%{'2010-01-01'}"/></td></tr>
		
		<tr><td>Address</td><td><s:textfield name="address" label="Address" size="100" value="%{AddUser.address}"/></td></tr>
		<tr><td>Country</td><td><s:textfield name="country" label="Country" size="30" value="%{AddUser.country}"/></td></tr>
		<tr><td>Phone No</td><td><s:textfield name="phone" label="Phone no." size="30" value="%{AddUser.phone}"/></td></tr>
		<tr><td>Email ID</td><td><s:textfield name="email" label="Email ID" size="30" value="%{AddUser.email}"/></td></tr>
		<tr><td><button type="submit" value="Create" name="buttonName">Create</button></td>
		<td><button type="submit" value="Back" name="buttonName">Back</button></td></tr>
		</table>		
	</s:form>
	</div>
</body>
</html>