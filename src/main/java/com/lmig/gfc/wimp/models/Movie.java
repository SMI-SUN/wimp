package com.lmig.gfc.wimp.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 300, nullable = false)
	private String title;

	@ManyToMany
	private List<Actor> actors;

	@Column(nullable = true)
	private Date releaseDate;

	@Column(nullable = true)
	private Long budget;

	@Column(length = 500, nullable = false)
	private String distributor;
	
	public Movie(String title, Date releaseDate, Long budget, String distributor) {  
		this.title = title;
		this.releaseDate = releaseDate;
		this.budget = budget;
		this.distributor = distributor;
	}

	public Movie() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

}
