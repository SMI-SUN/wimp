package com.lmig.gfc.wimp.api;


import org.springframework.http.HttpStatus;
 
 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.MovieRepository;

@RestController
@RequestMapping("/api/movies/{movieId}/actors")
public class MovieActorApiController {
	private ActorRepository actorRepository;
	private MovieRepository movieRepository;

	public MovieActorApiController(ActorRepository actorRepository, MovieRepository movieRepository) {
		this.actorRepository = actorRepository;
		this.movieRepository = movieRepository;
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Movie create(@PathVariable Long movieId, @RequestBody Long actorId) { 
		Actor actor = actorRepository.findOne(actorId);
		Movie movie = movieRepository.findOne(movieId);
		
		if (!movie.getActors().contains(actor)) {
			movie.getActors().add(actor); 
			movieRepository.save(movie);
		}
		return movie;
	}
}
