package com.shopping;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 * Servlet implementation class UpdateItem
 */
public class UpdateItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = request.getReader();
	    String json = reader.lines().collect(Collectors.joining());
	    Gson gson = new Gson();
	    JsonObject data = gson.fromJson(json, JsonObject.class);
	    int id = data.get("id").getAsInt();
	    Item i=new Item();
	    ItemDao iupdate=new ItemDao();
		i.setItemname(data.get("itemName").getAsString());
		i.setQuantity(data.get("quantity").getAsInt());
		i.setUnits(data.get("units").getAsString());
		try {
			boolean updated = iupdate.update(i,id);
			if (updated) {
                response.getWriter().write("Item updated successfully.");
            } else {
                response.getWriter().write("Failed to update item.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
