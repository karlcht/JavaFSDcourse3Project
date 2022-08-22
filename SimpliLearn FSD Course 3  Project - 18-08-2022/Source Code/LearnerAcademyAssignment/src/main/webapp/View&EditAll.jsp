<%@page import="bean.LoginBean"%>
<%@page import="bean.LearnersBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    
    import="java.util.ArrayList"
	import=" java.util.List"
	import = "service.AdminService"
	import = "dao.DaoLearners"
	import = "bean.*"
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AdminServlet1" method="get">
<h3 align="center"> All Employee Details</h3>
<hr>


<%
DaoLearners learners = new DaoLearners();
List<LearnersBean> list = learners.getAll();



%>
 
 <table align="center" border="1">
  	<tr>
 		<td> Class</td>
 		<td> Subject</td>
 		<td> Teachers Name</td>
 		<td> Teachers Surname</td>
 		<td> Students Name</td>
 		<td> Students Surname</td>
 		<td colspan="2">Action</td>
 		<td><input type="button" value="Edit" name="buttedit"></td>
 	<td><input type="button" value="Delete" name="buttdelete"></a></td>
 	<tr/>
 
 	
 	


</body>
</html>