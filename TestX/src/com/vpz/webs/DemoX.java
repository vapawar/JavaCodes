package com.vpz.webs;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test26.DataOps;

@WebServlet("/DemoX")
public class DemoX extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public DemoX() 
    {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DataOps dops=new DataOps();
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String str1=request.getParameter("input");
		String str2=request.getParameter("action");
		
		if(str2.equals("reverse"))
			out.write("String "+str2+" is : "+dops.getReverse(str1));	
		else if(str2.equals("lower"))
			out.write("String "+str2+" is : "+dops.getLower(str1));
		else if (str2.equals("upper"))
			out.write("String "+str2+" is : "+dops.getUpper(str1));
		else
		{
			out.write("Wrong data operation");
			request.getRequestDispatcher("/home.htm").include(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
