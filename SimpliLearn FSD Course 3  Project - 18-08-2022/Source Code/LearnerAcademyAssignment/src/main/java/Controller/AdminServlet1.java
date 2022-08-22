package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.OutputBuffer;

import bean.Cbean;
import bean.LearnersBean;
import bean.Stbean;
import bean.Subean;
import bean.Tbean;
import service.AdminService;

/**
 * Servlet implementation class AdminServlet1
 */
public class AdminServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

    public AdminServlet1() {
    	
    	
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			HttpSession session = request.getSession();
			AdminService service = new AdminService();
			String generateObj = (String) session.getAttribute("generateObj");
			
	
			
	
				
				String buttonValue = request.getParameter("button");
				
			
				if (buttonValue == null || buttonValue.isEmpty()) 
				{
					 System.out.println("Button val is null");
				}
				
				
				
				else if(buttonValue.equalsIgnoreCase("Save"))
				{
					 
					/*
					 * redirectcommand ="true"; session.setAttribute("redirectcommand",
					 * redirectcommand);
					 * System.out.println("Redirect command in if save condition "+
					 * redirectcommand);
					 */
					 
					 
					
					System.out.println(buttonValue);
					 String classes = request.getParameter("classlist");
					 String teachName = request.getParameter("editteachname");
					 String teachSurname = request.getParameter("editteachsurname");
					 String subject = request.getParameter("editsubject");
					 String studentName = request.getParameter("editstudentname");
					 String studentSurname = request.getParameter("editstudentsurname");
					 
				
			
					//System.out.println(classes+teachName+teachSurname+subject+studentName+studentSurname);
					
					
					
					LearnersBean bean = new LearnersBean();
					 
					bean.setClassroom(classes);
					bean.setTeacherName(teachName);
					bean.setTeacherSurname(teachSurname);
					bean.setStudentName(studentName);
					bean.setStudentSurName(studentSurname);
					bean.setSubject(subject);
					
					System.out.println(bean.getClassroom() + bean.getStudentName()+bean.getSubject());
					
					
					boolean list1 = service.insertinLearnersTable(bean);
					System.out.println(list1);
							
						if(list1 == true)
						{
						 RequestDispatcher rd2 = request.getRequestDispatcher("/success.html");
						 rd2.forward(request, response);
						 
						//response.setIntHeader("Refresh", 0); 
						 System.out.println(buttonValue);
						}
						
						else
						{
							RequestDispatcher rd2 = request.getRequestDispatcher("/failure.html");
							 rd2.forward(request, response);
							 System.out.println(buttonValue);
						}
					
				}
				
					
				else if ((buttonValue.contains("Delete")))
				{
					 System.out.println(buttonValue);
					 System.out.println("Delete Button Works");

					 
					 String studentName = buttonValue.split(",")[1];
					 String studentSurname = buttonValue.split(",")[2];
					 System.out.println(studentName+" "+studentSurname);
					 
					int count = service.deleteLearnerByName(studentName,studentSurname);
					
					if (count>0)
					{
						RequestDispatcher rd = request.getRequestDispatcher("/success.html");
						 rd.forward(request, response);
					}
					
					else
					{
						RequestDispatcher rd = request.getRequestDispatcher("/failure.html");
						 rd.forward(request, response);
					}
					 
					 
				}
				
					
				else if ((buttonValue.contains("Edit")))
				{
					 System.out.println(buttonValue);
					 System.out.println("Edit Button Works");
					 
					 String studentName = buttonValue.split(",")[1];
					 String studentSurname = buttonValue.split(",")[2];
					 System.out.println(studentName+" "+studentSurname);
					 LearnersBean Search = service.SearchLearner(studentName, studentSurname);
					 request.setAttribute("Search", Search);
					 List<Cbean> clistAdmin = service.viewClasses();
					 request.setAttribute("listofClassListObj", clistAdmin);
					
					 if (Search != null)
					 {
						 int count = service.deleteLearnerByName(studentName,studentSurname);
					 }
					 
					 RequestDispatcher rd = request.getRequestDispatcher("/Edit.jsp");
					 rd.forward(request, response);
					
				}
			
				
				else if ((buttonValue.contains("subjectlist")))
						{
					
					 System.out.println(buttonValue);
					 Set<String> hs = new HashSet();
					 List<LearnersBean> lbean = (List<LearnersBean>) service.viewLearnerTable();
					 for(LearnersBean bean:lbean)
					 {
						 hs.add(bean.getSubject());
					 }
				
					 
					 
					 request.setAttribute("listofsubjects",hs );
					 
						/*
						 * for(LearnersBean b:hs) { System.out.println(b.getSubject()); }
						 */
					 
					 RequestDispatcher rd = request.getRequestDispatcher("/SubjectList.jsp");
					 rd.forward(request, response);
					
						}
					
					
					
				else if ((buttonValue.contains("studentlist")))
				{
			
			 System.out.println(buttonValue);
			 
			
			 Set<Stbean> hs = new HashSet<Stbean>();
			 List<LearnersBean> lbean = (List<LearnersBean>) service.viewLearnerTable();
			 for(LearnersBean bean:lbean)
			 {
				 
				 
				 Stbean st = new Stbean();
				 st.setStudentName(bean.getStudentName());
				 st.setStudentSurname(bean.getStudentSurName());
				 hs.add(st);
				 
				
			 }
		
			 for(Stbean bean:hs)
				 System.out.println(bean.getStudentName() + bean.getStudentSurname());
			 
			 
			 
			 
			 request.setAttribute("listofstudents",hs );
			 
			 
			RequestDispatcher rd = request.getRequestDispatcher("/StudentList.jsp");
			 rd.forward(request, response);
			
				}
			
				else if ((buttonValue.contains("teacherlist")))
				{
			
			 System.out.println(buttonValue);
			 
			
			 Set<Tbean> hs = new HashSet<Tbean>();
			 List<LearnersBean> lbean = (List<LearnersBean>) service.viewLearnerTable();
			 for(LearnersBean bean:lbean)
			 {
				 
				 
				 Tbean tb = new Tbean();
				 tb.setTeacherName(bean.getTeacherName());
				 tb.setTeacherSurname(bean.getTeacherSurname());
				 hs.add(tb);
				 
				
			 }
		
			 for(Tbean bean:hs)
				 System.out.println(bean.getTeacherName() + bean.getTeacherSurname());
			 
			 
			 
			 
			 request.setAttribute("listofteachers",hs );
			 
			 
			RequestDispatcher rd = request.getRequestDispatcher("/TeacherList.jsp");
			 rd.forward(request, response);
			
				}
				
				else if ((buttonValue.contains("classlist")))
				{
			
			 System.out.println(buttonValue);
			 
			
			 Set<String> hs = new HashSet<String>();
			 List <String> list = new <String>ArrayList();
			 TreeSet<String> myTreeSet = new TreeSet<String>();
			 List<LearnersBean> lbean = (List<LearnersBean>) service.viewLearnerTable();
			 for(LearnersBean bean:lbean)
			 {
				 
				 
				hs.add(bean.getClassroom());
				list.addAll(hs);
				myTreeSet.addAll(hs);
				 
				
			 }
		
			 for(String classlist:hs)
				 System.out.println(classlist.toString());
			 
			 
			 
			 
			 request.setAttribute("listofclass",myTreeSet );
			 
			 
			RequestDispatcher rd = request.getRequestDispatcher("/ClassList.jsp");
			 rd.forward(request, response);
			
				}
					

				else if ((buttonValue.contains("logout")))
				{
			
			 System.out.println(buttonValue);		
			
			 //request.getSession(false).invalidate();
				session.invalidate();
				session = null;
				
			
			
			if (session == null) 
				System.out.println("Session invalidated");
			
			else
				System.out.println("Session NOT INVALIDATED");
			
			RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
			System.out.println("Context path = "+request.getContextPath());
			response.sendRedirect(request.getContextPath() + "/Login.html");
			 // rd.include(request, response);
			 //response.sendRedirect("/Login.html");
			 
			 
			
		}
	
	}
	


	private void handleCaseFormessedUpForm() {
		// TODO Auto-generated method stub
		
	}

	/*
	 * String buttonValue = request.getParameter("button"); if
	 * (buttonValue.equalsIgnoreCase("Save")) {
	 * 
	 * int empId = Integer.parseInt(request.getParameter("empId")); String name =
	 * request.getParameter("name"); String surname =
	 * request.getParameter("surname"); float salary =
	 * Float.parseFloat(request.getParameter("salary"));
	 * 
	 * Bean bean = new Bean(); bean.setEmpId(empId); bean.setName(name);
	 * bean.setSurname(surname); bean.setSalary(salary); AdminService service = new
	 * AdminService(); boolean insertStatus = service.AddProfile(bean); if
	 * (insertStatus) { RequestDispatcher rd =
	 * request.getRequestDispatcher("/success.html"); rd.forward(request, response);
	 * } else { RequestDispatcher rd =
	 * request.getRequestDispatcher("/failure.html"); rd.forward(request, response);
	 * } } else if (buttonValue.equalsIgnoreCase("Update")) {
	 * 
	 * }
	 * 
	 * else if (buttonValue.equalsIgnoreCase("Delete")) {
	 * dbConnection.getConnection(); int empId =
	 * Integer.parseInt(request.getParameter("empId")); System.out.println(empId +
	 * " Parameter received"); AdminService service = new AdminService(); int count
	 * = service.deleteProfile(empId); System.out.println("count " + count); if
	 * (count > 0) { RequestDispatcher rd =
	 * request.getRequestDispatcher("/success.html"); rd.forward(request, response);
	 * } else { RequestDispatcher rd =
	 * request.getRequestDispatcher("/failure.html"); rd.forward(request, response);
	 * } }
	 * 
	 * else if (buttonValue.equalsIgnoreCase("Find")) { int empId =
	 * Integer.parseInt(request.getParameter("empId")); System.out.println(empId +
	 * " Parameter received"); AdminService service = new AdminService(); Bean
	 * servbean = new Bean();
	 * 
	 * servbean = service.viewProfile(empId); if (servbean == null) {
	 * 
	 * RequestDispatcher rd = request.getRequestDispatcher("/failure.html");
	 * rd.forward(request, response);
	 * 
	 * } else { request.setAttribute("empObj", servbean); RequestDispatcher rd =
	 * request.getRequestDispatcher("/ViewEmployeeDetails.jsp"); rd.forward(request,
	 * response); } }
	 * 
	 * else if (buttonValue.equalsIgnoreCase("Find All")) {
	 * 
	 * */
	

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
