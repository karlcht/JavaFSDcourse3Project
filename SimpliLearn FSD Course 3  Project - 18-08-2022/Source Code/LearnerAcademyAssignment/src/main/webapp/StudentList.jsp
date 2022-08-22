<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
     import="java.util.ArrayList"
	import=" java.util.List"
	import = "service.AdminService"
    import = "bean.LearnersBean"
     import = "bean.Stbean"
     import = "java.util.HashSet"
import = "java.util.List"
import = "java.util.Set"
import = "java.util.HashSet"
import ="java.util.List"
import = "java.util.Set"
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="AdminServlet1" method="get">
<h3 align="center"> Student List</h3>
<hr>

<a href="AdminAccess" style="color:orange;"><h3>Press Link to go back to Learners List</h3> </a><br>

 <table align="center" border="1">
  	<!-- <tr>
  		<td><H2> Student List</H2></td>
  	<tr/> -->
  	 	<tr>
  		<td><H3> Student Name</H3></td>
  		<td> <H3>Student Surname</H3></td>
  	<tr/>
 	
 	
<%
Set<Stbean> hslist = (Set<Stbean>)request.getAttribute("listofstudents");
%>


<% 
if(hslist!=null){
	  		
  
 for(Stbean hashvar:hslist)
 {
%>

<tr>
 	<td><%=hashvar.getStudentName()%></td>
 	<td><%=hashvar.getStudentSurname()%></td>
 	<%-- <td><%=hashvar.hashCode()%></td> --%>
 <tr/>	
 
 		
 		<%   
 		
   }
 
}
 
 %>
 <tr/>

<form/>

</body>
</html>