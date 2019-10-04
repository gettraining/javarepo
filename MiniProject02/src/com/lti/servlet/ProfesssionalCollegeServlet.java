package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.miniproject.dao.DataAccessException;
import com.lti.miniproject.dao.ProfessionalCollegeDao;
import com.lti.miniproject02.ProfessionalCollege;



/**
 * Servlet implementation class ProfessionalCollegeServlet
 */
@WebServlet("/ProfessionalCollegeServlet")
public class ProfesssionalCollegeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		ProfessionalCollegeDao college=new ProfessionalCollegeDao();
		List<ProfessionalCollege> list=new ArrayList<ProfessionalCollege>();
		out.print("<table border='1' cellpadding='4' width='60%'>");  
	    out.print("<tr><th>CId</th><th>CName</th><th>CourseType</th><th>City</th><th>Fees</th><th>Pincode</th>");  
		
	    try {
			   list=college.fetch();
			   for(ProfessionalCollege c:list)
			   {
			     out.println("<tr><td>"+c.getCid()+"</td><td>"+c.getCname()+"</td><td>"+c.getCoursetype()+"</td><td>"+c.getCity()+"</td><td>"+c.getFees()+"</td><td>"+c.getPincode()+"</td></tr>");
			     
		       } 
	    }
		
		catch (Exception e) {
			
		}
	    
	    out.print("</table>"); 
	
	}

	}

	

