package com.google.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/NameServlet")
public class NameServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String firstName = request.getParameter("firstName");
		firstName = firstName.toUpperCase();

		System.out.println(firstName);

		PrintWriter out = response.getWriter();

		out.println(firstName); 
	}
}
