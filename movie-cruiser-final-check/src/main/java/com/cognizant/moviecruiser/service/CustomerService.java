package com.cognizant.moviecruiser.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.Customer;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repository.CustomerRepository;
import com.cognizant.moviecruiser.repository.MovieRepository;

import lombok.extern.java.Log;
@Log
@Service
public class CustomerService {
	@Autowired
	MovieRepository repository;
	@Autowired
	CustomerRepository customerRepository;
	
	@Transactional
	public List<Movie> getAll() {
		log.info("START");
		log.info("END");
		return repository.findByActiveTrueAndDateOfLaunchBefore(new Date());
		
	}
	@Transactional
	public String addToFavourite(long customerId, long movieId) {
		log.info("START");
		Optional<Customer> c = customerRepository.findById(customerId);
		if(!c.isEmpty()){
			Optional<Movie> m = repository.findById(movieId);
			if(!m.isEmpty()) {
				Customer customer = c.get();
				Movie movie = m.get();
//				System.out.println(customer.getId()+" customer id");
//				System.out.println(movie.getTitle()+" movie title");
				List<Movie> set1 = customer.getFavourites();
				set1.add(movie);
				customer.setFavourites(set1);
				customerRepository.save(customer);
				log.info("END");
				return "SUCCESS";
			}
			else {
				log.info("END");
				return "Movie id "+movieId+" is not valid.";
			}
		}
		log.info("END");
		return "Customer id "+customerId+" is not valid.";
	}
	@Transactional
	public String addCustomer(long id) {
		log.info("START");
		Optional<Customer> c = customerRepository.findById(id);
		if(c.isEmpty()) {
			Customer cs = new Customer();
			cs.setId(id);
			customerRepository.save(cs);
			log.info("END");
			return "Customer added Successfully";
		}
		log.info("END");
		return "Customer Already Exist";
	}
	@Transactional
	public String deleteFromFavourites(long customerId, long movieId) {
		log.info("START");
		Optional<Customer> c = customerRepository.findById(customerId);
		if(!c.isEmpty()){
			Optional<Movie> m = repository.findById(movieId);
			if(!m.isEmpty()) {
				Customer customer = c.get();
				Movie movie = m.get();
				List<Movie> set1 = customer.getFavourites();
				set1.remove(movie);
				customer.setFavourites(set1);
				customerRepository.save(customer);
				log.info("END");
				return "SUCCESSFully Deleted From Favourites.";
			}
			else {
				log.info("END");
				return "Movie id "+movieId+" is not valid.";
			}
		}
		log.info("END");
		return "Customer id "+customerId+" is not valid.";
	}
	@Transactional
	public List<Movie> showFavourites(long customerId) {
		log.info("START");
		Optional<Customer> c = customerRepository.findById(customerId);
		if(!c.isEmpty()){
			Customer customer = c.get();
			log.info("END");
			return customer.getFavourites();
		}
		log.info("END");
		return null;
	}
}
