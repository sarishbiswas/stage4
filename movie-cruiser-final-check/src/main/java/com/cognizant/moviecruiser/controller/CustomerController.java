package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.CustomerService;

import lombok.extern.java.Log;
@Log
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService service;
	@GetMapping("")
	public List<Movie> getAllForCustomer(){
		log.info("START");
		log.info("END");
		return service.getAll();
	}
	@GetMapping("/addtofavourite/{customerid}/{movieid}")
	public String addToFavourites(@PathVariable(name = "customerid") long customerId,@PathVariable(name = "movieid") long movieId) {
		log.info("START");
//		System.out.println("*************************Ani****************************");
		log.info("END");
		return service.addToFavourite(customerId,movieId);
	}
	@PostMapping("/addcustomer/{id}")
	public String addCustomer(@PathVariable(name="id") long id) {
		log.info("START");
		log.info("END");
		return service.addCustomer(id);
	}
	@DeleteMapping("/deletefromfavourites/{customerid}/{movieid}")
	public String deleteFromFavourites(@PathVariable(name = "customerid") long customerId,@PathVariable(name = "movieid") long movieId) {
		log.info("START");
		log.info("END");
		return service.deleteFromFavourites(customerId,movieId);
	}
	@GetMapping("/showfavourites/{id}")
	public List<Movie> showFavourites(@PathVariable(name="id") long customerId){
		log.info("START");
		log.info("END");
		return service.showFavourites(customerId);
	}
}
