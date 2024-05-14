package com.comcast.crm.generic.databseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Databaseutility {
	Connection con;
	public void getDbConnection(String url,String username,String password) throws SQLException
	{
		try
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			 con = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {}
		}
	public void getDbConnection() throws SQLException
	{
		try
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			 con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root", "root");
		}catch(Exception e) {}
		}
	public void closeDbConnection() throws SQLException
	{
		try
		{
			con.close();
		}catch(Exception e) {}
	}
public ResultSet executeConSelectQuery(String query) throws SQLException
{
	ResultSet result=null;
	try
	{
		Statement stat = con.createStatement();
		 result = stat.executeQuery(query);

	}catch(Exception e) {}
		return result; 
}
public int executeConNonSelectQuery(String query) throws SQLException
{
	int result=0;
	try
	{
		Statement stat = con.createStatement();
		 result = stat.executeUpdate(query);

	}catch(Exception e) {}
		return result; 
}

}
