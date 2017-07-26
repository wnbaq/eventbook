package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Etkinlik;
import dao.EtkinlikDAO;

/**
 * Servlet implementation class ViewEtkinlikTypes
 */
@WebServlet("/ViewEtkinlikTypes")
public class ViewEtkinlikTypes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewEtkinlikTypes() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				String type=request.getParameter("type");
				//System.out.println(type);
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<title> "+type.toUpperCase()+" EVENTS</title>");
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
				
						
				out.println("<h1>"+type.toUpperCase()+"</h1>");
				List<Etkinlik> list=EtkinlikDAO.getRecordsByType(type);
				
				out.print("<table class='table table-bordered table-striped'>");
				out.println("<tr><th>Id</th><th>Event Name</th><th>Type</th><th>Age Rank</th></tr>");
				for(Etkinlik b:list){
					out.println("<tr><td>"+b.getid()+"</td><td>"+b.getEtkinlikIsmi
							()+"</td><td>"+b.getType()+"</td><td>"+b.getYasAraligi()+"</td></tr>");
				}
				out.println("</table>");
				out.close();

	
	}



}
