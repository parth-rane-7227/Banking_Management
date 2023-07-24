package com.bank.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.*;
/**
 * Servlet implementation class Deposit
 */
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		String acnumber = request.getParameter("anumber");
		int amt = Integer.parseInt(request.getParameter("amount"));
		
		if(amt>0)
		{
			try
			{
				Connection con = ConnectDB.getConnect();
				
				PreparedStatement ps1 = con.prepareStatement("select * from account where AccNo=?");
				ps1.setString(1, acnumber);
				ResultSet rs = ps1.executeQuery();
				
				while(rs.next())
				{
					int user_balance = rs.getInt(6);
					int temp = amt + user_balance;
					PreparedStatement ps3 =con.prepareStatement("update account set Balance=? where AccNo=?");
					ps3.setInt(1, temp);
					ps3.setString(2, acnumber);
					int i=ps3.executeUpdate();
					if(i>0)
					{
						response.sendRedirect("Success.html");
					}
					else
					{
						response.sendRedirect("Failed.html");
					}
					
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			response.sendRedirect("Failed.html");
		}
	}
}


