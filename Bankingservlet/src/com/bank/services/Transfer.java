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
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
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
		
		String S_accno = request.getParameter("sanumber");
		String R_accno = request.getParameter("ranumber");
		int amt = Integer.parseInt(request.getParameter("amount"));
		
		
		if(amt>0)
		{
			try
			{
				
				
				Connection con = ConnectDB.getConnect();
				PreparedStatement ps2 = con.prepareStatement("select Balance from account where AccNo =?");
				ps2.setString(1, S_accno);
			    ResultSet rs = ps2.executeQuery();
				
			    while(rs.next())
				{
					int user_balance = rs.getInt(1);
					if(user_balance>0) //|| balance>amount)
						{
							int temp = user_balance - amt;
							
							PreparedStatement ps3 =con.prepareStatement("update account set Balance=? where AccNo=?");
							ps3.setInt(1, temp);
							ps3.setString(2, S_accno);
							ps3.executeUpdate();
							//System.out.println(S_accno+" updated balance is "+temp);
							response.sendRedirect("TSuccess.html");
							
							
							PreparedStatement ps4=con.prepareStatement("select Balance from account where AccNo=?");
							ps4.setString(1, R_accno);
							ResultSet rs1=ps4.executeQuery();
							
							while(rs1.next())
							{
								int temp1=rs1.getInt(1) + amt;
								
								PreparedStatement ps10=con.prepareStatement("update account set Balance=? where AccNo=?");
								ps10.setInt(1, temp1);
								ps10.setString(2, R_accno);
								ps10.executeUpdate();
								//System.out.println(R_accno+" updated balance is "+temp1);
								response.sendRedirect("TSuccess.html");
							}	
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
				response.sendRedirect("Not.html");
			}
		}
		
		
	}


