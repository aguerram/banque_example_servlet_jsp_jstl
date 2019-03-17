package com.banque.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.banque.DAO.DAO;

public class UserDAOImpl extends DAO implements UserDAO {

	public UserDAOImpl() {
		super();
	}
	
	@Override
	public List<User> getAll() {
		return null;
	}

	@Override
	public User getByID(int id) {
		User user = new User();
		try {
			ResultSet rs = this.conn.createStatement().executeQuery("select * from user where id = "+id);
			if(rs.next())
			{
				user.setId(rs.getInt(1));
				user.setNom(rs.getString(2));
				user.setPrenom(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean save(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int id, User user) {
		try {
			PreparedStatement ps = this.conn.prepareStatement("update user set nom=?,prenom=?,email=?,password=? where id = "+id);
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int login(User u) {
		try {
			PreparedStatement ps = this.conn.prepareStatement("select id from user where email =  ? and password = ?");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ResultSet rs= ps.executeQuery();
			if(rs.first())
			{
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
