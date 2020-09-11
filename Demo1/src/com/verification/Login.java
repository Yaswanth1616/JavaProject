package com.verification;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","system");
			String s="select username,password,type from login";
			PreparedStatement smt=con.prepareStatement(s);
			ResultSet rs=smt.executeQuery();
			int flag=0;
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+username+" "+password);
				if(rs.getString(1).equals(username)&&rs.getString(2).equals(password))
				{
					System.out.println("checked");
					if(rs.getString(3).equals("Buyer"))
					{
						RequestDispatcher req=request.getRequestDispatcher("Buyer.html");
						req.forward(request,response);
						flag=1;
						break;
					}
					else
					{
						RequestDispatcher req=request.getRequestDispatcher("Owner.html");
						req.forward(request,response);
						flag=1;
						break;
					}
				}
			}
			con.commit();
			con.close();
			System.out.println("Yaswanth");
			//response.sendRedirect("file:///C:/Users/lenovo/Desktop/WTN-2/project2/Owner.html");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
