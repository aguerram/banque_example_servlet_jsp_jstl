package com.banque.service;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.banque.model.Money;

public class UserService {
	public static int isLoggedin(HttpServletRequest req)
	{
		Cookie[] cookies =  req.getCookies();
		if(cookies == null)
			return 0;
		int id=0;
		for(Cookie co:cookies)
		{
			if(co.getName().equals("_gtx"))
			{
				id = Integer.parseInt(co.getValue());
			}
		}
		return id;
	}
	public static double totalAmount(List<Money> list)
	{
		double total = 0;
		
		for(int i = 0;i<list.size();i++)
		{
			total += list.get(i).getAmount();
		}
		return total;
	}
}
