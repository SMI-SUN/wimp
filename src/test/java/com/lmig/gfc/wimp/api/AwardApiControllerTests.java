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
import com.lmig.gfc.wimp.models.Award;

import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.AwardRepository;

public class AwardApiControllerTests {

	private AwardApiController controller;
	@Mock
	private AwardRepository awardRepo;
	@Mock
	private ActorRepository actorRepo;

	private Award award;
	private Actor actor;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this); // looks in test class and add annotation to it
		controller = new AwardApiController(awardRepo, actorRepo);
//		date = new Date();
		award = new Award("title", "organization", 1991);
		actor = new Actor("Susan", "Ishaya", null, null);
	}

	@Test
	public void creates_and_does_not_save_award_to_an_actor_if_actor_already_has_that_award() {
		actor.setId(10L);
		List<Actor> actorList = new ArrayList<Actor>();
		actorList.add(actor);
		award.setActor(actor);
		List<Award> awardList = new ArrayList<Award>();
		awardList.add(award);
		actor.setAwards(awardList);

		when(actorRepo.findOne(10L)).thenReturn(actor);
		

		// Act
		Actor actual = controller.create(10L, award);
//		when(awardRepo.save(award)).thenReturn(award);
		
		
		// Assert
		assertThat(actual.getAwards()).contains(award);
		verify(awardRepo, never()).save(award);
		verify(actorRepo).findOne(10L);

	}

	@Test
	public void creates_and_saves_award_to_an_actor() {
		actor.setId(10L);
		List<Actor> actorList = new ArrayList<Actor>();
		actorList.add(actor);
		award.setActor(actor);
		List<Award> awardList = new ArrayList<Award>();
		actor.setAwards(awardList);

		when(actorRepo.findOne(10L)).thenReturn(actor);
		

		// Act
		Actor actual = controller.create(10L, award);
//		when(awardRepo.save(award)).thenReturn(award);
		
		
		// Assert
		assertThat(actual.getAwards()).contains(award);
		verify(awardRepo).save(award);
		verify(actorRepo).findOne(10L);

	}
	
	
//check tomorrow with David why I have an error	
//	if (!actor.getAwards().contains(award)) {
//		actor.getAwards().add(award);
//		award.setActor(actor);
//		awardRepository.save(award);
//	}
//	return actor;

}
