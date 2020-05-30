package com.example.springangular.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.springangular.entity.User_details_table;
import com.example.springangular.pojo.DisplayGroupRequest;
import com.example.springangular.pojo.UserDisplayRequest;
import com.example.springangular.pojo.UserLogService;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends JpaRepository<User_details_table, Integer> {
	
	@Query(value="select u.user_id from user_table u order by u.user_id desc limit 1;", nativeQuery = true)
	Integer findLastCreatedUser();
	
	@Query(value="select u.user_name ,u.password,u.first_name,u.last_name,u.user_type,g.group_id,l.light_id from user_table u ,light_table l,group_table g,user_light_table ul , user_group_table ug where u.user_id=ul.user_id and l.light_id=ul.light_id and u.user_id=ug.user_id and g.group_id=ug.group_id;", nativeQuery = true)
	List<UserDisplayRequest> findUserGroupLight();
	
//	@Query(value="select user_name ,password, user_type from user_table;", nativeQuery = true)
	
//	List <UserLogService> findLogUser();

}