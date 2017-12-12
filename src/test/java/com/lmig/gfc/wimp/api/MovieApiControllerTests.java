package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.ActorView;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.models.MovieView;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.MovieRepository;

public class MovieApiControllerTests {
	
	
	
	private MovieApiController controller;
	private MovieRepository repo;
	private Movie movie; 
	private Date date;
	
	@Before
	public void setUp() {
		repo = mock(MovieRepository.class);  // there should be an object in repo w this stat 
		controller = new MovieApiController(repo);
		movie = new Movie("All Dogs", null, 100L, "Warner");
		
			
	}
	@Test
	public void weWillNeverDoThisInRealLife() {
		assertThat(repo).isNotNull();
	}
	@Test
	public void getAll_movie_views_returns_list_of_movie_views() {   // change this based on the method in movie
		
		// arrange
		List<Movie> movies = new ArrayList<Movie>();
		when (repo.findAll()).thenReturn(movies);  // when method call that is being tested
		
		//Act  -calls get all method  on controller
		List<Movie> actual = controller.getAll();   //  movies and actual should have the same list
		
		//Assert
		assertThat(actual).hasSize(0);
		verify(repo).findAll();   // verifying mocked object have that method called.
		
	}
	
	@Test
	public void create_calls_save_and_returns_a_MovieView_with_the_Movie_in_it() {
		// Arrange
		when (repo.save(movie)).thenReturn(movie);

		// Act
		Movie actual = controller.create(movie);
		
		// Assert
		verify(repo).save(movie);
		assertThat(actual.getTitle()).isEqualTo("All Dogs");
		assertThat(actual.getBudget()).isEqualTo(100);
		assertThat(actual.getDistributor()).isEqualTo("Warner");
		assertThat(actual.getReleaseDate()).isNull();
	
	}
	
		
	@Test
	public void updates_one_for_a_valid_Actor_id() {
		// Arrange
		when (repo.save(movie)).thenReturn(movie);
		
		// Act
		Movie actual = controller.update(movie, 0L);
	
		// Assert
		verify(repo).save(movie);
		assertThat(actual.getTitle()).isEqualTo("All Dogs");
		assertThat(actual.getBudget()).isEqualTo(100);
		assertThat(actual.getDistributor()).isEqualTo("Warner");
		assertThat(actual.getReleaseDate()).isNull();
		
	}

	

	@Test
	public void gets_one_and_for_a_valid_Movie_id() {
		// Arrange
		when (repo.findOne(0L)).thenReturn(movie);
		
		// Act
		Movie actual = controller.getOne(0L);
	
		// Assert
		verify(repo).findOne(0L);
		assertThat(actual.getTitle()).isEqualTo("All Dogs");
		assertThat(actual.getBudget()).isEqualTo(100);
		assertThat(actual.getDistributor()).isEqualTo("Warner");
		assertThat(actual.getReleaseDate()).isNull();
	}
	
	@Test
	public void updates_one_for_a_valid_Movie_id() {
		// Arrange
		when (repo.save(movie)).thenReturn(movie);
		
		// Act
		Movie actual = controller.update(movie, 0L);
	
		// Assert
		verify(repo).save(movie);
		assertThat(actual.getTitle()).isEqualTo("All Dogs");
		assertThat(actual.getBudget()).isEqualTo(100);
		assertThat(actual.getDistributor()).isEqualTo("Warner");
		assertThat(actual.getReleaseDate()).isNull();
	}
	
	@Test
	public void delete_gets_the_movie_and_deletes_it_from_repo() {
		// Arrange
		when (repo.findOne(2L)).thenReturn(movie);
		 
		// Act
		Movie actual = controller.delete(2L);
		
		// Assert
		
		assertThat(actual.getTitle()).isEqualTo("All Dogs");
		assertThat(actual.getBudget()).isEqualTo(100);
		assertThat(actual.getDistributor()).isEqualTo("Warner");
		assertThat(actual.getReleaseDate()).isNull();
		verify(repo).findOne(2L);
		verify(repo).delete(2L);
		
		
	
	}
}
