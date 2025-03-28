<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 21 <br>
 Ganesha <br>
 100 <br>
 <%
 String url="jdbc:mysql://localhost:3306/validate";
	String upiid="root";
	String upipin="rootKSJ123";
	Class.forName("com.mysql.cj.jdbc.Driver");
 Connection con=DriverManager.getConnection(url,upiid,upipin);
 String QUERY = "SELECT * FROM upiinfo";
 Statement st= con.createStatement();
 ResultSet rs = st.executeQuery(QUERY);
 while (rs.next()) {
	 %>
	     <p><%= rs.getString(2) %></p> 
	 <%
	     }
 %>
</body>
</html>