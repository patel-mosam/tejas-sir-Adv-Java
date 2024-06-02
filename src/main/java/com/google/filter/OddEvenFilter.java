package com.google.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/ServletLifeCycle", "/OddEvenFilter"})

public class OddEvenFilter implements Filter{
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

			System.out.println("OddEvenFilter ::doFilter");
		// HttpServletRequest req = (HttpServletRequest)request;
		// validation
		String numStr = request.getParameter("num");

		boolean isError = false;

		if (numStr == null || numStr.trim().length() == 0) {
			isError = true;
			request.setAttribute("numError", "Please Enter Number");
		}
		//
		//
		//

		if (isError == true) {
			// go back
			System.out.println("ERROR");
			RequestDispatcher rd = request.getRequestDispatcher("OddEvenInput.jsp");
			rd.forward(request, response);
		} else {
			// go ahead
			System.out.println("SUCCESS");
			chain.doFilter(request, response);// go to the next filter or requested resource
		}

	}

	public void init(FilterConfig arg0) throws ServletException {

	}
}
