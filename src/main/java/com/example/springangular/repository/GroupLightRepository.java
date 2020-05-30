package com.example.springangular.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springangular.entity.GroupLight;
import com.example.springangular.entity.UserLight;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface GroupLightRepository extends JpaRepository<GroupLight, Integer> {
	
	
	@Query(value="select * from group_light_table a where a.group_id=:groupId", nativeQuery = true)
	List<GroupLight> findByGroupId(Integer groupId);

}