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
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="AdminServlet1" method="get">
<h3 align="center"> All Subjects</h3>
<hr>

<a href="AdminAccess" style="color:orange;"><h3>Press Link to go back to Learners List</h3> </a><br>

 <table align="center" border="1">
  	<tr>
  		<td><H2> Subject List</H2></td>
  	<tr/>
 	
 	
<%
Set<String> hslist = (Set<String>)request.getAttribute("listofsubjects");

%>


<% 
if(hslist!=null){
	  		
  
 for(String hashvar:hslist)
 {
%>

<tr>
 	<td><%=hashvar%></td>
 <tr/>	
 
 		
 		<%   
 		
   }
 
}
 
 %>
 <tr/>

<form/>

</body>
</html>