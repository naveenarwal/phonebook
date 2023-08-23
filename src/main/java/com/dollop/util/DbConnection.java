package com.dollop.util;

	import java.sql.Connection;
	import java.sql.DriverManager;

	public class DbConnection {
		private static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
		private static final String DB_USER="root";
		private static final String DB_PSW="";
		private static final String DB_URL="jdbc:mysql://localhost:3306/Advance1";
		private static Connection con=null;
		public static Connection getConnection()throws Exception{
		if(con!=null)
		{
			return con;
		}
		else
		 
			return getConnection(DB_URL,DB_USER,DB_PSW);
		}
		private static Connection getConnection(String dbUrl,String dbUser,String dbpsw)throws Exception{
			
			Class.forName(DB_DRIVER);
			con=DriverManager.getConnection(dbUrl, dbUser, dbpsw);
			return con;
		}

	}


