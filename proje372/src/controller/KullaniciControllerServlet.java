package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KullaniciDAO;


public class KullaniciControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("name");
		String surname = request.getParameter("surname");
		String password = request.getParameter("password");
		String password1 = request.getParameter("password1");
		String email = request.getParameter("email");

		HttpSession session = request.getSession(true);
		try {
			if(password.equals(password1)){
				KullaniciDAO userDAO = new KullaniciDAO();
				userDAO.addUserDetails(userName, surname, password, email);
				response.sendRedirect("signup");
			}
			else {
				PrintWriter writer = response.getWriter();
				writer.println("<html>" + "<body bgcolor='cyan'>" + "<center>"
						+ "Details not Added Successfully" + "</center>" + "</body>"
						+ "</html>");
			}

			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
