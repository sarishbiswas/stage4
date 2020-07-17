package com.cognizant.moviecruiser.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customer {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "Customer_favourite", 
	        joinColumns = { @JoinColumn(name = "customer_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "movie_id") }
	)
	private List<Movie> favourites=new ArrayList<>();
}
