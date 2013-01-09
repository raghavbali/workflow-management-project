<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link href="js-image-slider.css" rel="stylesheet" type="text/css" />
<script src="js-image-slider.js" type="text/javascript"></script>
<link href="generic.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="box">
		<div id="sliderFrame">
			<div id="ribbon"></div>
			<div id="slider">
				<img src="images/image-slider-2.jpg" /> <img
					src="images/image-slider-3.jpg" /> <img
					src="images/image-slider-4.jpg" /> <img
					src="images/image-slider-5.jpg" />
			</div>

		</div>

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