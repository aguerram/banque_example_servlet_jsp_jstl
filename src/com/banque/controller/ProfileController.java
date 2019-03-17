package com.banque.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banque.model.Money;
import com.banque.model.MoneyDAOImpl;
import com.banque.model.User;
import com.banque.model.UserDAO;
import com.banque.model.UserDAOImpl;
import com.banque.service.UserService;

public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("assets", req.getContextPath()+"/static/assets/");
		int id = UserService.isLoggedin(req);
		if(id > 0)
		{
			MoneyDAOImpl dao = new MoneyDAOImpl();
			UserDAO user_dao = new UserDAOImpl();
			System.out.println(req.getPathInfo());
			
			List<Money> history = dao.getByUserID(id);
			req.setAttribute("history", history);
			req.setAttribute("amount", UserService.totalAmount(history));
			RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/jsp/Profile.jsp");
			req.setAttribute("signout", req.getContextPath()+"?cmd=signout");
			req.setAttribute("settings", req.getContextPath()+"/settings");
			req.setAttribute("user", user_dao.getByID(id));
			dis.forward(req, resp);
		}
		else {
			resp.sendRedirect(req.getContextPath());
		}
		
	}
}
