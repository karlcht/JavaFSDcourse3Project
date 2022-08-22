package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		 * AdminService service = new AdminService();
		 * 
		 * List<Bean> list = service.findAllEmployees();
		 * 
		 * if (list == null) {
		 * 
		 * RequestDispatcher rd = request.getRequestDispatcher("/failure.html");
		 * rd.forward(request, response);
		 * 
		 * } else { request.setAttribute("listofempObj", list); RequestDispatcher rd =
		 * request.getRequestDispatcher("/ViewAllEmployeeDetails.jsp");
		 * rd.forward(request, response); }
		 */
		}

		
		 
		
		 
		 
		 
		 
		 
		 
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		
		
		
	}

}
