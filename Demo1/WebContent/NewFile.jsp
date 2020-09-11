<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<html>
<% 
byte[] imgData = null;
%>
<%
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con =  
DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","system");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select image from Owner4");
response.setContentType("image/png");
OutputStream o = response.getOutputStream();
while(rs.next()) {
Blob image = rs.getBlob(1);
imgData = image.getBytes(1,(int)image.length());
System.out.println("abc");
%>
<img="<%o.write(imgData);%>" width="10" height="20">
<br>
<% 
 }
// display the image

%>


<%
} catch (Exception e) {
out.println("Unable To Display image");
out.println("Image Display Error=" + e.getMessage());
return;
} 

%>