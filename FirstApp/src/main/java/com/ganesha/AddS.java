package com.ganesha;

import java.io.IOException;

import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/add")
public class AddS extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i=Integer.parseInt(req.getParameter("n1"));
		int j=Integer.parseInt(req.getParameter("n2"));
		int k;
		k=i+j;
		//PrintWriter out=res.getWriter();
		//out.println("Sum= "+k);
		//req.setAttribute("k", k);
		//RequestDispatcher rd=req.getRequestDispatcher("sq");
		//rd.forward(req, res);
		//res.sendRedirect("sq?k="+k);
		//HttpSession session=req.getSession();
		//session.setAttribute("k", k);
		//res.sendRedirect("sq");
		Cookie cookie= new Cookie("k",k+"");
		res.addCookie(cookie);
		res.sendRedirect("sq");
		}
}