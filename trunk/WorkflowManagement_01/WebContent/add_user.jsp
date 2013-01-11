<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sx:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin page - Add User</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="slideshow.js" type="text/javascript"></script>
<script src="jquery-1.8.3.js" type="text/javascript"></script>
<script src="validation.js"></script>  
</head>
<body onload="document.add_user.prefix.focus();">

	<%@include file="master.html"%>
	<s:form name="add_user" action="add_user.action" method="post" onSubmit="return checkform(buttonIndex);">
		<h2 style="text-align: center;">Add User</h2>
		<table>
			<tr>
				<th><s:actionerror /><div id="loginmandatory" style="color:red"></div>
				</th>
				<th><s:actionmessage />
				</th>
			</tr>
			<tr>
				<td>Prefix</td>
				<td align="left"><s:select label="Select prefix" list="prefixList" name="prefix"
						id="prefix" value="%{AddUser.prefix}" required="true"/></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td align="left"><s:textfield name="fname" label="First Name"
						value="%{AddUser.fname}" size="30" placeholder="First Name" id="fname" required="true"/>
				</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><s:textfield name="lname" id="lname" placeholder="Last Name" label="Last Name"
						value="%{AddUser.lname}" size="30" />
				</td>
			</tr>
			<tr>
				<td>Select Sex</td>
				<td align="left"><s:select label="Select sex" 
						 list="sexList" name="sex"
						value="%{AddUser.sex}" />
				</td>
			</tr>
			<tr><td>Date of Birth</td>
				<td><sx:datetimepicker name="dob" id="dob" required="true" 
						displayFormat="yyyy-MM-dd" value="%{AddUser.dob}" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><s:textfield name="address" id="address" placeholder="address" label="Address" size="100"
						value="%{AddUser.address}" />
				</td>
			</tr>
			<tr>
				<td>Country</td>
				<td><s:textfield name="country" id="country" placeholder="country" label="Country" size="30"
						value="%{AddUser.country}" />
				</td>
			</tr>
			<tr>
				<td>Phone No</td>
				<td><s:textfield name="phone" id="phone" placeholder="phone"  label="Phone no." size="30"
						value="%{AddUser.phone}" />
				</td>
			</tr>
			<tr>
				<td>Email ID</td>
				<td><s:textfield name="email" id="email" placeholder="email" label="Email ID" size="30"
						value="%{AddUser.email}" />
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Create" name="buttonName"  id="buttonName" onclick="buttonIndex=1;"/>
				</td>
				<td><input type="submit" value="Back" name="buttonName" id="buttonName" onclick="buttonIndex=2;"/>
				</td>
			</tr>
		</table>
	</s:form>
	</div>
</body>
</html>