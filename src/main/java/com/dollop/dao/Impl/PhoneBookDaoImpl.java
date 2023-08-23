package com.dollop.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dollop.dao.PhoneBookDAO;
import com.dollop.entity.Contacts;
import com.dollop.entity.User;
import com.dollop.util.DbConnection;

public class PhoneBookDaoImpl implements PhoneBookDAO {

	private static final String INSERT_USER = "INSERT INTO `user`(`Name`, `Email`, `Password`, `Contact`) VALUES (?,?,?,?)" ;
	
	
	
	
	
	
	
	PreparedStatement pstmt = null;
	Connection con=null;
	
	public int login(String email,String password) {
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(SELECT_USER);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				return rs.getInt("ID");
			
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println("not found");
		}
		return 0;
	}

	
	public boolean registration(User u) {
		int affected=0;
		   try{
			   con = DbConnection.getConnection();
			 pstmt = con.prepareStatement(INSERT_USER);
		   }catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   try {
			pstmt.setString(1,u.getName());
			pstmt.setString(2,u.getEmail());
			pstmt.setString(3,u.getPassword());
			pstmt.setString(4,u.getContact());
			affected =pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return affected>0?true:false;
			
	}
	
	
	public boolean logOut(User u)
	{
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(SELECT_USER_BY_UNAME);
			 pstmt.setString(1,u.getName());
			 ResultSet rs = pstmt.executeQuery();
			rs.next();
				  if(rs.getString("uPassword").equals(u.getPassword()))
				  {
					  pstmt = con.prepareStatement(UPDATE_USER_STATUS);
					  pstmt.setInt(1,0);
					  pstmt.setInt(2,rs.getInt("ID"));
					  pstmt.executeUpdate();
					  return true;
		         }
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return false;
	}

	public boolean isLogin(User us) {
		 
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(SELECT_USER_BY_UNAME);
			pstmt.setString(1, us.getName());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				if (rs.getInt("uStatus")==1) 
                       return true;
				
		   }
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public int getUser(String name)
	{
		User us = new User();
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(SELECT_USER_BY_UNAME);
			pstmt.setString(1,name);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return  rs.getInt("ID");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return -1;
	}
	
	public boolean addContact(Contacts cont)
	{
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(INSERT_CONTACT);
			pstmt.setString(1,cont.getName());
			pstmt.setString(2,cont.getEmail());
			pstmt.setString(3,cont.getMobile());
			pstmt.setInt(5,cont.getUserId());
			int affected = pstmt.executeUpdate();
			return affected>0?true:false;
			
		}catch(Exception e)
		{
		  e.printStackTrace();	
		}
		
		return false;
	}

	public List<Contacts> getContacts(int uId) {
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(SELECT_CONTACT_BY_UID);
			pstmt.setInt(1,uId);
			ResultSet rs = pstmt.executeQuery();
			List<Contacts> l = new ArrayList<Contacts>();
			while(rs.next())
			{
				Contacts con = new Contacts();
				con.setId(rs.getInt("ID"));
				con.setName(rs.getString("Name"));
				con.setEmail(rs.getString("Email"));
				con.setMobile(rs.getString("MobileNo"));
				l.add(con);
			}
			return l;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public Contacts getContact(int id)
	{
		Contacts c= new Contacts();
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(SELECT_CONTACT_BY_ID);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				c.setId(rs.getInt("ID"));
				c.setUserId(rs.getInt("uID"));
				c.setName(rs.getString("Name"));
				c.setEmail(rs.getString("Email"));
				
				c.setMobile(rs.getString("MobileNo"));
		
			}
			
		}catch(Exception e)
		{
			
		}
		return c;
	}
	
	public boolean updateContact(Contacts c) {
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(UPDATE_CONTACT_BY_ID);
			pstmt.setString(1,c.getName());
			pstmt.setString(2,c.getEmail());
			pstmt.setString(3,c.getMobile());
			pstmt.setInt(5,c.getId());
			int affected = pstmt.executeUpdate();
			return affected>0?true:false;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public Contacts getContact(String name) {
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(SELECT_CONTACT_BY_NAME);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			Contacts c = new Contacts();
			c.setName(rs.getString("Name"));
			c.setEmail(rs.getString("Email"));
			
			c.setMobile(rs.getString("MobileNo"));
		
			c.setId(rs.getInt("ID"));
			return c;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}


