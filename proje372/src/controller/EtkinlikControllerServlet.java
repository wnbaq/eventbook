package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EtkinlikDAO;
import dao.KullaniciDAO;


public class EtkinlikControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String etkinlikIsmi = request.getParameter("etkinlikIsmi");
		String startTime = request.getParameter("startTime");
		String finishTime = request.getParameter("finishTime");
		String email = request.getParameter("email");
		String ageRange = request.getParameter("ageRange");
		
		HttpSession session = request.getSession(true);
		try {
			EtkinlikDAO eventDAO = new EtkinlikDAO();
			DateFormat df =new SimpleDateFormat("dd-mm-yyyy");
			Date sdate=null;
			Date fdate=null;
			try{
				sdate=df.parse(startTime);
				fdate=df.parse(startTime);
				eventDAO.createEtkinlik(etkinlikIsmi, sdate, fdate, ageRange, email);
			}catch(ParseException el){
				System.out.println("------olmadi" +el);
			}
			
			request.getRequestDispatcher("register.html").forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
