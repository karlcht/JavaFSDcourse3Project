<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
        
    import="java.util.ArrayList"
	import=" java.util.List"
	import = "service.AdminService"
    import = "bean.LearnersBean"
     import = "bean.Cbean"
     import = "java.util.HashSet"
	import = "java.util.List"
	import = "java.util.Set"
	import = "bean.Tbean"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="AdminServlet1" method="get">
<h3 align="center"> Teachers List</h3>
<hr>

<a href="AdminAccess" style="color:orange;"><h3>Press Link to go back to Learners List</h3> </a><br>

 <table align="center" border="1">
  	<!-- <tr>
  		<td><H2> Student List</H2></td>
  	<tr/> -->
  	 	<tr>
  		<td><H3> Teacher Name</H3></td>
  		<td> <H3>Teacher Surname</H3></td>
  	<tr/>
 	
 	
<%
Set<Tbean> hslist = (Set<Tbean>)request.getAttribute("listofteachers");
%>


<% 
if(hslist!=null){
	  		
  
 for(Tbean hashvar:hslist)
 {
%>

<tr>
 	<td><%=hashvar.getTeacherName()%></td>
 	<td><%=hashvar.getTeacherSurname()%></td>
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