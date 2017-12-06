package com.lmig.gfc.wimp.config;

import java.util.Date;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.MovieRepository;

@Configuration
public class SeedData {
	
	public SeedData(ActorRepository actorRepository, MovieRepository movieRepository) {
		actorRepository.save(new Actor("Susan", "Ishaya", null, null));
		 
		movieRepository.save(new Movie("All Dogs go to Heaven", null, null, "Warner brothers" ));
		
		
	}

}
