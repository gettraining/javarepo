package com.lti.miniproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lti.miniproject02.ProfessionalCollege;

//import com.lti.exception.DataAccessException;
//import com.lti.model.Product;


	//Data Access Object
	//classes which contain code to interact
	//with the DB are commonly referred to as
	//DAO classes
	public class ProfessionalCollegeDao {
		public List<ProfessionalCollege> fetch() throws DataAccessException //user defined exception
		{
			Connection conn=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			try{
				//Step 1:Load the JDBC driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//Step 2:Establish connection with db
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sys as sysdba","Newuser123");
			    String sql="Select * from ProfessionalColleges where coursetype='ENGG' ";
			    stmt=conn.prepareStatement(sql);
			   // stmt.setInt(1,from);//1=1st question mark
			   // stmt.setInt(2,to);//2=2nd question mark
			    rs=stmt.executeQuery();
			    
			    
			    List<ProfessionalCollege> list=new ArrayList<ProfessionalCollege>();
				while(rs.next()){//goes to next line
					ProfessionalCollege college=new ProfessionalCollege();
					college.setCid(rs.getInt(1));
			    	college.setCname(rs.getString(2));
			    	college.setCoursetype(rs.getString(3));	
			    	college.setCity(rs.getString(4));
			    	college.setFees(rs.getFloat(5));
			    	college.setPincode(rs.getInt(6));	
					list.add(college);//adding result from query to list
			    				    	
			    }
			    return list;
			  
		}
			catch(Exception e){
				throw new DataAccessException("Problem while fetching",e);
						
			}
			finally{
				try{rs.close();}catch(Exception e){}
				try{stmt.close();}catch(Exception e){}
				try{conn.close();}catch(Exception e){}
				
			}
	}
}

