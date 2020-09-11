package com.register;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","system");
			String s="insert into login values(?,?,?,?,?)";
			PreparedStatement smt=con.prepareStatement(s);
			smt.setString(1,request.getParameter("username"));
			smt.setString(2,request.getParameter("password"));
			smt.setString(3,request.getParameter("type"));
			smt.setString(4,request.getParameter("email"));
			smt.setString(5,request.getParameter("phoneNumber"));
			smt.executeUpdate();
			con.commit();
			con.close();
			System.out.println("succesful");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
