package me.aboz.model.user;

import java.util.List;

import me.aboz.data.domain.User;

public interface IUserAdminService {

	public User create(User user);
	
	public List<User> listAll();
	
	public long total();
}
