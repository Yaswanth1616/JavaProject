<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Property.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con =  
DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","system");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select name,address,price,owner from Property");

PrintWriter out1=response.getWriter();
%>
 <table>
 <caption>Property List</caption>
 	<tr>
 		<th>Property Name</th>
 		<th>Property Address</th>
 		<th>Property Price</th>
 		<th>Property Owner</th>
 	</tr>
<% 
	while(rs.next())
	{
		
	  %>
	   <tr>
 			<td><%out.println(rs.getString(1));%></td>
 			<td><%out.println(rs.getString(2));%></td>
 			<td><%out.println(rs.getFloat(3));%></td>
 			<td><%out.println(rs.getString(4));%></td>
 		</tr>
	  <% 
	}
%> </table><% 
}
catch(Exception e)
{
 	
}

%>

</body>
</html>