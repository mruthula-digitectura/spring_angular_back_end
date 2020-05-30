package com.example.springangular.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springangular.entity.UserGroup;
import com.example.springangular.entity.UserLight;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserLightRepository extends JpaRepository<UserLight, Integer> {
	
	@Query(value="select * from user_light_table l where l.user_id=:userId", nativeQuery = true)
	List<UserLight> findByUserId(Integer userId);

}