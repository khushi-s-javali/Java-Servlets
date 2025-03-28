<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.shopping.Item, java.util.List"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Shopping List</title>
    <script>
        // Enable inline editing for a row
        function enableEdit(rowId) {
            const row = document.getElementById(rowId);
            const itemName = row.querySelector(".itemname");
            const quantity = row.querySelector(".quantity");
            const units = row.querySelector(".units");
            const saveBtn = row.querySelector(".save-btn");
            const editBtn = row.querySelector(".edit-btn");

            // Make fields editable
            itemName.contentEditable = "true";
            quantity.contentEditable = "true";
            units.contentEditable = "true";

            // Focus on the first editable field
            itemName.focus();

            // Show Save button and hide Edit button
            saveBtn.style.display = "inline";
            editBtn.style.display = "none";
        }

        // Save updated row data
        function saveRow(rowId, itemId) {
            const row = document.getElementById(rowId);
            const itemName = row.querySelector(".itemname").innerText.trim();
            const quantity = row.querySelector(".quantity").innerText.trim();
            const units = row.querySelector(".units").innerText.trim();

            // Send updated data to the server using AJAX
            fetch('UpdateItem', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ id: itemId, itemName, quantity, units })
            })
            .then(response => response.text())
            .then(data => {
                alert(data);

                // Disable editing
                row.querySelector(".itemname").contentEditable = "false";
                row.querySelector(".quantity").contentEditable = "false";
                row.querySelector(".units").contentEditable = "false";

                // Toggle buttons
                row.querySelector(".save-btn").style.display = "none";
                row.querySelector(".edit-btn").style.display = "inline";
            })
            .catch(error => console.error('Error:', error));
        }

        // Delete a row
        function deleteRow(itemId) {
            if (confirm("Are you sure you want to delete this item?")) {
                fetch('DeleteItem', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ id: itemId })
                })
                .then(response => response.text())
                .then(data => {
                    alert(data);
                    // Reload the page to update the list
                    location.reload();
                })
                .catch(error => console.error('Error:', error));
            }
        }
    </script>
</head>
<body>
    <h1>Shopping List</h1>
    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>Sl No</th>
                <th>Item Name</th>
                <th>Required</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Item> items = (List<Item>) request.getAttribute("items");
                if (items != null && !items.isEmpty()) {
                    int serialNumber = 1;
                    for (Item item : items) {
            %>
                        <tr id="row<%= serialNumber %>">
                            <td><%= serialNumber++ %></td>
                            <td class="itemname"><%= item.getItemname() %></td>
                            <td>
                                <span class="quantity"><%= item.getQuantity() %></span> 
                                <span class="units"><%= item.getUnits() %></span>
                            </td>
                            <td>
                                <button class="edit-btn" onclick="enableEdit('row<%= serialNumber - 1 %>')">Edit</button>
                                <button class="save-btn" onclick="saveRow('row<%= serialNumber - 1 %>', <%= serialNumber-1 %>)" style="display:none;">Save</button>
                            </td>
                            <td>
                                <button onclick="deleteRow(<%= serialNumber-1 %>)">Delete</button>
                            </td>
                        </tr>
            <%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="5">No items found.</td>
                    </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
