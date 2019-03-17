package com.banque.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	protected Connection conn;
	public DAO()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/banqueservlet","root","");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
}
