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
<h3 align="center"> All Employee Details</h3>
<hr>




<%
 
List<LearnersBean> list = (List<LearnersBean>)request.getAttribute("listofLearnerObj");

%>
 
 <table align="center" border="">
  	<tr>
 		<td><button name="button" value="subjectlist" type= "submit"  >Subjects' List</button></td>
 		<td><button name="button" value="studentlist" type= "submit"  >Students' List</button></td>
 		<td><button name="button" value="teacherlist" type= "submit"  >Teachers' List</button></td>
 		<td><button name="button" value="classlist" type= "submit"  >Class List</button></td>
 		<td><button name="button" value="logout" type= "submit"  >Sign Out</button></td>
 	<tr/>
 	
 	<table/>
 	
 	<br>
 	
 	
 
 <table align="center" border="1">
  	<tr>
 		<td> Class</td>
 		<td> Subject</td>
 		<td> Teacher Name</td>
 		<td> Teacher Surname</td>
 		<td> Student Name</td>
 		<td> Student Surname</td>
 		<td colspan="2">Action</td>
 	<tr/>
 
 
 
 

  <tr>
  <td><select name="classlist"> 
 <%
  if ( list == null || list.isEmpty())
  {
	
	  
	  List<Cbean> Clist = (List<Cbean>)request.getAttribute("listofClassListObj");
	  for(Cbean bean:Clist)
	 	{   
	%>  
 	<option value="<%= bean.getClassName() %>"><%= bean.getClassName() %><option/>
 	<% } %>
 	</select> </td>
 	<td><input type="text" value="Edit" name="editsubject"></td>
 	<td><input type="text" value="Edit" name="editteachname"></td>
	<td><input type="text" value="Edit" name="editteachsurname"></td>
	<td><input type="text" value="Edit" name=editstudentname></td>
	<td><input type="text" value="Edit" name="editstudentsurname"></td>
	<td><input type="submit" value = "save" name="button"><td/>
	 


 	<%-- <td><%= bean.getTeacherName() %></td>
 	<td><%= bean.getTeacherSurname() %></td>
 	<td><%= bean.getStudentName() %></td>
 	<td><%= bean.getStudentSurName() %></td>
 	
 	<td><input type="button" value="Edit" name="buttedit"></td>
 	<td><input type="button" value="Delete" name="buttdelete"></td>
   </tr>	 --%>
   
	<% 
 	 

  
  } 
	
  
 
  else if (list!=null){
	  
	 
List<Cbean> Clist = (List<Cbean>)request.getAttribute("listofClassListObj");			
  
 for(LearnersBean bean:list)
   {
	 
%> 

<tr>
 	<td><%=bean.getClassroom() %></td>
 	
 	<td><%=bean.getSubject() %></td>
	
 	<td><%= bean.getTeacherName() %></td>
 	<td><%= bean.getTeacherSurname() %></td>
 	<td><%= bean.getStudentName() %></td>
 	<td><%= bean.getStudentSurName() %></td>
 	
 	
 	
 	<td><button name="button" value="Edit,<%=bean.getStudentName()%>,<%=bean.getStudentSurName()%>" type= "submit"  >Edit</button></td>
 	<td><button name="button" value="Delete,<%=bean.getStudentName()%>,<%=bean.getStudentSurName()%>" type="submit">Delete</button></td>
 	
 	<!-- <td><input type="button" value="Delete"  name="button" ></td> -->
 	
 	
 	<%-- <% 
 	String button2value = request.getParameter("buttdelete");
 	if (button2value.equalsIgnoreCase("Delete"))
 	{
 		service.deleteProfile(bean.getEmpId());
 		
 	}
 		
 		
 		%> --%>
 		
 		
 		<%   
 		
   }
 
 %>
 <tr>
 <td><select name="classlist"> 	
<% 
for(Cbean bean1:Clist)
	 	{   
	
	
	%>  
 	<option value="<%= bean1.getClassName() %>"><%= bean1.getClassName() %><option/>
 	<% } %>
 	</select> </td>
 	<td><input type="text" value="Edit" name="editsubject"></td>
 	<td><input type="text" value="Edit" name="editteachname"></td>
	<td><input type="text" value="Edit" name="editteachsurname"></td>
	<td><input type="text" value="Edit" name=editstudentname></td>
	<td><input type="text" value="Edit" name="editstudentsurname"></td>
	<td><input type="submit" value = "save" name="button"><td/>
	<tr/>


<%   

 
  }
 %>
  
 

 
 </table>
 
 <br>
 <br>

 <h1> Session Details </h1>
 <h2>< <%= session.getAttribute("sessiontime") %> ></h2>
 </form>
</body>
</html>