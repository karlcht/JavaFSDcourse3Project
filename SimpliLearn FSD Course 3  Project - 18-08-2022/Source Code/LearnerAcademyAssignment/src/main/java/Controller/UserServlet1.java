package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cbean;
import bean.LearnersBean;
import bean.LoginBean;
import service.AdminService;


public class UserServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UserServlet1() {
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Logout
		HttpSession session = request.getSession();
		session.invalidate();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Post of UserServlet1");
		String userName = request.getParameter("userName");
		String generateObj = "false" ;
		int password = Integer.parseInt(request.getParameter("password"));
		
		LoginBean beanFromUser = new LoginBean();
		beanFromUser.setUsername(userName);
		beanFromUser.setPassword(password);
		System.out.println(userName);
		System.out.println(password);
		
	
	
		
		AdminService service = new AdminService();
		String user = service.login(beanFromUser); 
		HttpSession session = request.getSession();
		
		
		if (user == null) 
		{
			RequestDispatcher rd = request.getRequestDispatcher("/LoginError.html");
			rd.forward(request, response);
			
		}
		
			
			else if (user.equalsIgnoreCase("Admin")) 
			{
				session.setAttribute("userName", userName);	
				generateObj = "true";
				session.setAttribute("generateObj", generateObj);	 	
					
				String sessiontime = "Session ID: " +session.getId() + "Session created: "+session.getCreationTime();
				session.setAttribute("sessiontime",sessiontime);
				System.out.println(sessiontime);
							
				/*
				 * RequestDispatcher rd = request.getRequestDispatcher("AdminServlet1.jsp");
				 * rd.forward(request, response);
				 */
					
				
				RequestDispatcher rd = request.getRequestDispatcher("AdminAccess");
				rd.forward(request, response);
				
				 
						
						 

						 
					 }
				
				
			
				
			}	
			

	}


