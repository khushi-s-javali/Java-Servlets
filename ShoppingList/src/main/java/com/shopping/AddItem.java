package com.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddItem
 */
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ItemDao iadd=new ItemDao();
		Item i=new Item();
		i.setItemname(request.getParameter("itemname"));
		//PrintWriter out=response.getWriter();
		//out.println("working");
		//out.print(i.getItemname());
		i.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		i.setUnits(request.getParameter("units"));
		try {
			boolean add = iadd.add(i);
			List<Item> items= iadd.fetch();
			request.setAttribute("add", add);
			request.setAttribute("items", items);
			RequestDispatcher rd=request.getRequestDispatcher("add.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
