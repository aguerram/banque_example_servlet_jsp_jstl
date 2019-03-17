package com.banque.controller;

import java.io.IOException;
import java.sql.Time;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banque.model.User;
import com.banque.model.UserDAO;
import com.banque.model.UserDAOImpl;
import com.banque.service.UserService;

public class HomeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		if (cmd != null && cmd.equals("signout")) {
			Cookie[] cookie = req.getCookies();
			for(Cookie co:cookie)
			{
				if(co.getName().equals("_gtx"))
				{
					co.setMaxAge(0);
					co.setPath("/");
					co.setValue("");
					resp.addCookie(co);
					break;
				}
			}
			resp.sendRedirect(req.getContextPath());
		} else {
			if (UserService.isLoggedin(req) > 0) {
				resp.sendRedirect(req.getContextPath() + "/profile");
			} else {
				req.setAttribute("assets", req.getContextPath() + "/static/assets/");
				RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/jsp/Home.jsp");
				dis.forward(req, resp);
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAOImpl dao = new UserDAOImpl();
		User user = new User();
		user.setEmail((String) req.getParameter("email"));
		user.setPassword((String) req.getParameter("password"));

		int res = dao.login(user);
		if (res > 0) {
			Cookie co = new Cookie("_gtx", "" + res);
			co.setMaxAge(1000 * 60 * 60 * 24 * 6);
			co.setPath("/");
			resp.addCookie(co);
			resp.sendRedirect(req.getContextPath() + "/profile");
		} else {
			req.setAttribute("email", (String) req.getParameter("email"));
			req.setAttribute("msg", "Username or password or incorrect");
			this.doGet(req, resp);
		}

	}
}
