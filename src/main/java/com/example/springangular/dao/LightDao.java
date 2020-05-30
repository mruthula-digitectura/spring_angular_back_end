package com.example.springangular.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springangular.repository.SpringRepository;
import com.example.springangular.entity.Light_table;



@Repository
public class LightDao {

	@Autowired
	private SpringRepository springRepository;

	public List<Light_table> get() {
		return springRepository.findAll();
	}

	public Light_table save(Light_table light_table) {
		return springRepository.saveAndFlush(light_table);
	}

	public void delete(int light_id) {
		springRepository.deleteById(light_id);
	}
}