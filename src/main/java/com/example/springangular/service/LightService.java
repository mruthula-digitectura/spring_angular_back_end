package com.example.springangular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springangular.dao.LightDao;
import com.example.springangular.entity.Light_table;

@Service
public class LightService {

	@Autowired
	private LightDao lightDao;

	public List<Light_table> get() {
		return lightDao.get();
	}

	public Light_table save(Light_table light_table) {
		return lightDao.save(light_table);
	}

	public void delete(int light_id) {
		lightDao.delete(light_id);
	}
}