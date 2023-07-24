package com.bank.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class RegisterUser
 */
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
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
		
		String first_name = request.getParameter("fname");
		String last_name = request.getParameter("lname");
		String user_contact = request.getParameter("contact");
		String user_address = request.getParameter("address");
		String user_anumber = request.getParameter("acnumber");
		int user_balance = Integer.parseInt(request.getParameter("acbalance"));
		String user_email = request.getParameter("email");
		String user_password = request.getParameter("password");
		
		try
		{
			Connection con = ConnectDB.getConnect();
			
			PreparedStatement ps1 = con.prepareStatement("insert into account values(?,?,?,?,?,?,?,?)");
			ps1.setString(1, first_name);
			ps1.setString(2, last_name);
			ps1.setString(3, user_contact);
			ps1.setString(4, user_address);
			ps1.setString(5, user_anumber);
			ps1.setInt(6, user_balance);
			ps1.setString(7, user_email);
			ps1.setString(8, user_password);
			
			int i = ps1.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("RSuccess.html");
			}
			else
			{
				response.sendRedirect("Failed.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
