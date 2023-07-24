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
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
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
		
		String accno = request.getParameter("anumber");
		String pass = request.getParameter("password");
		
		try
		{
			Connection con = ConnectDB.getConnect();
			PreparedStatement ps1 = con.prepareStatement("delete from account where AccNo=? and Password=? ");
			
			ps1.setString(1, accno);
		
			ps1.setString(2, pass);
			int i = ps1.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("DelSuccess.html");
				
				
			}
			else
			{
				response.sendRedirect("DeleteUser.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
