package com.banque.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banque.DAO.DAO;

public class MoneyDAOImpl extends DAO{
	public MoneyDAOImpl()
	{
		super();
	}
	public boolean save(Money m)
	{
		try {
			PreparedStatement ps = this.conn.prepareStatement("insert into money(userid,amount) values(?,?)");
			ps.setInt(1,m.getUserid());
			ps.setDouble(2, m.getAmount());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Money> getByUserID(int id)
	{
		List<Money> list = new ArrayList<Money>();
		
		try {
			ResultSet re = this.conn.createStatement().executeQuery("select * from money where userid = "+id+" order by id desc");
			
			while(re.next())
			{
				Money money = new Money();
				money.setId(re.getInt(1));
				money.setUserid(id);
				money.setAmount(re.getDouble(3));
				money.setAt(String.valueOf(re.getTimestamp(4)));
				list.add(money);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
