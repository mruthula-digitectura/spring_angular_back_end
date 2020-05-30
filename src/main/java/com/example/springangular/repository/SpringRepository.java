package com.example.springangular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springangular.entity.Light_table;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface SpringRepository extends JpaRepository<Light_table, Integer> {

	
}