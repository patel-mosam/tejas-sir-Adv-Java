package com.google.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/OddEvenServlet")
public class OddEvenServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside OddEven Servlet....");
		String numStr = request.getParameter("num");
	
		int num = Integer.parseInt(numStr);//method 2 
	
		if(num%2==0) {
			request.setAttribute("msg", "EVEN");
		}else {
			request.setAttribute("msg", "ODD");
		}
		
		request.setAttribute("num", num);
		
		RequestDispatcher rd = request.getRequestDispatcher("OddEvenOutput.jsp");
		rd.forward(request, response);
		
		
	}
}
