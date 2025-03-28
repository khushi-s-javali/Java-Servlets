<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.shopping.Item, java.util.List"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Item</title>
</head>
<body>
<h1>Add your item here</h1>
	<form method="post" action="AddItem">
	<label>Enter item name:</label>
	<input type="text" name="itemname"><br>
	<label>Enter quantity:</label>
	<input type="number" name="quantity"><br>
	<label>Enter unit:</label>
	<input type="text" name="units"><br>
	<input type="submit" value="Add">
	</form>
	<%
    Boolean add = (Boolean) request.getAttribute("add");
    if (add != null && add) {
%>
    <p>Item added successfully!</p>
    <h2>Item Details</h2>
<table border="1">
    <thead>
        <tr>
            <th>Sl No</th>
            <th>Item Name</th>
            <th>Required</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Item> items = (List<Item>) request.getAttribute("items");
            if (items != null && !items.isEmpty()) {
                int serialNumber = 1;
                for (Item item : items) {
        %>
                    <tr>
                        <td><%= serialNumber++ %></td> 
                        <td><%= item.getItemname() %></td>
                        <td><%= item.getQuantity() %> <%= item.getUnits() %></td>
                    </tr>
        <%
                }
            } else {
        %>
                <tr>
                    <td colspan="3">No items found.</td>
                </tr>
        <%
            }
        %>
    </tbody>
</table>
<%
    } else if (request.getParameter("itemname") != null) {
%>
    <p>Failed to add item.</p>
<%
    }
%>
</body>
</html>