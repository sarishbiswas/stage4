package com.cognizant.moviecruiser.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repository.MovieRepository;

import lombok.extern.java.Log;
@Log
@Service
public class AdminService {
	@Autowired
	MovieRepository repository;
	
	@Transactional
	public String addMovie(Movie movie) {
		log.info("START");
		repository.save(movie);
		log.info("END");
		return "MOVIE ADDED SUCCESSFULLY";
	}

	public List<Movie> getAll() {
		log.info("START");
		log.info("END");
		return repository.findAll();
	}

	public String update(long id, Movie movie) {
		log.info("START");
		Optional<Movie> m = repository.findById(id);
		if(m.isPresent()) {
			Movie m1 = m.get();
			movie.setId(m1.getId());
			repository.save(movie);
			log.info("END");
			return "Successfully Updated the movie with id "+id;
		}
		log.info("END");
		return "The movie with id "+id+" is not found.";
	}
	
}
