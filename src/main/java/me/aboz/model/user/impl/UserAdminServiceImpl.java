package me.aboz.model.user.impl;

import java.util.List;

import me.aboz.data.domain.User;
import me.aboz.data.repository.UserRepository;
import me.aboz.model.user.IUserAdminService;

import org.apache.commons.lang3.StringUtils;

public class UserAdminServiceImpl implements IUserAdminService {

	UserRepository userRepository;
	
	public void setUserRepository(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	@Override
	public User create(User user) {
		if(StringUtils.isEmpty(user.getUserName())){
			return null;
		}
		return this.userRepository.save(user);
	}

	@Override
	public List<User> listAll() {
		return this.userRepository.findAll();
	}

	@Override
	public long total() {
		return this.userRepository.count();
	}
	
}
