package com.bank.services;

import java.sql.*;

public class ConnectDB 
{
	static Connection con = null;
		
		public static Connection getConnect()
		{
			try 
			{	
				Class.forName("com.mysql.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksoft", "root", "");
			
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return con;
		}
	}



