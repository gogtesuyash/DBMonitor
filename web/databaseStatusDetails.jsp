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
    <title>Database Monitoring</title>
	
  <style>
	.blank_row
	{
		height: 18px;
		background-color: #FFFFFF;
	}
	.left-margin
	{
		margin-left:210px;
	}
	.small-left-margin
	{
		padding-left:115px;
	}
	.large-left-margin
	{
		padding-left:215px;
	}
  </style>
</head>
<form name="databaseDetails" action="StatusController" method="POST">
<div id="right" style="width:100;" >
<script>
	databasesList=[];
</script>
<script  type="text/javascript">
	function set()
	{
		var i;
		var combo = document.getElementById("hostname");
		var val = combo.options[combo.selectedIndex].value;
		for(i=0;i<databasesList.length;i++)
			{
				if(databasesList[i].id==val)
					{
							document.getElementById('dbType').value=databasesList[i].dbType;
							document.getElementById('platform').value=databasesList[i].platform;
							document.getElementById('dbName').value=databasesList[i].dbName;
					}
			}
		
	}
</script>
<div id='cssmenu'>
<ul>
 <li><a href='/DBMonitor/index.jsp'><span>Home</span></a></li>
   <li  class='active'><a href='/DBMonitor/StatusController'><span>Monitor</span></a></li>
   <li><a href='/DBMonitor/Reports'><span>Reports</span></a></li>
   <li><a href='/DBMonitor/DBController?action=listDatabase'><span>Register</span></a></li>
   <li><a href='/DBMonitor/Schedular'><span>Schedular</span></a></li>
</ul>
</div>
<table >
<tr>
<td width="70%;">
<table class="left-margin"  height="50px">
<tr>
<td colspan="3"><h1>Database Monitoring</h1></td>
<td colspan="2">
<img src="images/monitor.jpg" width="70px" height="50px"/></td>
</tr>
<tr>
<td>
<img src="images/mysql.jpg" width="70px" height="50px" /></td>
<td>
<img src="images/mssql.jpg" width="70px" height="50px"/></td>
<td>
<img src="images/oracle.jpg" width="70px" height="50px"/></td>
<td>
<img src="images/windows.jpg" width="70px" height="50px"/></td>
<td>
<img src="images/linux.jpg" width="70px" height="50px"/></td>
</table>
</td>
<td rowspan="2" width="30%">
<table style="border: 2px solid #a1a1a1;padding: 10px 40px; background: #dddddd;border-radius: 25px;">
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
				1. <b>Database Details:</b> - It will provide version,host name and other details.
		</td>
		</tr>
		<tr>
		<td>
			   2. <b>Database Status :</b>Status of database service.
		</td>	
		</tr>
		<tr>
		<td>
			3. <b>Disk space consumption :</b>It will provide details of space comsumed by database on disk.
		</td>	
		</tr>
		<tr>
		<td>
			4. <b>Locks :</b> It will provide list of locks acquired in database.
		</td>	
		</tr>
		<tr>
		<td>
			5. <b>CPU usage :</b> It will provide CPU consumption on host.
		</td>	
		</tr>
		<tr>
		<td>
			6. <b>Memory usage :</b>It will provide memory consumed on host.
		</td>	
		</tr>
		</table>
</td>
</tr>

<br/>
<br/>
<tr>
<td width="70%;">
<table  class="left-margin">
	<tr class="blank_row">
	</tr>
		
	<tr class="blank_row">
	</tr>
	<tr class="blank_row">
	</tr>
			
	<tr>
		<td>
			Host Name :
		</td>
		<td>
			
			<select id="hostname" name="hostname" onchange="set()">
				<c:forEach items="${databases}" var="database">
					<option value="${database.id}">
						<c:out value="${database.hostName}"/>
					</option>
				<script>
					var database = new Object();
					database.id = '<c:out value="${database.id}"/>';
					database.dbName = '<c:out value="${database.dbName}"/>';
					database.port = '<c:out value="${database.port}" />';
					database.userName = '<c:out value="${database.userName}" />';
					database.password = '<c:out value="${database.password}" />';
					database.dbType = '<c:out value="${database.dbType}" />';
					database.platform = '<c:out value="${database.platform}" />';
					databasesList.push(database);
				</script>
				</c:forEach>
			</select>
		</td>
		<td rowspan="4" class="small-left-margin">
			<input type="radio" name="operations" value="1">Database Details<br>
			<input type="radio" name="operations" value="2">Current database status<br>
			<input type="radio" name="operations" value="3">Total database size<br>
			<input type="radio" name="operations" value="4">Table space status <br>
			<input type="radio" name="operations" value="5">Total database users<br>
			<input type="radio" name="operations" value="6">Server disk space consumption growth<br>
			<input type="radio" name="operations" value="7">Server CPU Usage<br>
			<input type="radio" name="operations" value="8">Server/Database memory usage <br>
			<input type="radio" name="operations" value="9">Locks in database<br>
		</td>
	</tr>
	<tr>
		<td>
			Database Name :
		</td>
		<td>
			<input type="text" id="dbName" name="dbName" value=""  />
		</td>
	</tr>
	<tr>
		<td>
			Database Type :
		</td>
		<td>
			<input type="text" id="dbType" name="dbType" value=""  />
		</td>
	</tr>
	<tr>
		<td>
			Platform :
		</td>
		<td>
			<input type="text" id="platform" name="platform" value=""  />
		</td>
	</tr>
	<tr class="blank_row">
	</tr>
	<tr class="blank_row">
		</tr>
	<tr>
		<td></td><td></td>
		<td>
			<input type="submit" value="submit" />
		</td>
	</tr>
	
</table>
</td>
</tr>
</table>
</form>
</html>