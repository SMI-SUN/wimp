package com.lmig.gfc.wimp.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lmig.gfc.wimp.models.Movie;
@Repository

public interface MovieRepository extends JpaRepository<Movie, Long> {

	List<Movie> findByTitleIgnoringCase(String title);
	List<Movie> findByDistributorIgnoringCase(String distributor);
		
	}



