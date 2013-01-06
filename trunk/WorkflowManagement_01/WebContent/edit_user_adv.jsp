<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit User Advanced</title>
<link rel="stylesheet" type="text/css" href="style.css">
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
<div id="edit_user_adv">
<h2>Edit User Advanced</h2>
	<s:form action="update_user_adv.action" method="post">
		<s:hidden name="user_id"/>
		<s:hidden name="p_id" value="%{tmpuser.getP_id()}"/>
		<s:hidden name ="active_flag" value="%{tmpuser.getActive_flag()}"/>
		<s:hidden name="pageName" value="%{pageName}"/>
		<s:hidden name="workflowID" />
		<s:select label="Select Workflow" headerKey="-1"
			headerValue="Select Workflow"
			list="wfList"
			name="w_id" value="%{tmpuser.getW_id()}"/>
		<s:select label="Select Role" headerKey="-1"
			headerValue="Select Role"
			list="roleList"
			name="role" value="%{tmpuser.getRole()}"/>
		<s:textfield name="username" label="User Name" value="%{tmpuser.getUsername()}" size="30" />
		<s:textfield name="password" label="Password" value="%{tmpuser.getPassword()}" size="30" />
		<s:select label="Is active?" headerKey="-1"
			headerValue="Select active state"
			list="actstateList"
			name="selected_actstate" value="%{tmpuser.getActive_flag()}"/>
		<s:actionerror />
		<s:actionmessage/>
		<s:submit name = "commandButton" id="mysubmit" value="Edit role" align="center" />
	</s:form>
	</div>
	</div>
</body>
</html>