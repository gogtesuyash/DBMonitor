<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset='utf-8'>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="styles.css">
  <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
  <script src="script.js"></script>
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <title>Add New User</title>
  <style>
	.blank_row
	{
		height: 18px;
		background-color: #FFFFFF;
	}
	.left-margin
	{
		margin-left:110px;
	}
	.small-left-margin
	{
		padding-left:115px;
	}
	.large-left-margin
	{
		padding-left:215px;
	}
div.left {
width: 10%; 
padding: 0 0 0 5%;
float: left}

div.content {
width: 40%;
padding: 0 5%;
float: left}

div.right {
width: 25%; 
padding: 0 5% 0 0;
float: left}
 
  </style>
</head>
<body>
	<div id='cssmenu'>
	<ul>
		<li><a href='/DBMonitor/index.jsp'><span>Home</span></a></li>
		<li><a href='/DBMonitor/StatusController'><span>Monitor</span></a></li>
		<li><a href='/DBMonitor/Reports'><span>Reports</span></a></li>
		<li class='active'><a href='/DBMonitor/DBController?action=listDatabase'><span>Register</span></a></li>
		<li><a href='/DBMonitor/Schedular'><span>Schedular</span></a></li>
	</ul>
</div>

	<br>
	<br>
	<br>
	
    <form method="POST" action='DBController' name="frmAddDatabase">
	<div class="left">
	<img src="images/database.jpg" width="200px" height="200px" />
	</div>
	<div class="content">
	
		<table class="left-margin">
		<tr>
				<td>ID : </td>
				<td class="small-left-margin"><input type="text" readonly="readonly" name="id" value="<c:out value="${database.id}" />"  /> </td>
		</tr>
		<tr class="blank_row">
		</tr>
		<tr>
				<td>Host Name : </td>
				<td class="small-left-margin"><input type="text" name="hostName" value="<c:out value="${database.hostName}"/>" /></td>
		</tr>
		<tr class="blank_row">
		</tr>
		<tr>
				<td>Platform : </td>
				
				<td class="small-left-margin">
						<select id="platform" name="platform">
  								<option value="Windows">Windows</option>
  								<option value="Linux">Linux</option>
  						</select>
  				</td>
				<c:choose>
  					<c:when test="${database.platform=='Windows'}">
    					<script>
    						document.getElementById("platform").selectedIndex = 0;
    					</script>	
  					</c:when>
  					<c:otherwise>
    						<script>
    						document.getElementById("platform").selectedIndex = 1;
    						</script>
  					</c:otherwise>
				</c:choose>
		</tr>
		<tr class="blank_row">
		</tr>
		<tr>
				<td>DB Type : </td>
				<td class="small-left-margin">
						<select id="dbType" name="dbType">
  								<option value="MySQL">MySQL</option>
  								<option value="Oracle">Oracle</option>
  								<option value="SqlServer">SqlServer</option>
  						</select>
  				</td>
				<c:choose>
  					<c:when test="${database.dbType=='MySQL'}">
    					<script>
    						document.getElementById("dbType").selectedIndex = 0;
    					</script>	
  					</c:when>
  					<c:when test="${database.dbType=='Oracle'}">
    						<script>
    							document.getElementById("dbType").selectedIndex = 1;
    						</script>
  					</c:when>
  					<c:otherwise>
    						<script>
    							document.getElementById("dbType").selectedIndex = 2;
    						</script>
  					</c:otherwise>
				</c:choose>
		</tr>
		<tr class="blank_row">
		</tr>
		<tr>
				<td>DB Name : </td>
				<td class="small-left-margin"><input type="text" name="dbName" value="<c:out value="${database.dbName}"/>" /></td>
		</tr>
		<tr class="blank_row">
		</tr>
		<tr>
				<td>Port : </td>
				<td class="small-left-margin"><input type="text" name="port" value="<c:out value="${database.port}"/>" /> </td>
		</tr>
		<tr class="blank_row">
		</tr>
		<tr>
				<td>User Name : </td>
				<td class="small-left-margin"><input type="text" name="userName" value="<c:out value="${database.userName}" />" /></td>
		</tr>
		<tr class="blank_row">
		</tr>
		<tr>
				<td>Password : </td>
				<td class="small-left-margin"><input type="password" name="password" value="<c:out value="${database.password}" />" /></td>
		</tr>
		<tr class="blank_row">
		</tr>
		<tr>
				<td></td><td><input type="submit" value="Submit" /></td>
		</tr>
		
		</table>
		</div>
		<div class="right" style="border: 2px solid #a1a1a1;padding: 10px 40px; background: #dddddd;border-radius: 25px;">
		<table>
		<tr>
		<td>
		<b>
		Instructions :
		</b>
		</td>
		</tr>
		<tr>
		<td>
		Below are few details
		</td>
		</tr>
		<tr>
		<td>
				1. <b>Host Name :</b> - machine on which database service is running
		</td>
		</tr>
		<tr>
		<td>
			   2. <b>Platform :</b>Operating System type of host which is running database service.
		</td>	
		</tr>
		<tr>
		<td>
			3. <b>Database Type :</b>vendor who is providing database management service
		</td>	
		</tr>
		<tr>
		<td>
			4. <b>Database Name :</b> database instance name which needs to be monitored.
		</td>	
		</tr>
		<tr>
		<td>
			5. <b>Port :</b> Port No. on which service is running.
		</td>	
		</tr>
		<tr>
		<td>
			6. <b>Username/Password :</b> Credentials to be used to connect database
		</td>	
		</tr>
		</table>
		</div>
    </form>
	
</html>