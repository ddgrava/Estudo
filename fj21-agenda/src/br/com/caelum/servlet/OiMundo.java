package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OiMundo extends HttpServlet {

@Override
public void service(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	
	//escreve o texto
	
	out.println("<html>");
	out.println("<body>");
	out.println("Oi mundo!");
	out.println("</body>");
	out.println("</html>");
	
}
}