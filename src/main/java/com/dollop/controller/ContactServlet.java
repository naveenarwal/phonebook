package com.dollop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dollop.dao.PhoneBookDAO;
import com.dollop.dao.Impl.PhoneBookDaoImpl;
import com.dollop.entity.Contacts;

/**
 * Servlet implementation class ContactServlet
 */
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch(request.getParameter("action"))
	    {
		     case "addContact":
		             	addContact(request, response);
			            break;
		     case "editContact":
		    	       editContact(request, response);
		    	       break;
	
	    }
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void editContact(HttpServletRequest request, HttpServletResponse response) {
	    
		
	}

	private void addContact(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Contacts con = new Contacts(request.getParameter("name"),request.getParameter("email"),request.getParameter("MobileNo"));
		PhoneBookDAO ph = new PhoneBookDaoImpl();
		HttpSession session = request.getSession();
		con.setUserId((Integer)session.getAttribute("login"));
		if(ph.addContact(con))
		{
			response.getWriter().append("ADDED SUCCESSFULLY");
			response.sendRedirect("./dashboard.jsp");
		}
		else
		response.getWriter().append("FAILED");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
