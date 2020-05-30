package com.example.springangular.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springangular.repository.UserRepository;
import com.example.springangular.entity.User_details_table;



@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public List<User_details_table> get() {
		return userRepository.findAll();
	}

	public User_details_table save(User_details_table user_details_table) {
		return userRepository.save(user_details_table);
	}

	public void delete(int user_id) {
		userRepository.deleteById(user_id);
	}
}