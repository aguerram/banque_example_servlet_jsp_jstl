package com.banque.model;

import java.util.List;

public interface UserDAO {
	public List<User> getAll();
	public User getByID(int id);
	public boolean save(User u);
	public boolean update(int id,User u);
	public boolean delete(int id);
	
	public int login(User u);
	
}
