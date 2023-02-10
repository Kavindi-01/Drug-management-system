package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.util.UserDbUtil;

//servlet implements class AddAgent

public class AddAgent extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	//template method design pattern
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//assign data to given variables
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pnum = request.getParameter("pnum");
		String branch  = request.getParameter("branch");
		
		boolean result = false;
		
		//exception handling using try catch
		try {
			result = UserDbUtil.insertAgent(name, email, pnum, branch);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		//server gives the response to the user
		
		if(result == true) {
			RequestDispatcher rd = request.getRequestDispatcher("DelivaryManager.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("DelivaryManager.jsp");
			rd.forward(request, response);
				
		}
		
	}

}
