package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.model.order;
import com.util.PaymentDBUtil;

public class ViewOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		
		
		List<order>result = null;
		
		try {
			result = PaymentDBUtil.getOrders();
			
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		
		request.setAttribute("OrderDetails", result);
		RequestDispatcher rd = request.getRequestDispatcher("ViewOrders.jsp");
		rd.forward(request, response);
		
	}

}
