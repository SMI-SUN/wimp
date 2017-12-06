package com.lmig.gfc.wimp.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.MovieRepository;

@RestController
@RequestMapping("/api/movies")
public class MovieApiController {

	private MovieRepository movieRepository;

	public MovieApiController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;

	}

	@GetMapping("")
	public List<Movie> getAll() {

		return movieRepository.findAll();

	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Movie create(@RequestBody Movie movie) {
		return movieRepository.save(movie);
	}
	
	@GetMapping("{id}")
	 public Movie getOne(@PathVariable Long id) {
		return movieRepository.findOne(id);
		
	}
	
	@PutMapping("{id}")
	 public Movie update(@RequestBody Movie movie,  @PathVariable Long id) {
		movie.setId(id);;
		return movieRepository.save(movie);
		 
		
	}
	
	@DeleteMapping("{id}")
	 public Movie delete(@PathVariable Long id) {
		// gets movie from db so i can return it later
		 
		Movie movie = movieRepository.findOne(id);
		//delete dog from db, in this case we are setting the value in the array to null
		movieRepository.delete(id);
		
		// return the dog i just deleted
		
	  return movie;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
