package com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.login.dao.LoginDao;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDao dao=new LoginDao(); 
		String uname=request.getParameter("uname");
		String pass=request.getParameter("password");
		if(dao.check(uname, pass)) {
			HttpSession session=request.getSession();
			session.setAttribute("uname", uname);
			response.sendRedirect("welcome.jsp");
		}
		else
			response.sendRedirect("login.jsp");
		
	}
}
