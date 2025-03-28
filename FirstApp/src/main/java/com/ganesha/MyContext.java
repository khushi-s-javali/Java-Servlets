package com.ganesha;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyContext extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out=res.getWriter();
		out.println("Hi");
		//ServletContext cxt=getServletContext();
		//String name=cxt.getInitParameter("Name");
		//out.print(name);
		ServletConfig cg=getServletConfig();
		String name=cg.getInitParameter("Name");
		out.print(name);
	}
}
