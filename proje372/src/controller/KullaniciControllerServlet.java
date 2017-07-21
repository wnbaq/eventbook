package controller;

import java.io.IOException;

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
		String password = request.getParameter("password1");
		String email = request.getParameter("email");

		HttpSession session = request.getSession(true);
		try {
			KullaniciDAO userDAO = new KullaniciDAO();
			userDAO.addUserDetails(userName, surname, password, email);
			response.sendRedirect("Success");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
