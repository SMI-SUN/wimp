package com.lmig.gfc.wimp.models;

import java.util.Date;

public class MovieView {

	private Movie movie;

	public MovieView(Movie movie) {

		this.movie = movie;

	}

	public Long getId() {
		return movie.getId();

	}

	public Date getReleaseDate() {
		return movie.getReleaseDate();
	}

	public String getTitle() {
		return movie.getTitle();
	}

	public String getDistributor() {
		return movie.getDistributor();
	}

	public Long getBudget() {
		return movie.getBudget();
	}

}
