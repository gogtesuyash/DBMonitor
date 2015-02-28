<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset='utf-8'>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles.css">
<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
<script src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Database Monitoring</title>

<style>
.blank_row {
	height: 18px;
	background-color: #FFFFFF;
}

.left-margin {
	margin-left: 210px;
}

.small-left-margin {
	padding-left: 115px;
}

.large-left-margin {
	padding-left: 215px;
}

.tsc_tables2_0 {
	background: none repeat scroll 0 0 #fefefe;
	border: 1px solid #d3d3d3;
	border-radius: 5px;
	font-size: 12px;
	margin-bottom: 10px;
	overflow: hidden;
	width: 70%;
	margin-left: 110px;
}

.tsc_tables2_0 th,td {
	padding: 18px 28px;
	text-align: center;
}

.tsc_tables2_0 th {
	background: none repeat scroll 0 0 #e8eaeb;
	padding-top: 22px;
	text-shadow: 1px 1px 1px #fff;
}

.tsc_tables2_0 td {
	border-right: 1px solid #e0e0e0;
	border-top: 1px solid #e0e0e0;
}

.tsc_tables2_0 tr.odd-row td {
	background: none repeat scroll 0 0 #f6f6f6;
}

.tsc_tables2_0 td.first,th.first {
	text-align: left;
}

.tsc_tables2_0 td.last {
	border-right: medium none;
}

.tsc_tables2_0 td {
	background: -moz-linear-gradient(100% 25% 90deg, #fefefe, #f9f9f9)
		repeat scroll 0 0 rgba(0, 0, 0, 0);
}

.tsc_tables2_0 tr.odd-row td {
	background: -moz-linear-gradient(100% 25% 90deg, #f6f6f6, #f1f1f1)
		repeat scroll 0 0 rgba(0, 0, 0, 0);
}

.tsc_tables2_0 th {
	background: -moz-linear-gradient(100% 20% 90deg, #e8eaeb, #ededed)
		repeat scroll 0 0 rgba(0, 0, 0, 0);
}

.tsc_tables2_0 tr:first-child th.first {
	
}

.tsc_tables2_0 tr:first-child th.last {
	
}

.tsc_tables2_0 tr:last-child td.first {
	
}

.tsc_tables2_0 tr:last-child td.last {
	
}

.tsc_tables2_1 {
	background: none repeat scroll 0 0 #fff;
	border-collapse: collapse;
	font-size: 12px;
	text-align: left;
	width: 480px;
}

.tsc_tables2_1 th {
	border-bottom: 2px solid #ccc;
	color: #333;
	font-size: 14px;
	font-weight: normal;
	padding: 10px;
}

.tsc_tables2_1 td {
	color: #666;
	padding: 5px;
}

.tsc_tables2_1 tbody tr:hover td {
	background-color: #f5fbff;
	border-bottom: 1px dotted #ccc;
	border-top: 1px dotted #ccc;
	box-shadow: 0 1px 4px 1px #eee;
	color: #333;
}

.tsc_tables2_2 {
	background: none repeat scroll 0 0 #fff;
	border-collapse: collapse;
	font-size: 12px;
	text-align: left;
	width: 480px;
}

.tsc_tables2_2 th {
	border-bottom: 2px solid #ccc;
	color: #333;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 8px;
}

.tsc_tables2_2 td {
	border-bottom: 1px solid #ccc;
	color: #666;
	padding: 6px 8px;
}

.tsc_tables2_2 tbody tr:hover td {
	background-color: #f5fbff;
	border-bottom: 1px dotted #ccc;
	border-top: 1px dotted #ccc;
	box-shadow: 0 1px 4px 1px #eee;
	color: #333;
}

.tsc_tables2_3 {
	background: none repeat scroll 0 0 #fff;
	border-collapse: collapse;
	font-size: 12px;
	text-align: left;
	width: 480px;
}

.tsc_tables2_3 th {
	border-bottom: 2px solid #ccc;
	border-left: 30px solid #fff;
	border-right: 30px solid #fff;
	color: #333;
	font-size: 14px;
	font-weight: normal;
	padding: 8px 2px;
}

.tsc_tables2_3 td {
	border-left: 30px solid #fff;
	border-right: 30px solid #fff;
	color: #666;
	padding: 6px;
}

.tsc_tables2_3 tbody tr:hover td {
	border-bottom: 1px dotted #ccc;
	color: #333;
}

.tsc_tables2_4 {
	border-collapse: collapse;
	font-size: 12px;
	text-align: left;
	width: 480px;
}

.tsc_tables2_4 th {
	-moz-border-bottom-colors: none;
	-moz-border-left-colors: none;
	-moz-border-right-colors: none;
	-moz-border-top-colors: none;
	background: -moz-linear-gradient(center bottom, rgb(201, 201, 201) 20%,
		rgb(231, 231, 231) 80% ) repeat scroll 0 0 rgba(0, 0, 0, 0);
	border-color: #ccc #ccc #fff;
	border-image: none;
	border-style: dotted dotted solid;
	border-width: 1px 1px 2px;
	color: #333;
	font-size: 13px;
	font-weight: normal;
	padding: 8px;
	text-align: left;
}

.tsc_tables2_4 td {
	background: none repeat scroll 0 0 #f2f2f2;
	border-bottom: 1px solid #fff;
	border-top: 1px solid transparent;
	color: #666;
	padding: 8px;
}

.tsc_tables2_4 tbody tr:hover td {
	background-color: #f5fbff;
	border-bottom: 1px solid #ccc;
	border-top: 1px solid #ccc;
	color: #333;
}

.tsc_tables2_5 {
	border-bottom: 3px solid #ccc;
	border-collapse: collapse;
	border-top: 1px solid #ccc;
	font-size: 12px;
	text-align: center;
	width: 480px;
}

.tsc_tables2_5 th {
	background: none repeat scroll 0 0 #f2f2f2;
	border-left: 1px dotted #ccc;
	border-right: 1px dotted #ccc;
	color: #333;
	font-size: 13px;
	font-weight: normal;
	padding: 8px;
}

.tsc_tables2_5 tbody tr:hover td {
	background-color: #f5fbff;
	border-bottom: 1px dotted #ccc;
	border-top: 1px dotted #ccc;
	color: #333;
}

.tsc_tables2_5 td {
	background: none repeat scroll 0 0 #fff;
	border-left: 1px dotted #ccc;
	border-right: 1px dotted #ccc;
	color: #333;
	padding: 8px;
}

.tsc_tables2_6 {
	background: none repeat scroll 0 0 #fff;
	border-collapse: collapse;
	font-size: 12px;
	text-align: left;
	width: 480px;
}

.tsc_tables2_6 th {
	color: #333;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 8px;
}

.tsc_tables2_6 td {
	color: #666;
	padding: 8px;
}

.tsc_tables2_6 tbody tr:hover td {
	background-color: #f5fbff;
	border-bottom: 1px dotted #ccc;
	border-top: 1px dotted #ccc;
	color: #333;
}

.tsc_tables2_6 .odd {
	background: none repeat scroll 0 0 #eee;
}

.tsc_tables2_7 {
	border-collapse: collapse;
	font-size: 12px;
	text-align: left;
	width: 480px;
}

.tsc_tables2_7 th {
	border-left: 1px solid #fff;
	border-right: 1px solid #fff;
	color: #333;
	font-size: 14px;
	font-weight: normal;
	padding: 12px 15px;
}

.tsc_tables2_7 td {
	border-left: 1px solid #fff;
	border-right: 1px solid #fff;
	color: #666;
	padding: 8px 15px;
}

.tsc_tables2_7 tbody tr:hover td {
	background-color: #f5fbff;
	border-bottom: 1px dotted #ccc;
	border-top: 1px dotted #ccc;
	color: #333;
}

.tsc_tab2_odd {
	background: none repeat scroll 0 0 #f2f2f2;
}

.tsc_tab2_even {
	background: none repeat scroll 0 0 #eee;
}

.tsc_tables2_7 .tsc_tab2_v1 {
	background: none repeat scroll 0 0 #ddd;
	border-bottom: 1px dotted #999;
}

.tsc_tables2_7 .tsc_tab2_v2 {
	background: none repeat scroll 0 0 #ccc;
	border-bottom: 1px dotted #666;
}

.tsc_tables2_8 {
	background: none repeat scroll 0 0 #fff;
	border-collapse: collapse;
	font-size: 12px;
	text-align: left;
	width: 480px;
}

.tsc_tables2_8 th {
	color: #000;
	font-size: 14px;
	font-weight: normal;
	padding: 12px 15px;
}

.tsc_tables2_8 td {
	border-top: 1px dotted #ccc;
	color: #666;
	padding: 10px 15px;
}

.tsc_first {
	background: none repeat scroll 0 0 #f2f2f2;
	border-left: 10px solid transparent;
	border-right: 10px solid transparent;
}

.tsc_tables2_8 tbody tr:hover td {
	background-color: #f5fbff;
	border-bottom: 1px dotted #ccc;
	border-top: 1px dotted #ccc;
	color: #333;
}

.tsc_tables2_9 {
	background: none repeat scroll 0 0 #fff;
	border: 1px solid #ccc;
	border-collapse: collapse;
	font-size: 12px;
	text-align: left;
	width: 480px;
}

.tsc_tables2_9 th {
	background-color: #f2f2f2;
	border-bottom: 1px dashed #ccc;
	color: #333;
	font-size: 14px;
	font-weight: normal;
	padding: 12px 17px;
}

.tsc_tables2_9 td {
	color: #666;
	padding: 7px 17px;
}

.tsc_tables2_9 tbody tr:hover td {
	background-color: #f5fbff;
	border-bottom: 1px dotted #ccc;
	border-top: 1px dotted #ccc;
	color: #333;
}

.tsc_tables2_10 {
	background: none repeat scroll 0 0 #fff;
	border: 1px solid #ccc;
	border-collapse: collapse;
	font-size: 12px;
	text-align: left;
	width: 480px;
}

.tsc_tables2_10 th {
	color: #333;
	font-size: 14px;
	font-weight: normal;
	padding: 15px 10px 10px;
}

.tsc_tables2_10 tbody {
	background: none repeat scroll 0 0 #f2f2f2;
}

.tsc_tables2_10 td {
	border-top: 1px dashed #ccc;
	color: #666;
	padding: 10px;
}

.tsc_tables2_10 tbody tr:hover td {
	background-color: #f5fbff;
	border-bottom: 1px dotted #ccc;
	border-top: 1px dotted #ccc;
	color: #333;
}

.tsc_tables2_11 {
	background: none repeat scroll 0 0 #fff;
	border: 1px solid #ccc;
	border-collapse: collapse;
	font-size: 12px;
	text-align: left;
	width: 480px;
}

.tsc_tables2_11 th {
	background-color: #f2f2f2;
	border-color: #999 #ccc #ccc #999;
	border-right: 1px dashed #ccc;
	border-style: dashed dashed solid;
	border-width: 1px;
	color: #333;
	font-size: 13px;
	font-weight: normal;
	padding: 20px;
	text-transform: uppercase;
}

.tsc_tables2_11 td {
	border-right: 1px dashed #ccc;
	color: #666;
	padding: 10px 20px;
}

.tsc_tables2_11 tbody tr:hover td {
	background-color: #f5fbff;
	border-bottom: 1px dotted #ccc;
	border-top: 1px dotted #ccc;
	color: #333;
}

.tsc_tables2_12 {
	border-collapse: collapse;
	font-size: 12px;
	text-align: left;
	width: 480px;
}

.tsc_tables2_12 thead th.rounded-company {
	background: url("../images/left.png") no-repeat scroll left -1px #b9c9fe;
}

.tsc_tables2_12 thead th.rounded-q4 {
	background: url("../images/right.png") no-repeat scroll right -1px
		#b9c9fe;
}

.tsc_tables2_12 th {
	background: none repeat scroll 0 0 #b9c9fe;
	color: #039;
	font-size: 13px;
	font-weight: normal;
	padding: 8px;
}

.tsc_tables2_12 td {
	background: none repeat scroll 0 0 #e8edff;
	border-top: 1px solid #fff;
	color: #669;
	padding: 8px;
}

.tsc_tables2_12 tfoot td.rounded-foot-left {
	background: url("../images/botleft.png") no-repeat scroll left bottom
		#e8edff;
}

.tsc_tables2_12 tfoot td.rounded-foot-right {
	background: url("../images/botright.png") no-repeat scroll right bottom
		#e8edff;
}

.tsc_tables2_12 tbody tr:hover td {
	background-color: #f5fbff;
	border-bottom: 1px dotted #ccc;
	border-top: 1px dotted #ccc;
	color: #333;
}

.tsc_tables2_13 {
	border-collapse: collapse;
	font-size: 12px;
	text-align: left;
	width: 480px;
}

.tsc_tables2_13 th {
	color: #339;
	font-size: 14px;
	font-weight: normal;
	padding: 12px;
}

.tsc_tables2_13 td {
	border-top: 1px solid #fff;
	color: #669;
	padding: 9px 12px;
}

.tsc_tables2_13 tfoot td {
	font-size: 11px;
}

.tsc_tables2_13 tbody td {
	background: url("../images/back.png") repeat scroll 0 0 rgba(0, 0, 0, 0);
}

.tsc_tables2_13 tbody tr:hover td {
	background: none repeat scroll 0 0 rgba(0, 0, 0, 0);
	color: #339;
}

.tsc_tables2_14 {
	border-collapse: collapse;
	font-size: 12px;
	text-align: left;
	width: 480px;
}

.tsc_tables2_14 th {
	background: url("../images/gradhead.png") repeat-x scroll 0 0 #b9c9fe;
	border-bottom: 1px solid #fff;
	border-top: 2px solid #d3ddff;
	color: #039;
	font-size: 13px;
	font-weight: normal;
	padding: 8px;
}

.tsc_tables2_14 td {
	background: url("../images/gradback.png") repeat-x scroll 0 0 #e8edff;
	border-bottom: 1px solid #fff;
	border-top: 1px solid #fff;
	color: #669;
	padding: 8px;
}

.tsc_tables2_14 tfoot tr td {
	background: none repeat scroll 0 0 #e8edff;
	color: #99c;
	font-size: 12px;
}

.tsc_tables2_14 tbody tr:hover td {
	background: url("../images/gradhover.png") repeat-x scroll 0 0 #d0dafd;
	color: #339;
}
</style>
</head>
<body>
<div id='cssmenu'>
	<ul>
		<li><a href='/DBMonitor/index.jsp'><span>Home</span></a></li>
		<li class='active'><a href='/DBMonitor/StatusController'><span>Monitor</span></a></li>
		<li><a href='/DBMonitor/Reports'><span>Reports</span></a></li>
		<li><a href='/DBMonitor/DBController?action=listDatabase'><span>Register</span></a></li>
		<li><a href='/DBMonitor/Schedular'><span>Schedular</span></a></li>
	</ul>
</div>
<script type="text/javascript">
 $(function() {
        /* For zebra striping */
        $("table tr:nth-child(odd)").addClass("odd-row");
        /* For cell text alignment */
        $("table td:first-child, table th:first-child").addClass("first");
        /* For removing the last border */
        $("table td:last-child, table th:last-child").addClass("last");
});
</script>
	</br>
	</br>
	</br>
	<center>
	<font size="18">
		Database "${dbSize.dbName}"  on Host "${dbSize.hostName}" is <b>${dbSize.dbSize}MB</b> 
	</font>
	</center>
</body>
</html>