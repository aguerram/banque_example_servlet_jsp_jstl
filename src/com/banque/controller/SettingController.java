package com.banque.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banque.model.User;
import com.banque.model.UserDAO;
import com.banque.model.UserDAOImpl;
import com.banque.service.UserService;


@WebServlet("/settings")
public class SettingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = UserService.isLoggedin(request);
		if(userid > 0)
		{
			UserDAO dao = new UserDAOImpl();
			User user = dao.getByID(userid);
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/Settings.jsp");
			request.setAttribute("assets", request.getContextPath()+"/static/assets/");
			request.setAttribute("user", user);
			request.setAttribute("goback", request.getContextPath()+"/profile");
			dis.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath());
		}
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userid = UserService.isLoggedin(req);
		if(userid > 0)
		{
			User user = new User();
			user.setEmail(req.getParameter("email"));
			user.setNom(req.getParameter("nom"));
			user.setPrenom(req.getParameter("prenom"));
			user.setPassword(req.getParameter("password"));
			
			
			UserDAO dao = new UserDAOImpl();
			boolean success = dao.update(userid, user);
			if(success)
				req.setAttribute("msg", "Your informations have been updated succesfuly");
			else {
				req.setAttribute("msg", "Something went wrong");
			}
		}
		
		this.doGet(req, resp);
	}

}
