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
	import ="java.util.TreeSet"
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AdminServlet1" method="get">
<h3 align="center"> All Classes</h3>
<hr>

<a href="AdminAccess" style="color:orange;"><h3>Press Link to go back to Learners List</h3> </a><br>

 <table align="center" border="1">
  	<tr>
  		<td><H2> Class List</H2></td>
  	<tr/>
 	
 	
<%
TreeSet <String>tslist = (TreeSet <String>)request.getAttribute("listofclass");

%>


<% 
if(tslist!=null){
	  		
  
 for(String treevar:tslist)
 {
%>

<tr>
 	<td><%=treevar%></td>
 <tr/>	
 
 		
 		<%   
 		
   }
 
}
 
 %>
 <tr/>

<form/>
</body>
</html>