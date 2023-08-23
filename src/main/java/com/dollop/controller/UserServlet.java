package com.dollop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dollop.dao.PhoneBookDAO;
import com.dollop.dao.Impl.PhoneBookDaoImpl;
import com.dollop.entity.User;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getParameter("action"); 
		switch(action)
		{
		    case "createAccount":
			      createAccount(request, response);
			      break;
		    case "login":
			      login(request, response);
			      break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PhoneBookDAO ph = new PhoneBookDaoImpl();
		HttpSession session = request.getSession();
		int id = ph.login(email,password);
		if(id>0)
		{
			    session.setAttribute("login",id);
				request.setAttribute("msg","Login Success");
				RequestDispatcher rd=request.getRequestDispatcher("./dashboard.jsp");
				rd.forward(request, response);
		}
		else
			response.getWriter().append("LOGIN FAILED");
		response.getWriter().append("Served at: ").append(request.getContextPath());	
	}

	private void createAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User us = new User(request.getParameter("name"), request.getParameter("email"), request.getParameter("MobileNo"),
				request.getParameter("password"));
		PhoneBookDAO ph = new PhoneBookDaoImpl();
		if (us.getPassword().equals(request.getParameter("cpassword"))) {
			if (ph.registration(us)) {
				response.getWriter().append("REGISTRATION SUCCESSFULL");
				response.sendRedirect("./index.jsp");
			} else {
				response.getWriter().append("REGISTRATION FAILED");
			}
		} else
			response.getWriter().append("REGISTRATION FAILED PASSWORD DOESN'T MATCH");
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
