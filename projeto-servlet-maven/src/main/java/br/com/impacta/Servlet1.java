/**
 * 
 */
package br.com.impacta;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Servlet1 extends HttpServlet {

	private String message;

	public void init() throws ServletException {
		message = "Hello World";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("Servlet config called");
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
	}

	public void destroy() {
		
	}

}
