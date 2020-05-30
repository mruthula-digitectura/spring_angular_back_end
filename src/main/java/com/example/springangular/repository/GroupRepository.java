package com.example.springangular.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springangular.entity.Group_table;
import com.example.springangular.pojo.DisplayGroupRequest;

@Repository
public interface GroupRepository extends JpaRepository<Group_table, Integer> {

	@Query(value="select a.group_id from Group_table a order by a.group_id desc limit 1", nativeQuery = true)
	Integer findLastCreatedGroup();
	
//	@Query(value="SELECT new DisplayGroupRequest(g.group_name,l.light_id) FROM Group_table as g, Light_table as l, GroupLight as gl WHERE g.group_id=gl.group_id and l.light_id=gl.light_id", nativeQuery = true)
//	List<DisplayGroupRequest> findGroupLight();
	

	
}