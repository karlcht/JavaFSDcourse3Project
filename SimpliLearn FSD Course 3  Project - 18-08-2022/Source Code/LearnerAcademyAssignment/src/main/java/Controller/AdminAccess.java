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
import bean.Tbean;
import service.AdminService;

/**
 * Servlet implementation class AdminAccess
 */
public class AdminAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminAccess() {
     
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		AdminService service = new AdminService();
		String generateObj = (String) session.getAttribute("generateObj");
		
		if(generateObj.equalsIgnoreCase("true"))
		{
		
		List<Cbean> clistAdmin = service.viewClasses();
		List<LearnersBean> list = service.viewLearnerTable();
		List<Tbean> tlist = service.viewTProfile();
		request.setAttribute("listofLearnerObj", list); 
		request.setAttribute("listofClassListObj", clistAdmin);
		
		
		 RequestDispatcher rd = request.getRequestDispatcher("/ViewAllEmployeeDetails1.jsp");
		 rd.forward(request, response);
		 
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
