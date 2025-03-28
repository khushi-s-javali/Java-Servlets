package com.shopping;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class DeleteItem
 */
public class DeleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = request.getReader();
	    String json = reader.lines().collect(Collectors.joining());
	    Gson gson = new Gson();
	    JsonObject data = gson.fromJson(json, JsonObject.class);
	    int id = data.get("id").getAsInt();
	    ItemDao idelete=new ItemDao();
	    try {
			boolean deleted=idelete.delete(id);
			if (deleted) {
                response.getWriter().write("Item deleted successfully.");
            } else {
                response.getWriter().write("Failed to delete item.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
