<!doctype html>
<html lang=''>
<head>
   <meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="styles.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="script.js"></script>
   <title>DBMonitor</title>
   <style>
		.richtextarea ul {
			list-style-type: disc;
			margin-left: 20px;
			margin-top: 10px;
		}
		.richtextarea ul li {
			margin-bottom: 4px;
		}
		h2 {
			font-size: 36px;
			margin-left:150px;
		}
		h1, h2 {
			color: #767676;
			font-family: "Core Sans Regular","Helvetica","Arial",sans-serif;
			margin-left:150px;
		}
		h3 {
			font-size: 24px;
			margin-left:150px;
		}
		h3, h4, h5 {
				font-family: "Core Sans Bold","Helvetica","Arial",sans-serif;
				margin-left:150px;
		}
		p{
			margin-left:150px;
		}
	</style>
</head>
<body>

<div id='cssmenu'>
<ul>
  <li class='active'><a href='/DBMonitor/index.jsp'><span>Home</span></a></li>
   <li><a href='/DBMonitor/StatusController'><span>Monitor</span></a></li>
   <li><a href='/DBMonitor/Reports'><span>Reports</span></a></li>
   <li><a href='/DBMonitor/DBController?action=listDatabase'><span>Register</span></a></li>
   <li><a href='/DBMonitor/Schedular'><span>Schedular</span></a></li>
</ul>
</div>
<div class="richtextarea">
<h2>Solutions</h2>
<h1>Database Performance Monitoring</h1>
<p>More than half of application performance bottlenecks originate in the database, but most application teams have little or no visibility into database performance. With "DBMonitor" database monitoring tool, you get 100% visibility into application performance, from the browser to the database.</p>
<h3>Key Benefits</h3>
<ul style="margin-left:150px">
<li>Visualize end-to-end application performance, from the browser to the database</li>
<li>User or administrator can take action if database thresholds are violated</li>
<li>Monitor key performance metrics like top users, programs, SQL, objects and more.</li>
</ul>

<h3>Trend Database Performance Over Time</h3>
<img src="images/report.png" alt height = "185"  width="540" style="margin-left:150px;"/>
<p>With "DBMonitor" database monitoring tool, you can monitor and trend key performance metrics such as resource consumption, database objects, schema statistics and more, allowing you to proactively tune and fix issues before they affect end users.</p>

<h3>Troubleshoot Performance Issues in a Production Environment</h3>
<p>DBMonitor's fine-grained historical data offers applications teams the ability to retroactively troubleshoot and diagnose the root cause of database-related performance issues – in a live production environment.</p>
</div>
</body>
<html>
