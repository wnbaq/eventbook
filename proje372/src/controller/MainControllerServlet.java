package controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Etkinlik;
import dao.EtkinlikDAO;

@WebServlet("/Etkinlik1")
public class MainControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public MainControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>ALL EVENTS</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navigation.html").include(request, response);
		out.print(" <a href='ViewEtkinlikTypes?type=Education' class='btn btn-primary' role='button'>Education</a> ");
		out.print(" <a href='ViewEtkinlikTypes?type=Music' class='btn btn-primary' role='button'>Music</a> ");
		out.print(" <a href='ViewEtkinlikTypes?type=Network' class='btn btn-primary' role='button'>Network</a> ");
		out.print(" <a href='ViewEtkinlikTypes?type=Food' class='btn btn-primary' role='button'>Food</a> ");
		out.print(" <a href='ViewEtkinlikTypes?type=Party' class='btn btn-primary' role='button'>Party</a> ");
		out.print(" <a href='ViewEtkinlikTypes?type=Sport' class='btn btn-primary' role='button'>Sport</a> ");
		out.print(" <a href='ViewEtkinlikTypes?type=Art' class='btn btn-primary' role='button'>Art</a> ");

	

		EtkinlikDAO et = new EtkinlikDAO();
		out.println("<h1>ALL EVENTS</h1>");
		List<Etkinlik> list = et.listEtkinlik();
		out.print("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Start Time</th><th>Finish Time</th><th>Event Name</th><th>Age Rank</th><th>Type</th></tr>");
		for (Etkinlik b : list) {
			out.println("<tr><td>" + b.getBaslangicZamani() + "</td><td>" + b.getBitisZamani() + "</td><td>"
					+ b.getEtkinlikIsmi() + "</td><td>" + b.getYasAraligi() + "</td><td>"
					+ b.getType() + "</td></tr>");

			
			out.println("<td><a href='DeleteEvent?id=" + b.getid() + "'>Delete Event</a></td>");
			System.out.println(b.getid());
			//out.println("<td><a href='etkinlikRegister'>+ "Add Event</a></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.close();

	}

}
