<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.shopping.Item"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShoppingList</title>
</head>
<body>
	<h1>Search your item here</h1>
	<form method="post" action="searchItem">
	<label>Enter item name:</label>
	<input type="text" name="itemname">
	<input type="submit" value="Search">
	</form>
	<%
		Item item=(Item)request.getAttribute("item");
	if(item!=null){
	%>
	<h2>Item Details</h2>
        <p>Name: <%= item.getItemname() %></p>
        <p>Required: <%= item.getQuantity()%>&nbsp;<%= item.getUnits() %></p>
    <%
        } else if (request.getParameter("itemname") != null) {
    %>
        <p>No item found with the given name.</p>
    <%
        }
    %>
</body>
</html>