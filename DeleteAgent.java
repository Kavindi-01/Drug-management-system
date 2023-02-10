package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.util.AgentDBUtil;

public class DeleteAgent extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		boolean result = false;
		

		try {
			result = AgentDBUtil.deleteAgent(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result == true) {
			RequestDispatcher rd = request.getRequestDispatcher("ViewAgent");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("ViewAgent");
			rd.forward(request, response);
	
		}
	}

}
