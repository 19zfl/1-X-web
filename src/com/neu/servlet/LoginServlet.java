package com.neu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.User;
import com.neu.service.UserService;

/**
 * 登录Servlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       

	/**
	 * 登录验证
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//代码编写处
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println(userName+","+password);
		UserService us = new UserService();
		User user = us.getUser(userName);

		HttpSession session = request.getSession();
		if (user!=null&&user.getPassword().equals(password)) {
			session.setAttribute("user",userName);
			response.sendRedirect("users");
		}
		else response.sendRedirect("login.jsp");
		
		
	}

}
