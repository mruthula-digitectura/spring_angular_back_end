package com.example.springangular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springangular.dao.UserDao;
import com.example.springangular.entity.User_details_table;
import com.example.springangular.pojo.DisplayGroupRequest;
import com.example.springangular.pojo.UserDisplayRequest;
import com.example.springangular.pojo.UserLogService;
import com.example.springangular.repository.GroupRepository;
import com.example.springangular.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRepository userRepository;

	public List<UserDisplayRequest> get() {
		return userRepository.findUserGroupLight();
		
	}
	


	public User_details_table save(User_details_table user_details_table) {
		return userDao.save(user_details_table);
	}

	public void delete(int user_id) {
		userDao.delete(user_id);
	}
}