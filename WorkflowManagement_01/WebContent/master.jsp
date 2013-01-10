<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="slideshow.js" type="text/javascript"></script>
    <script src="jquery-1.8.3.js" type="text/javascript"></script>
</head>
<body>
	<!--  <div id="box">-->
		

		<div id="heading">WORKFLOW MANAGEMENT</div>
		<div id="menu">
			<ul>
				<s:if test="%{#session['role']=='admin'}">
					<li><a href="backToAdminConsole.action">Home</a>
					</li>
				</s:if>
				<s:elseif test="%{#session['role']=='author'}">
					<li><a href="authorAction.action">Home</a>
					</li>
				</s:elseif>
				<s:elseif test="%{#session['role']=='publisher'}">
					<li><a href="publisherAction.action">Home</a>
					</li>
				</s:elseif>
				<s:elseif test="%{#session['role']=='editor'}">
					<li><a href="doneEditorConsole.action">Home</a>
					</li>
				</s:elseif>
				<li><a href="#">About US</a>
				</li>
				<li><a href="logoutAdminConsole.action">Logout</a>
				</li>
			</ul>
		</div>
</body>
</html>