package com.lmig.gfc.wimp.config;



import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.MovieRepository;

@Configuration
public class SeedData {
	
	public SeedData(ActorRepository actorRepository, MovieRepository movieRepository) {
		Actor actor = actorRepository.save(new Actor("Susan", "Ishaya", null, null));
		 
		Movie movie = movieRepository.save(new Movie("All Dogs go to Heaven", null, null, "Warner brothers" ));
		
		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies.add(movie);
		actor.setMovies(movies); 
		actorRepository.save(actor);
	}

}
