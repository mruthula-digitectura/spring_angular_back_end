package com.example.springangular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springangular.dao.GroupDao;
import com.example.springangular.entity.Group_table;
import com.example.springangular.pojo.DisplayGroupRequest;
import com.example.springangular.repository.GroupRepository;

@Service
public class GroupService {

	@Autowired
	private GroupDao groupDao;
	@Autowired
	private GroupRepository groupRepository;
	
	
	

	public Group_table save(Group_table group_table) {
		return groupDao.save(group_table);
	}

	public void delete(int group_id) {
		groupDao.delete(group_id);
	}
}