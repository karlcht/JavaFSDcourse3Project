<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    
     import="java.util.ArrayList"
	import=" java.util.List"
	import = "service.AdminService"
    import = "bean.LearnersBean"
    import = "bean.Cbean"
     
     
    %>
    
    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AdminServlet1" method="get">
<h3 align="center"> EDIT Employee Details</h3>
<hr>
    
    <table align="center" border="1">
  	<tr>
 		<td> Class</td>
 		<td> Subject</td>
 		<td> Teacher Name</td>
 		<td> Teacher Surname</td>
 		<td> Student Name</td>
 		<td> Student Surname</td>
 		<td colspan="1">Action</td>
 	<tr/>
 	
 	<tr>
 	
  <td><select name="classlist"> 
 <%

 	  LearnersBean Lbean = (LearnersBean)request.getAttribute("Search");
	  List<Cbean> Clist =  (List<Cbean>)request.getAttribute("listofClassListObj");
	  
	 
		for(Cbean bean:Clist)
	 	{   
	%>  
 	<option value="<%= bean.getClassName() %>"><%= bean.getClassName() %><option/>
 	<% } %>
 	</select> </td>
 	<td><input type="text" value="<%=Lbean.getSubject()%>" name="editsubject"></td>
 	<td><input type="text" value="<%=Lbean.getTeacherName()%>" name="editteachname"></td>
	<td><input type="text" value="<%=Lbean.getTeacherSurname() %>" name="editteachsurname"></td>
	<td><input type="text" value="<%=Lbean.getStudentName()%>" name="editstudentname"></td>
	<td><input type="text" value="<%=Lbean.getStudentSurName() %>" name="editstudentsurname"></td>
	<td><input type="submit" value = "Save" name="button"></td>
	</tr>
	
	

</table>
</form>
</body>
</html>