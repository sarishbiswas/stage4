package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.AdminService;

import lombok.extern.java.Log;
@Log
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService service;
	
	@PostMapping("/add")
	public String addMovie(@RequestBody Movie movie) {
		log.info("START");
		log.info("END");
		return service.addMovie(movie);
	}
	@GetMapping
	public List<Movie> getAll(){
		log.info("START");
		log.info("END");
		return service.getAll();
	}
	@PutMapping("/update/{id}")
	public String edit(@PathVariable(value="id") long id, @RequestBody Movie movie) {
		log.info("START");
		log.info("END");
		return service.update(id,movie);
	}
}
