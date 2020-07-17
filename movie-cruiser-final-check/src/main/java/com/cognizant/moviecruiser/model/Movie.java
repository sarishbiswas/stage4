package com.cognizant.moviecruiser.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "movies")
@Data
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	@Column
    private String title;
	@Column
    private String boxOffice;
	@Column
    private boolean active;
	@Column
    private Date dateOfLaunch;
	@Column
    private String genre;
	@ManyToMany//(mappedBy = "favourites")
	private Set<Customer> customers = new HashSet<>();
}
