package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.MovieRepository;

public class MovieActorApiControllerTests {
	
	
private MovieActorApiController controller;
	
	@Mock private ActorRepository actorRepo; 
	@Mock private MovieRepository movieRepo;
	private Movie movie;
	private Date date;
	private Actor actor;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);    //looks in test class  and add annotation to it
		controller = new MovieActorApiController(actorRepo, movieRepo);
		date = new Date();
		movie = new Movie("title", date, 100L, "distributor");
		
		actor = new Actor("Susan", "Ishaya", null, null);	
	}
	
	

	@Test
	public void creates_and_saves_movie_to_an_actor() {
		actor.setId(10L);
		movie.setId(15L);
		List<Actor> actorList = new ArrayList<Actor>();
		actorList.add(actor);
		movie.setActors(actorList);
		

		when(movieRepo.findOne(15L)).thenReturn(movie);
		when(actorRepo.findOne(10L)).thenReturn(actor);
		
		//Act
		Movie actual = controller.create(15L, 10L);
		
		// Assert
		assertThat(actual.getActors()).contains(actor);
		verify(movieRepo, never()).save(movie);
		verify(movieRepo).findOne(15L);
		verify(actorRepo).findOne(10L);
		 
	}
	
	
//	@Test    // test when not to save
//	public void create_does_not_save_a_movie_when_actor_already_has_it() {
//		
//		Actor actor = new Actor("Susan", "Ishaya", null, null);
//		ArrayList<Actor> actors = new ArrayList<Actor>();
//		actors.add(actor);
//		Movie movie = new Movie("title", Date releaseDate, );
//		dog.setOwners(actors);
//		 
//		
//		 
//		when(dogRepo.findOne(2L)).thenReturn(dog);
//		when(personRepo.findOne(3L)).thenReturn(person);
//		
//		
//		//Act
//		Dog actual = controller.create(2L, 3L);     //person is 3 l
//		
//		// Assert
//		
//		verify(dogRepo).findOne(2L);
//		verify(personRepo).findOne(3L);
//		
//		assertThat(actual).isSameAs(dog);
//		verify(dogRepo, never()).save(dog);
//		assertThat(dog.getOwners()).hasSize(1);
//	
//	
//	}
	
	
	
	

}
