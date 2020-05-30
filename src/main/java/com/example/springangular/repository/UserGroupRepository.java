package com.example.springangular.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springangular.entity.GroupLight;
import com.example.springangular.entity.UserGroup;


import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Integer> {
	
	@Query(value="select * from user_group_table u where u.user_id=:userId", nativeQuery = true)
	List<UserGroup> findByUserId(Integer userId);

}