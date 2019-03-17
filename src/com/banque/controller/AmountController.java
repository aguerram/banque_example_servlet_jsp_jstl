package com.banque.controller;

import java.io.IOException;
import java.util.Random;

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

/**
 * Servlet implementation class AmountController
 */
@WebServlet("/amount")
public class AmountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AmountController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = UserService.isLoggedin(request);
		if(userid > 0)
		{
			String type= request.getParameter("type");
			int times = 1;
			
			if(type != null && type.equals("remove"))
				times = -1;
			MoneyDAOImpl dao = new MoneyDAOImpl();
			Money money = new Money();
			money.setUserid(userid);
			money.setAmount(Math.round(Math.random()*100) * times);
			boolean success = dao.save(money);
			if(success)
			{
				request.setAttribute("msg", "Password updated");
			}
			else {
				request.setAttribute("msg", "Not updated");
			}
			RequestDispatcher ds = request.getRequestDispatcher("Profile");
			ds.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath());
		}
		
	}


}
