<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.jstl.Student" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
</head>
<body>
    <h2>Student List</h2>
    <c:out value="Hi"/>
    <% 
    @SuppressWarnings("unchecked")
       List<Student> students = (List<Student>) request.getAttribute("students");
       if (students != null) {
           for (Student student : students) { 
    %>
       Roll No: <%= student.getRollno() %><br/>
       Name: <%= student.getName() %><br/><br/>
    <% 
           } 
       } else { 
    %>
       <p>No students found.</p>
    <% 
       } 
    %>
</body>
</html>
