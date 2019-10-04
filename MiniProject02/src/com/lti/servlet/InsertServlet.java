package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.miniproject02.ProfessionalCollege;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=null;
		PreparedStatement stmt=null;
		//ResultSet rs=null;
		
		PrintWriter out = response.getWriter(); 
		
		 try { 
			 Integer cid=(Integer) request.getAttribute("cid");
		     String cname=request.getParameter("cname");
		     String coursetype=request.getParameter("coursetype");
		     String city=request.getParameter("city");
		     Integer fees=(Integer) request.getAttribute("fees");
		     Integer pincode=(Integer) request.getAttribute("pincode");
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sys as sysdba","Newuser123");
				    ProfessionalCollege p = new ProfessionalCollege();
					
					String sql="Insert into ProfessionalColleges(CID,CNAME,COURSETYPE,CITY,FEES,PINCODE) VALUES(?,?,?,?,?,?)";
				    stmt=conn.prepareStatement(sql);
				   
				     stmt.setInt(1, p.getCid());
				     stmt.setString(2,p.getCname());
				     stmt.setString(3,p.getCoursetype());
				     stmt.setString(4,p.getCity());
				     stmt.setFloat(5, p.getFees());
				     stmt.setInt(6, p.getPincode());
				     
				     //rs=stmt.executeQuery();
				     stmt.executeUpdate();
				    
				        out.println("<br>Record has been inserted");
				      
			
	            
	            //conn.close(); 
	        } 
	        catch (Exception e) { 
	            e.printStackTrace(); 
	}

	}
}


