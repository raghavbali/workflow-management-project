<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Flux Help</title>
<script src="slideshow.js" type="text/javascript"></script>
<script src="jquery-1.8.3.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
	<%@include file="master.html"%>
	<div id="flux_help">
		<h3>
			<u>FLUX&nbsp;&nbsp;&nbsp;Help</u>
		</h3>
		At FLUX, we believe <b>"Knowing is Believing"</b><br /> <br />
		<ul>
			<li><a href="#Flux">Understand Flux</a>
			</li>
			<li><a href="#Admin">Help for Admins</a>
			</li>
			<li><a href="#Editor">Help for Project Managers (Editors)</a>
			</li>
			<li><a href="#Publisher">Help for Team Leads (Publisher)</a>
			</li>
			<li><a href="#Author">Help for Users (Authors)</a>
			</li>
		</ul>
		<br /> <br /> <br /> <br /> <br /> <br /> <br />
		<ul>
			<a id="Flux"><h3>Understand Flux</h3> </a> Flux is a Workflow
			Management System. It is designed with deep care to meet the demands
			of your business.
			<br /> It is designed to suite work/process flows across industries.
			The following are the main features :
			<br />
			<br />
			<ul>
				<li><b>Each FLUX workflow consists of :</b>
					<ol>
						<li>Workflow (one of the 4 domains)</li>
						<li>Workflow Stages : Flux allows workflows to have any
							number of stages to support your project need</li>
						<li>Workflow Participants : Flux supports four different user
							roles. What's more, each user can have multiple roles !!!</li>
						<li>Workflow items : An item represents an entity that flows
							through the workflow. You can add loads of information and be
							rest assured that it is tracked</li>
						<li>Buckets : Each <i>Publisher</i> and <i>Author</i> is
							presented with a personal item bucket to display the items
							assigned, finished etc.</li>
					</ol></li>
				<br />
				<li><b>Workflow support for 4 main domains :</b><br />
					<ol>
						<li>IT Projects</li>
						<li>Manufacturing</li>
						<li>Delivery</li>
						<li>E-Gov</li>
					</ol></li>
				<br />
				<li><b>Each Workflow has 4 main participants :</b>
				<ol>
					<li><b>Admin :</b> To administer the workflow (see <a
						href="#Admin">admin help</a> for further details)</li>
					<li><b>Editor:</b> This role represents the Project Manager
						(see <a href="#Admin">editor help</a> for further details)</li>
					<li><b>Publisher:</b> This role represents the Team Lead (see
						<a href="#Publisher">publisher help</a> for further details)</li>
					<li><b>Author:</b> This role represents the participant at
						each stage of the workflow (see <a href="#Author">author help</a>
						for further details)</li>
				</ol>
				</li>
				<br />
			</ul>

			<a id="Admin"><h3>Admin Help</h3> </a>
			<ul>
				<b><li>Responsiblities</li>
				</b>
				<ol>
					<li>To add/edit stages to the workflow</li>
					<li>To add/edit users to the workflow</li>
					<li>Assign/edit roles</li>
					<li>To assist in overall workflow management</li>
				</ol>
				<br/>
				<b><li>Edit Workflow:</li>
				</b>
				<ol>
					<li>Login using your username and password</li>
					<li>Go to <i>Edit Workflow</i>
					</li>
					<li>Select <i>Workflow Modifications</i> for the respective
						workflow</li>
					<li>Update Workflow Details like <i>Name,Description,etc</i> and click <i>Save Changes</i>
					</li>
					<li>Note: You can only delete a workflow only if its <i><b>Freeze status is set to N</b></i></li>
				</ol>
				<br />
				<b><li>Adding stages:</li>
				</b>
				<ol>
					<li>Login using your username and password</li>
					<li>Go to <i>Edit Workflow</i>
					</li>
					<li>Select <i>Stage Modifications</i> for the respective
						workflow</li>
					<li>Select <i>Add Stage</i>
					</li>
					<li>Add Stage Details like <i>Name,Description,SLA(in
							days),etc</i> and click <i>Add Stage</i>
					</li>
				</ol>
				<br />
				<b><li>Edit stages:</li>
				</b>
				<ol>
					<li>Login using your username and password</li>
					<li>Go to <i>Edit Workflow</i>
					</li>
					<li>Select <i>Stage Modifications</i> for the respective
						workflow</li>
					<li>Select <i>Modify Stage</i> for the required stage
					</li>
					<li>Edit Stage Details like <i>Name,Description,SLA(in
							days),etc</i> and click <i>Add Stage</i>
					</li>
					<li>Note : You can only delete a stage till either workflow is not frozen or there are no Items in the workflow</li>
				</ol>
				<br />
				<b><li>Add User:</li>
				</b>
				<ol>
					<li>Login using your username and password</li>
					<li>Go to <i>Add User</i>
					</li>
					<li>Add User Details and click <i>Create</i>
					</li>
				</ol>
				<br />
				<b><li>Edit User/ Assign Role:</li>
				</b>
				<ol>
					<li>Login using your username and password</li>
					<li>Go to <i>Edit User</i>
					</li>
					<li>Select <i>Edit/Assign</i> for the respective
						User</li>
					<li>Update the details or assign a role
					</li>
				</ol>
			</ul>
			<a id="Editor"><h3>Editor Help</h3> </a>
			<ul>
				<b><li>Responsiblities</li>
				</b>
				<ol>
					<li>To assign users to different stages</li>
					<li>To create/edit Items/li>
					<li>To Push Items</li>
					<li>To edit user roles/profiles</li>
					<li>To Generate reports</li>
				</ol>
				<br/>
				<b><li>Stage Assignment:</li>
				</b>
				<ol>
					<li>Login using your username and password</li>
					<li>Go to <i>Stage Assignment</i>
					</li>
					<li>Select <i>Assign Users</i> for the respective
						Stage</li>
					<li>Choose a publisher and any number of authors for the stage in consideration
					</li>
				</ol>
				<br />
				<b><li>Create Item:</li>
				</b>
				<ol>
					<li>Login using your username and password</li>
					<li>Go to <i>Edit Workflow</i>
					</li>
					<li>Select <i>Create Item</i> for the respective
						workflow</li>
					<li>Add Stage Details like <i>Name,Description,etc</i> and click <i>Add</i>
					</li>
				</ol>
				<br />
				<b><li>Modify Item:</li>
				</b>
				<ol>
					<li>Login using your username and password</li>
					<li>Go to <i>Edit Item</i>
					</li>
					<li>Select <i>Edit Item</i> for the respective
						workflow</li>
					<li>Select <i>Modify Item</i> for the required item
					</li>
					<li>Edit Item Details like <i>Name,Description,etc</i> and click <i>Save</i>
					</li>
					<li>Note : You can only delete an item only till it has not been pushed</li>
				</ol>
				<br />
				<b><li>Push Item</li>
				</b>
				<ol>
					<li>Login using your username and password</li>
					<li>Go to <i>Edit Item</i>
					</li>
					<li>Push the item you want the work to start on.
					</li>
					<li>After <i>Pushing</i>, the item is pushed to 1st Stage's Publisher Bucket.
					</li>
				</ol>
				<br />
				<b><li>Configure User:</li>
				</b>
				<ol>
					<li>Login using your username and password</li>
					<li>Go to <i>Configure User</i>
					</li>
					<li>Select <i>Edit/Assign</i> for the respective
						User</li>
					<li>Update the details or assign a role
					</li>
				</ol>
				<br />
				<b><li>Generate Reports</li>
				</b>
				<ol>
					<li>Login using your username and password</li>
					<li>Go to <i>Generate Reports</i>
					</li>
					<li>Select <i>SLA Report</i>,<i>Item Status Report</i> or <i>Resource Allocation Report</i></li>
					<li>The reports are generated in the Workflow Reports folder
					</li>
				</ol>
			</ul>
			<a id="Publisher"><h3>Publisher Help</h3> </a>
			<ul>
				<b><li>Responsiblities</li>
				</b>
				<ol>
					<li>To Delegate work items to different authors</li>
					<li>To Move Items forward/backward/li>
				</ol>
				<br/>
				<b><li>Delegate Work:</li>
				</b>
				<ol>
					<li>Login using your username and password</li>
					<li>Select <i>Delegate</i> for the respective
						Item</li>
					<li>Choose any number of authors for the item in consideration and click Delegate
					</li>
				</ol>
				<br />
				<b><li>Move Item:</li>
				</b>
				<ol>
					<li>Login using your username and password</li>
					<li>Select <i>Move Forward</i> if the item status is C (Complete)</li>
					<li>Select <i>Move Backward</i> if the item status is P (Partial)</li>
				</ol>
			</ul>
			<a id="Author"><h3>Author Help</h3> </a>
				<ul>
				<b><li>Responsiblities</li>
				</b>
				<ol>
					<li>To update Item Status and Remarks</li>
				</ol>
				<br/>
				<b><li>Update Item:</li>
				</b>
				<ol>
					<li>Login using your username and password</li>
					<li>Select <i>Update Item</i> for the respective
						Item</li>
					<li>Update the item remarks and set status to I(Incomplete),C(Complete) or P(Partial-to send to previous stage)
					</li>
				</ol>
				<br />
				<b><li>Move Item:</li>
				</b>
				<ol>
					<li>Login using your username and password</li>
					<li>Select <i>Move Forward</i> if the item status is C (Complete)</li>
					<li>Select <i>Move Backward</i> if the item status is P (Partial)</li>
				</ol>
			</ul>
		</ul>
	</div>
	</div>
</body>
</html>