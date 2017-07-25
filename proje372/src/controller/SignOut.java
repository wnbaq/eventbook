package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignOut
 */
@WebServlet("/SignOut")
public class SignOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Logout Admin</title>");
				out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
				out.println("</head>");
				out.println("<body>");
				request.getRequestDispatcher("navigation.html").include(request, response);
				
				out.println("<h1>You are successfully logged out</h1>");
				request.getSession().invalidate();
				
				out.close();
			}

		
}
