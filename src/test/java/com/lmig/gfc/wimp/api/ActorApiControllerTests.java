package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;



import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.ActorView;
import com.lmig.gfc.wimp.services.ActorRepository;

public class ActorApiControllerTests {
	
		
	private ActorApiController controller;
	private ActorRepository repo;
	private Actor actor;  
	
	@Before
	public void setUp() {
		repo = mock(ActorRepository.class);  // there should be an object in repo w this stat 
		controller = new ActorApiController(repo);
		actor = new Actor("Susan", "Ishaya", null, null);
		
	}
	@Test
	public void weWillNeverDoThisInRealLife() {
		assertThat(repo).isNotNull();
	}
	@Test
	public void getAll_Actor_views_returns_list_of_actor_views() {   // change this based on the method in Actor
		
		// arrange
		List<Actor> actors = new ArrayList<Actor>();
		when (repo.findAll()).thenReturn(actors);  // when method call that is being tested
		
		//Act  -calls get all method  on controller
		List<ActorView> actual = controller.getAll();   // actor and  actua should have th same list
		
		//Assert
		assertThat(actual).hasSize(0);
		verify(repo).findAll();   // verifying mocked object have that method called.
		
	}
	
	@Test
	public void create_calls_save_and_returns_an_ActorView_with_the_Actor_in_it() {
		// Arrange

		// Act
		ActorView actual = controller.create(actor);
		
		// Assert
		verify(repo).save(actor);
		assertThat(actual.getFirstName()).isEqualTo("Susan");
		assertThat(actual.getLastName()).isEqualTo("Ishaya");
		assertThat(actual.getActiveSinceYear()).isNull();
		assertThat(actual.getBirthDate()).isNull();
		assertThat(actual.getAwards()).isNull();
	}
	
	

	
	@Test
	public void gets_one_and_for_a_valid_Actor_id() {
		// Arrange
		when (repo.findOne(0L)).thenReturn(actor);
		
		// Act
		ActorView actual = controller.getOne(0L);
	
		// Assert
		verify(repo).findOne(0L);
		assertThat(actual.getFirstName()).isEqualTo("Susan");
		assertThat(actual.getLastName()).isEqualTo("Ishaya");
		assertThat(actual.getActiveSinceYear()).isNull();
		assertThat(actual.getBirthDate()).isNull();
		assertThat(actual.getAwards()).isNull();
	}
	
	@Test
	public void updates_one_for_a_valid_Actor_id() {
		// Arrange
		when (repo.save(actor)).thenReturn(actor);
		
		// Act
		ActorView actual = controller.update(actor, 0L);
	
		// Assert
		verify(repo).save(actor);
		assertThat(actual.getFirstName()).isEqualTo("Susan");
		assertThat(actual.getLastName()).isEqualTo("Ishaya");
		assertThat(actual.getActiveSinceYear()).isNull();
		assertThat(actual.getBirthDate()).isNull();
		assertThat(actual.getAwards()).isNull();
	}
	
	@Test
	public void delete_gets_the_actor_and_deletes_it_from_repo() {
		// Arrange
		when (repo.findOne(1L)).thenReturn(actor);
		 
		// Act
		ActorView actual = controller.delete(1L);
		
		// Assert
		
		assertThat(actual.getFirstName()).isEqualTo("Susan");
		assertThat(actual.getLastName()).isEqualTo("Ishaya");
		assertThat(actual.getActiveSinceYear()).isNull();
		assertThat(actual.getBirthDate()).isNull();
		assertThat(actual.getAwards()).isNull();
		verify(repo).findOne(1L);
		verify(repo).delete(1L);
		
		
	
	}
	
	

}
