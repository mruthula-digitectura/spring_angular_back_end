package com.example.springangular.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.example.springangular.entity.Light_table;
import com.example.springangular.model.Response;
import com.example.springangular.service.LightService;


@RestController
@RequestMapping("/light-table")
public class LightController {

	@Autowired
	private LightService lightService;

	@GetMapping
	public ResponseEntity<Response> get() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response(lightService.get(), new Date()));
	}

	@PostMapping
	public ResponseEntity<Response> save(@RequestBody Light_table light_table) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response(lightService.save(light_table), new Date()));
	}

	@PutMapping
	public ResponseEntity<Response> update(@RequestBody Light_table light_table) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response(lightService.save(light_table), new Date()));
	}

	@DeleteMapping
	public ResponseEntity<Response> delete(@RequestParam("light_id") int light_id) {
		lightService.delete(light_id);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response(true, new Date()));
	}
}