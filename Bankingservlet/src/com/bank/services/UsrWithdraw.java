package com.bank.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsrWithdraw
 */
public class UsrWithdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsrWithdraw() {
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
	
		int amt = Integer.parseInt(request.getParameter("amt"));
		if(amt>0)
		{
			try
				{
					Connection con = ConnectDB.getConnect();
					PreparedStatement ps2 = con.prepareStatement("select * from account where Email=? and Password=?");
					ps2.setString(1, UserData.getEmail());
					ps2.setString(2, UserData.getPass());
				    ResultSet rs = ps2.executeQuery();
			
						while(rs.next())
						{
							int user_balance = rs.getInt(6);
							if(user_balance>4999) //|| user_balance>amt)
								{
									int temp = user_balance - amt;
									PreparedStatement ps3 =con.prepareStatement("update account set Balance=? where Email=?");
									ps3.setInt(1, temp);
									ps3.setString(2, UserData.getEmail());
									int i=ps3.executeUpdate();
								
									if(i>0)
										{
											response.sendRedirect("UWSuccess.html");
										}
									else
										{
									System.out.println("Failed.html");
										}
								}
							else
								{
								response.sendRedirect("Not.html");
								}
						}
				}
		
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
	
	
	
	}

}
