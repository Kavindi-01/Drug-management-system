package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.model.Agent;
import com.util.AgentDBUtil;
public class ViewAgent extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	//using template method design pattern
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Agent>result = null;
		
		//exception handling
		try {
			result  = AgentDBUtil.getAgent();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
		request.setAttribute("AgentDetails", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("viewAgent.jsp");
		rd.forward(request, response);
				
		}
	}


