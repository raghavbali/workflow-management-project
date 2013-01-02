<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin page - Assign Role</title>
</head>
<body>
<h2>Assign Role</h2>
	<table>
	<tr>
	    <th><h3>P_ID</h3></th>
	    <th><h3>Prefix</h3></th>
	    <th><h3>First Name</h3></th>
	    <th><h3>Last Name</h3></th>
	</tr>
	<s:iterator value = "usrlist">
	<tr>
		<td><s:property value="p_id"/></td>
		<td><s:property value="prefix"/></td>
		<td><s:property value="fname"/></td>
		<td><s:property value="lname"/></td>
		<td><a href="edit_user_basic?p_id=<s:property value="p_id"/>">Edit</a></td>
		<td><a href="continue_role_assign?p_id=<s:property value="p_id"/>">User roles</a></td>
<!-- 	<td><h3><img src="./images/<s:property value="image_url"/>" alt="image text"/> </h3></td>
		<td><h3> <a href="modify_book?book_id=<s:property value="Id"/>">Modify</a></h3> </td>
		<td><h3> <a href="buy_book?book_id=<s:property value="Id"/>">Buy</a></h3> </td>			-->
	</tr>
	</s:iterator>
	<tr><td>
	<h2 align="left"><a href="back_from_assignrole" id="mysubmit">Button1</a></h2>
	</td>
<!-- <td></td><td></td><td></td><td></td><td></td><td></td>
	<td>
	<h2 align="right"><a href="admin" id="mysubmit">Logout</a></h2>
	</td>		-->
	</tr>
	</table>
</body>
</html>