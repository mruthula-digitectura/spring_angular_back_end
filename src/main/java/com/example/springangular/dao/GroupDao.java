package com.example.springangular.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springangular.repository.GroupRepository;
import com.example.springangular.entity.Group_table;
import com.example.springangular.pojo.DisplayGroupRequest;



@Repository
public class GroupDao {

	@Autowired
	private GroupRepository groupRepository;

	
	

	public Group_table save(Group_table group_table) {
		return groupRepository.save(group_table);
	}

	public void delete(int group_id) {
		groupRepository.deleteById(group_id);
	}
}